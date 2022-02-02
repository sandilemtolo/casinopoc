package com.dagacube.casinopoc.service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.dagacube.casinopoc.dao.PlayerDao;
import com.dagacube.casinopoc.dao.TransactionDao;
import com.dagacube.casinopoc.dao.TransactionTypeDao;
import com.dagacube.casinopoc.exception.XPlayerAlreadyExists;
import com.dagacube.casinopoc.exception.XPlayerDoesNotExist;
import com.dagacube.casinopoc.interfaces.TransactionDateAscComparator;
import com.dagacube.casinopoc.model.Balance;
import com.dagacube.casinopoc.model.Player;
import com.dagacube.casinopoc.model.RecentTransaction;
import com.dagacube.casinopoc.model.Transaction;
import com.dagacube.casinopoc.model.TransactionType;
import com.dagacube.casinopoc.model.Wager;
import com.dagacube.casinopoc.model.Win;
import com.dagacube.casinopoc.model.TransactionType.TransactionTypeName;
import com.dagacube.casinopoc.util.KeyID;
import com.dagacube.casinopoc.util.StatusCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasinoService {
	private static Object db_mutex = new Object();
	private PlayerDao player_dao;
	private TransactionDao transaction_dao;
	private TransactionTypeDao transaction_type_dao;

	private HashMap<String, TransactionType> transaction_types_map = new HashMap<String, TransactionType>(); // TODO: Ideally, this should be static
	private final static String SUPER_UNSAFE_PASSWORD = "swordfish";

	private static List<String> potential_player_fields = new LinkedList<>();

	@Autowired
	public CasinoService(PlayerDao player_dao, TransactionDao transaciton_dao, TransactionTypeDao transaciton_type_dao) {
		this.player_dao = player_dao;
		this.transaction_dao = transaciton_dao;
		this.transaction_type_dao = transaciton_type_dao;

		loadTransactionTypes();
	}

	private void loadTransactionTypes() {
		List<TransactionType> transaction_types = transaction_type_dao.findAll();

		for (TransactionType transaction_type : transaction_types) {
			transaction_types_map.put(transaction_type.getTransactionTypeName(), transaction_type);
		}
	}

	public Balance getBalance(Integer pid)
	throws XPlayerDoesNotExist, JSONException {
		Balance balance = new Balance();
		balance.setPlayerId(pid);
		return getBalance(balance);
	}

	public Balance getBalance(Balance balance)
	throws XPlayerDoesNotExist, JSONException {
		balance.validate();

		Player player = getPlayer(balance.getPlayerId());
		
		balance.setBalance(player.getBalance());

		return balance;
	}
	
	public Player getPlayer(Player player) {
		player.validate();

		Optional<Player> possible_player = null;
		XPlayerDoesNotExist exception = null;

		if (player.getPlayerId() != null) {
			possible_player = player_dao.getPlayerById(player.getPlayerId());
			exception = new XPlayerDoesNotExist(player.getPlayerId());
		} else if (player.getUsername() != null) {
			possible_player = player_dao.getPlayerByUsername(player.getUsername());
			exception = new XPlayerDoesNotExist(player.getUsername());
		}

		if (possible_player != null &&
			possible_player.isPresent()) {
			return possible_player.get();
		}

		throw exception;
	}

	public Player getPlayer(Integer pid)
	throws XPlayerDoesNotExist {
		Player player = new Player();
		player.setPlayerId(pid);

		return getPlayer(player);
	}

	public Player registerPlayer(Integer transactionid, Player player)
	throws JsonMappingException, JsonProcessingException, XPlayerAlreadyExists {
		if (!processedTransaction(transactionid)) {
			if (!playerExists(player)) {
				player = savePlayer(player);
			}
			else {
				throw new XPlayerAlreadyExists();
			}
			registerRegisterPlayerTransaction(transactionid, player);
		} else {
			Transaction transaction = transaction_dao.getById(transactionid);
			player = player_dao.getById(transaction.getPlayerId());
		}
		return player;
	}

	private Transaction registerRegisterPlayerTransaction(Integer transaction_id, Player player) {
		Transaction transaction = new Transaction(transaction_id, player.getPlayerId(), new Date(), transaction_types_map.get(TransactionTypeName.REGISTER_PLAYER.name()));
		return saveTransaction(transaction);
	}

	private Player savePlayer(Player player) {
		synchronized(db_mutex) {
			return player_dao.save(player);
		}
	}

	private Transaction saveTransaction(Transaction transaction) {
		synchronized(db_mutex) {
			return transaction_dao.save(transaction);
		}
	}

	private boolean processedTransaction(Integer transactionid) {
		return transaction_dao.findById(transactionid).isPresent();
	}

	private boolean playerExists(Player player) {
		return player != null ? player_dao.getPlayerByUsername(player.getUsername()).isPresent() : false;
	}

	public List<Transaction> getPlayersRecentTransactionsByType(RecentTransaction recent_transaction, TransactionTypeName transaction_type)
	throws XPlayerDoesNotExist, JSONException {
		recent_transaction.validate();
		Player player = new Player();
		player.setUsername(recent_transaction.getUsername());
		
		player = getPlayer(player);

		if (SUPER_UNSAFE_PASSWORD.equals(recent_transaction.getPassword())) {
			return getPlayersRecentTransactionsByType(player, transaction_type, recent_transaction.getNumber());
		}
		return new LinkedList<Transaction>();

	}

	private List<Transaction> getPlayersRecentTransactionsByType(Player player, TransactionTypeName transaction_type, Integer number) {
		/**For the record, I hate this! I'd rather use a Stored Proc to do this but H2 says no dice..boooo! */
		List<Transaction> transactions = new LinkedList<>();
		List<Transaction> all_transactions = transaction_dao.getPlayersLastXTransactionsByType(player.getPlayerId(), transaction_types_map.get(transaction_type.name()).getTransactionTypeId());

		for (int i = 0; i < number; i++) {
			if (!all_transactions.isEmpty()) {
				transactions.add(all_transactions.remove(0));
			} else { 
				break;
			}
		}

		Collections.sort(transactions, new TransactionDateAscComparator());
		return transactions;
	}

	public Wager makeWager(Wager wager) throws XPlayerDoesNotExist {
		wager.validate();
		
		if (!processedTransaction(wager.getTranactionId())) {
			Player player = getPlayer(wager.getPlayerId());
			Transaction transaction = new Transaction(wager.getTranactionId(), player, new Date(), transaction_types_map.get(TransactionType.TransactionTypeName.WAGER.name()));
			transaction.setAmount(wager.getWager());
			player.setBalance(player.getBalance() - transaction.getAmount());

			if (!player.hasFunds()) {
				wager.setStatus(StatusCode.TEAPOT);
			} else {
				wager.setStatus(StatusCode.SUCCESS);
			}

			commit(player, transaction);
		}

		return wager;
	}

	public Win makeWin(Win win) throws XPlayerDoesNotExist {
		win.validate();
		
		if (!processedTransaction(win.getTranactionId())) {
			Player player = getPlayer(win.getPlayerId());
			Transaction transaction = new Transaction(win.getTranactionId(), player, new Date(), transaction_types_map.get(TransactionType.TransactionTypeName.WIN.name()));
			transaction.setAmount(win.getWin());
			player.setBalance(player.getBalance() + transaction.getAmount());

			commit(player, transaction);
		}
		return win;
	}

	private void commit(Player player, Transaction transaction) {
		if (player != null) {
			savePlayer(player);
		}
		
		if (transaction != null) {
			saveTransaction(transaction);
		}
	}
	
	static {

		potential_player_fields.add(KeyID.PLAYER_ID);
		potential_player_fields.add(KeyID.USERNAME);
	}
}
