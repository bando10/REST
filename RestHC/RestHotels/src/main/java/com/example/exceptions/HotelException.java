package com.example.exceptions;

import java.io.Serial;

public class HotelException extends Exception {
	
	@Serial
	private static final long serialVersionUID = 1L;

	public HotelException() {
		super();
	}

	public HotelException(String message) {
		super(message);
	}
	
	
}
