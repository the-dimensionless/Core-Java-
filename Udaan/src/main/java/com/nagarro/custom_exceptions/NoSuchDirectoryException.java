package com.nagarro.custom_exceptions;

public class NoSuchDirectoryException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchDirectoryException(String s) {
		super(s);
		System.out.println("Specified Directory could not be located.");
	}

}
