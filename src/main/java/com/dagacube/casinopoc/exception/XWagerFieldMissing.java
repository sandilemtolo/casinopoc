package com.dagacube.casinopoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class XWagerFieldMissing extends RuntimeException {
	public XWagerFieldMissing(String missing_field) {
		super(String.format("Wager field \"%s\" is required but is missing.", missing_field));
	}
}
