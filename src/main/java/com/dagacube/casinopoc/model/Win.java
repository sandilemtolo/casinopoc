package com.dagacube.casinopoc.model;

import com.dagacube.casinopoc.exception.XWagerFieldMissing;
import com.dagacube.casinopoc.interfaces.IValidator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Win implements IValidator {
	private Integer tid = null;
	private Integer pid = null;
	private Long win = null;
	private Integer staus = null;

	public Win() {

	}

	@JsonProperty("tid")
	public Integer getTranactionId() {
		return this.tid;
	}

	@JsonProperty("pid")
	public Integer getPlayerId() {
		return this.pid;
	}

	public Long getWin() {
		return this.win;
	}

	public Integer getStatus() {
		return this.staus;
	}

	@JsonProperty("tid")
	public void setTransactionId(Integer tid) {
		this.tid = tid;
	}

	@JsonProperty("pid")
	public void setPlayerId(Integer pid) {
		this.pid = pid;
	}

	public void setWin(Long win) {
		this.win = win;
	}

	public void setStatus(Integer staus) {
		this.staus = staus;
	}

	@Override
	public void validate() {
		if (pid == null) {
			throw new XWagerFieldMissing("pid");
		} else if (tid == null) {
			throw new XWagerFieldMissing("tid");
		} else if (win == null) {
			throw new XWagerFieldMissing("win");
		}
		
	}


}
