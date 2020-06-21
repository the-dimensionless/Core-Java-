package com.nagarro.custom_exceptions;

public class InvalidFareException extends InvalidContentsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFareException() {
		super("The fare for this particular flight is invalid. Contact Support");
	}

}
