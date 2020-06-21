/**
* Class name : FlightDetailsFactory
*
* Author info : @Sumit Kumar Singh
*
* Description : Class responsible for creating a valid FlightQueryInstance object.
* 				Tests the user input by splitting and validating.
*/
package com.nagarro.model;

import com.nagarro.validators.InputSplitterValidator;

public class FlightDetailsFactory {

	private FlightDetails instance;
	private static String userInput;
	public static String sortingBasis;
	
	public FlightDetailsFactory() {
	}
	
	/**
	 * @return instance : Type FlightDetails
	 */
	public FlightDetails getFlightDetailsInstance() {
		this.instance = new InputSplitterValidator(userInput).getInstance();
		return this.instance;
	}
	
	public void setUserInput(String string) {
		userInput = string;
	}
	
	/**
	 * @return userInput : the stored current user query (for persistence)
	 */
	public static String getCurrentQuery() {
		return userInput;
	}

}
