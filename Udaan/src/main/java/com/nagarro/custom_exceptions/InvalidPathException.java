package com.nagarro.custom_exceptions;

public class InvalidPathException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPathException() {
		super("Please check the path you have provided");
		this.getStackTrace();
	}

}
