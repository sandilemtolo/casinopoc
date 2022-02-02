package com.dagacube.casinopoc.model;

import com.dagacube.casinopoc.exception.XWinFieldMissing;
import com.dagacube.casinopoc.interfaces.IValidator;

public class RecentTransaction implements IValidator {
	private String password = null;
	private String username = null;
	private Integer number = 10;

	public RecentTransaction() {

	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUsername(Integer number) {
		this.number = number;
	}

	@Override
	public void validate() {
		if (password == null) {
			throw new XWinFieldMissing("password");
		} else if (username == null) {
			throw new XWinFieldMissing("username");
		}
	}
	
}
