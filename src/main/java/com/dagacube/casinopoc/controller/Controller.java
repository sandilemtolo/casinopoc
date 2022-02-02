package com.dagacube.casinopoc.controller;

import java.util.List;
import java.util.Map;

import com.dagacube.casinopoc.exception.XPlayerAlreadyExists;
import com.dagacube.casinopoc.exception.XPlayerDoesNotExist;
import com.dagacube.casinopoc.model.Balance;
import com.dagacube.casinopoc.model.Player;
import com.dagacube.casinopoc.model.RecentTransaction;
import com.dagacube.casinopoc.model.Transaction;
import com.dagacube.casinopoc.model.Wager;
import com.dagacube.casinopoc.model.Win;
import com.dagacube.casinopoc.model.TransactionType.TransactionTypeName;
import com.dagacube.casinopoc.service.CasinoService;
import com.dagacube.casinopoc.util.KeyID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class Controller {
	private final CasinoService service;

	@Autowired
	public Controller(CasinoService service) {
		this.service = service;
	}
	
	@GetMapping(path = "/get/player/balance", params = KeyID.PLAYER_ID,  produces = {MediaType.APPLICATION_JSON_VALUE})
	public Balance getBalance(@RequestParam(value = KeyID.PLAYER_ID, required = true) Integer pid)
	throws XPlayerDoesNotExist, JSONException {
			return service.getBalance(pid);
	}
	
	@GetMapping(path = "/get/player/balance", consumes = {MediaType.APPLICATION_JSON_VALUE},  produces = {MediaType.APPLICATION_JSON_VALUE})
	public Balance getBalance(@RequestBody Balance balance)
	throws XPlayerDoesNotExist, JSONException {
			return service.getBalance(balance);
	}
	
	@GetMapping(path = "/get/player", params = KeyID.PLAYER_ID)
	public Player getPlayer(@RequestParam(value = KeyID.PLAYER_ID, required = true) Integer pid)
	throws XPlayerDoesNotExist, JSONException {
		return service.getPlayer(pid);
	}
	
	@GetMapping(path = "/get/player", consumes = {MediaType.APPLICATION_JSON_VALUE},  produces = {MediaType.APPLICATION_JSON_VALUE})
	public Player getPlayer(@RequestBody Player player)
	throws XPlayerDoesNotExist, JSONException {
		return service.getPlayer(player);
	}

	@PostMapping(path = "/get/recent/wins", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public List<Transaction> getRecentWins(@RequestBody RecentTransaction recent_transaction)
	throws NumberFormatException, XPlayerDoesNotExist, JSONException {
		return service.getPlayersRecentTransactionsByType(recent_transaction, TransactionTypeName.WIN);
	}
	
	@PostMapping(path = "/get/recent/wagers", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public List<Transaction> getRecentWagers(@RequestBody RecentTransaction recent_transaction)
	throws NumberFormatException, XPlayerDoesNotExist, JSONException {
		return service.getPlayersRecentTransactionsByType(recent_transaction, TransactionTypeName.WAGER);
	}

	@PostMapping(path = "/player/register", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Player registerPlayer(@RequestParam(value = KeyID.TRANSACTION_ID, required = true) Integer tid, @RequestBody Player player)
	throws JsonMappingException, JsonProcessingException, XPlayerAlreadyExists {
			return service.registerPlayer(tid, player);
	}
	
	@PostMapping(path = "/post/wager", consumes = {MediaType.APPLICATION_JSON_VALUE},  produces = {MediaType.APPLICATION_JSON_VALUE})
	public Wager makeWager(@RequestBody Wager wager) throws XPlayerDoesNotExist {
		return service.makeWager(wager);
	}
	
	@PostMapping(path = "/post/win", consumes = {MediaType.APPLICATION_JSON_VALUE},  produces = {MediaType.APPLICATION_JSON_VALUE})
	public Win makeWin(@RequestBody Win win) throws XPlayerDoesNotExist {
		return service.makeWin(win);
	}
}
