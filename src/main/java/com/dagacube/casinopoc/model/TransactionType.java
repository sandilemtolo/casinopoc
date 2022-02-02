package com.dagacube.casinopoc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "transaction_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TransactionType {
	@Id
	@Column(name = "ttid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ttid = null;
	
	@Column(name = "tname")
	private String tname = null;

	public TransactionType() {

	}

	public Integer getTransactionTypeId() {
		return this.ttid;
	}
	
	public String getTransactionTypeName() {
		return this.tname;
	}

	public void setTransactionTypeId(Integer ttid) {
		this.ttid = ttid;
	}
	
	public void setTransactionTypeName(String tname) {
		this.tname = tname;
	}
	
	public static enum TransactionTypeName {
		BALANCE_CHECK, WIN, WAGER, REGISTER_PLAYER;
	}
}
