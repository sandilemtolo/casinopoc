package com.dagacube.casinopoc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dagacube.casinopoc.exception.XPlayerFieldMissing;
import com.dagacube.casinopoc.interfaces.IValidator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "player")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player implements IValidator {
	@Id
	@Column(name = "pid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid = null;
	
	@Column(name = "username")
	private String username = null;
	
	@Column(name = "name")
	private String name = null;
	
	@Column(name = "surname")
	private String surname = null;
	
	@Column(name = "balance")
	private Long balance = 0L;

	public Player() {

	}

	public Player(String username, String name, String surname, Long balance) {
		setUsername(username);
		setName(name);
		setSurname(surname);
		setBalance(balance);
	}

	@JsonProperty("pid") // Hints that the JSON key name for Player Id field should be "pid", and not "playerId"
	public Integer getPlayerId() {
		return this.pid;
	}

	public String getUsername() {
		return this.username;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public Long getBalance() {
		return this.balance;
	}

	@JsonProperty("pid") // Hints that the JSON field Id for this object should be "pid", and not "playerId"
	public void setPlayerId(Integer pid) {
		this.pid = pid;
	}

	public void setUsername(String username) {
		if (username != null) {
			this.username = username;
		}
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	public void setSurname(String surname) {
		if (surname != null) {
			this.surname = surname;
		}
	}

	public void setBalance(Long balance) {
		if (balance != null) {
			this.balance = balance;
		}
	}

	public boolean hasFunds() {
		return balance > 0;
	}

	@Override
	public void validate() {
		if (pid == null && username == null) {
			throw new XPlayerFieldMissing("pid/username");
		}
		
	}
}
