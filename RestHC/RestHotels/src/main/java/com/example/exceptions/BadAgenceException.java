package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serial;

public class BadAgenceException extends ResponseStatusException{

	@Serial
	private static final long serialVersionUID = 1L;

	public BadAgenceException(String reason) {
		super(HttpStatus.FORBIDDEN, reason);
	}

}
