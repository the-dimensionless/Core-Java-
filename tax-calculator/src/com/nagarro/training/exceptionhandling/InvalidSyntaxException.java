package com.nagarro.training.exceptionhandling;
/*
 * Class for exceptions arising out of syntax problems
 */
public class InvalidSyntaxException extends ItemInvalidatedException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSyntaxException(String s) {
		super(s+"\nPlease adhere to syntax of commands as given above.\n");
	}
	
}


