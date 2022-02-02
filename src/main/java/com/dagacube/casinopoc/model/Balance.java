package com.dagacube.casinopoc.model;

import com.dagacube.casinopoc.exception.XBalanceFieldMissing;
import com.dagacube.casinopoc.interfaces.IValidator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Balance implements IValidator{
	private Integer tid = null;
	private Integer pid = null;
	private Long balance = null;

	public Balance() {

	}

	@JsonProperty("tid")
	public Integer getTransactionId() {
		return this.tid;
	}

	@JsonProperty("pid")
	public Integer getPlayerId() {
		return this.pid;
	}

	public Long getBalance() {
		return this.balance;
	}

	@JsonProperty("tid")
	public void setTransactionId(Integer tid) {
		this.tid = tid;
	}

	@JsonProperty("pid")
	public void setPlayerId(Integer pid) {
		this.pid = pid;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	@Override
	public void validate() {
		if (pid == null) {
			throw new XBalanceFieldMissing("pid");
		}
	}
}
