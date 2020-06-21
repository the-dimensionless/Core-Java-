package com.nagarro.custom_exceptions;

public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String s) {
		super(s+"\nThe input has been invalidated. Please try again !");
	}

}
