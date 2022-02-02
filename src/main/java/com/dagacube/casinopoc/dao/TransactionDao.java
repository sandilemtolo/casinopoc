package com.dagacube.casinopoc.dao;

import java.util.List;
import java.util.Optional;

import com.dagacube.casinopoc.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {

	@Query("SELECT t FROM Transaction t WHERE t.tid = ?1")
	Optional<Transaction> getTransactionByTransactionId(Integer transactionId);

	//SELECT TOP %s * FROM transaction t WHERE t.pid = %s AND t.ttid = %s ORDER by tdate DESC"
	@Query("SELECT t FROM Transaction t WHERE t.pid = ?1 AND t.ttid = ?2 ORDER by tdate DESC")
	List<Transaction> getPlayersLastXTransactionsByType(Integer pid, Integer transactionTypeId);
	
}
