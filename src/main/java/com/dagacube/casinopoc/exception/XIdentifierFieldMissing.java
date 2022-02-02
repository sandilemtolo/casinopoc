package com.dagacube.casinopoc.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class XIdentifierFieldMissing extends RuntimeException {
	public XIdentifierFieldMissing(List<String> identifiers) {
		super(String.format("One of the following field identifiers is missing: %s", identifiers.toString()));
	}
	
}
