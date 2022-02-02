package com.dagacube.casinopoc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "transactions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {
	@Id
	@Column(name = "tid")
	private Integer tid = null;
	
	@Column(name = "pid")
	private Integer pid = null;
	
	@Column(name = "tdate")
	private Date tdate = null;
	
	@Column(name = "ttid")
	private Integer ttid = null;
	
	@Column(name = "amount")
	private Long amount = 0L;

	public Transaction() {

	}

	public Transaction(Integer tid, Integer pid, Date tdate, Integer ttid) {
		setTranasctionId(tid);
		setPlayerId(pid);
		setTransactionDate(tdate);
		setTransactonTypeId(ttid);
	}

	public Transaction(Integer tid, Integer pid, Date tdate, TransactionType tt) {
		setTranasctionId(tid);
		setPlayerId(pid);
		setTransactionDate(tdate);
		setTransactonTypeId(tt.getTransactionTypeId());
	}
	
	public Transaction(Integer tid, Player player, Date tdate, TransactionType tt) {
		setTranasctionId(tid);
		setPlayerId(player.getPlayerId());
		setTransactionDate(tdate);
		setTransactonTypeId(tt.getTransactionTypeId());
	}
	
	public Transaction(Integer tid, Player player, Date tdate, TransactionType tt, Long amount) {
		setTranasctionId(tid);
		setPlayerId(player.getPlayerId());
		setTransactionDate(tdate);
		setTransactonTypeId(tt.getTransactionTypeId());
		setAmount(amount);
	}

	@JsonProperty("tid")
	public Integer getTransactionId() {
		return this.tid;
	}

	@JsonProperty("pid")
	public Integer getPlayerId() {
		return this.pid;
	}

	@JsonProperty("tdate")
	public Date getTransactionDate() {
		return this.tdate;
	}

	@JsonProperty("ttid")
	public Integer getTransactonTypeId() {
		return this.ttid;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setTranasctionId(Integer tid) {
		this.tid = tid;
	}

	public void setPlayerId(Integer pid) {
		this.pid = pid;
	}

	public void setTransactionDate(Date tdate) {
		this.tdate = tdate;
	}

	public void setTransactonTypeId(Integer ttid) {
		this.ttid = ttid;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
}
