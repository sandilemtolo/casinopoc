package com.dagacube.casinopoc.exception;

public class XBalanceFieldMissing extends RuntimeException {
	public XBalanceFieldMissing(String missing_field) {
		super(String.format("Balance field \"%s\" is required but is missing.", missing_field));
	}
}
