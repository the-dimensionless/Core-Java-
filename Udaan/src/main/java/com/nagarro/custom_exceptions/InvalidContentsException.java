package com.nagarro.custom_exceptions;

public class InvalidContentsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidContentsException(String s) {
		super(s+"\nThe contents of flight dataset do not conform to standards. Contact Support");
	}

}
