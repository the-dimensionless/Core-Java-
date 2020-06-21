package com.nagarro.custom_exceptions;

public class InvalidEntryException extends InvalidInputException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidEntryException(String s) {
		super("You have entered wrong value for "+s);
	}

}
