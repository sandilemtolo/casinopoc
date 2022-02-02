package com.dagacube.casinopoc.dao;

import com.dagacube.casinopoc.model.TransactionType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeDao extends JpaRepository<TransactionType, Integer> {
	
}
