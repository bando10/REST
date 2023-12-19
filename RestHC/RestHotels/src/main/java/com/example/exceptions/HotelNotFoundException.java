package com.example.exceptions;

import java.io.Serial;

public class HotelNotFoundException extends HotelException {

	@Serial
	private static final long serialVersionUID = 1L;

	public HotelNotFoundException() {
		super();
	}

	public HotelNotFoundException(String message) {
		super(message);

	}

}
