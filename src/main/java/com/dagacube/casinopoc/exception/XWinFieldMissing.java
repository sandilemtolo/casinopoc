package com.dagacube.casinopoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class XWinFieldMissing extends RuntimeException {
	public XWinFieldMissing(String missing_field) {
		super(String.format("Win field \"%s\" is required but is missing.", missing_field));
	}
}
