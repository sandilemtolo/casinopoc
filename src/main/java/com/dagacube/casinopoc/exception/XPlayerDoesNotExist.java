package com.dagacube.casinopoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class XPlayerDoesNotExist extends RuntimeException {
	public XPlayerDoesNotExist(String username) {
		super(String.format("Player username=\"%s\" does not exist.", username));
	}
	public XPlayerDoesNotExist(Integer pid) {
		super(String.format("Player pid=\"%s\" does not exist.", pid));
	}
}
