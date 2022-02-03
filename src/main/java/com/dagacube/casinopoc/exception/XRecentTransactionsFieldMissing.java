package com.dagacube.casinopoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class XRecentTransactionsFieldMissing extends RuntimeException {
	public XRecentTransactionsFieldMissing(String missing_field) {
		super(String.format("Field \"%s\" is required but is missing.", missing_field));
	}
}
