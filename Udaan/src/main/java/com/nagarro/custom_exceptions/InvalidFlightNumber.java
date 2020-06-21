package com.nagarro.custom_exceptions;

public class InvalidFlightNumber extends InvalidContentsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFlightNumber(String s) {
		super("Given file has an InvalidFlightNumber. Please check.");
		this.printStackTrace();
	}

}
