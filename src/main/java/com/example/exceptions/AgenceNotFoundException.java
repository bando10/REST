package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serial;

public class AgenceNotFoundException extends ResponseStatusException{

	@Serial
	private static final long serialVersionUID = 1L;

	public AgenceNotFoundException(String reason) {
		super(HttpStatus.NOT_FOUND, reason);
	}

}
