package com.dagacube.casinopoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class XPlayerAlreadyExists extends RuntimeException {
	
}
