package com.nagarro.training.exceptionhandling;

public class ItemInvalidatedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemInvalidatedException(String s) {
		super(s);
	}

}

class InvalidQuantityEntryException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidQuantityEntryException(String s) {
		super(s);
	}
}
