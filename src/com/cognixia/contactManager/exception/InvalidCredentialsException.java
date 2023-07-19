package com.cognixia.contactManager.exception;

public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidCredentialsException() {
		super("Incorrect username and password.");
	}

}
