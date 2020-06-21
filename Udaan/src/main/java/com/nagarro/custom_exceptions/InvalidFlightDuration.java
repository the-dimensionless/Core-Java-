package com.nagarro.custom_exceptions;

public class InvalidFlightDuration extends InvalidContentsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFlightDuration() {
		super("The Flight Duration for this particular flight is Invalid. Contact Support");
		this.printStackTrace();
	}

}
