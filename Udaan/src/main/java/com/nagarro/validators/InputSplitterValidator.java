/**
* Class name : InputSplitterValidator
*
* Author info : @Sumit Kumar Singh
*
* Description : Class responsible for validating user query string after splitting them.
*/
package com.nagarro.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.nagarro.custom_exceptions.InvalidEntryException;
import com.nagarro.custom_exceptions.InvalidInputException;
import com.nagarro.model.FlightDetails;
import com.nagarro.model.FlightDetailsFactory;

public class InputSplitterValidator {

	private FlightDetails flightDetailsInstance;
	private boolean isValidQuery = true;
	public InputSplitterValidator(String s) {
		
		String input[] = s.split(" ");
		if (input.length != 5 ) {
			try {
				throw new InvalidInputException("You have entered insufficient number of parameters");
			} catch (InvalidInputException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				isValidQuery = false;
				return;
			}
		}
		
		flightDetailsInstance = new FlightDetails();
		
		String temporaryStorage = input[0];		// Departure Location is supposed to be a 3 letter String
		if ( !temporaryStorage.matches("[a-zA-Z]"+"[a-zA-Z]"+"[a-zA-Z]") || temporaryStorage.length() != 3) {
			try {
				throw new InvalidEntryException("Format of input for Departure Location is incorrect ");
			} catch (InvalidEntryException e) {
//				e.printStackTrace();
				System.out.println(e.getMessage());
				isValidQuery = false;
			}
		}
		
		flightDetailsInstance.setDEP_LOC(temporaryStorage);

       temporaryStorage = input[1];
       if ( !temporaryStorage.matches("[a-zA-Z]"+"[a-zA-Z]"+"[a-zA-Z]") || temporaryStorage.length() != 3) {
			try {
				throw new InvalidEntryException("Format of input for Arrival Location is incorrect ");
			} catch (InvalidEntryException e) {
//				e.printStackTrace();
				System.out.println(e.getMessage());
				isValidQuery = false;
			}
		}

       flightDetailsInstance.setARR_LOC(temporaryStorage);
      
       temporaryStorage = input[2];
       try {
    	   flightDetailsInstance.setVALID_TILL(LocalDate.parse(temporaryStorage, 
    			   DateTimeFormatter.ofPattern("dd-MM-yyyy")));
       } catch (DateTimeParseException dte) {
    	   try {
			throw new InvalidInputException("Format of input for Valid Till Date is incorrect");
		} catch (InvalidInputException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			isValidQuery = false;
		}
       }
      
       temporaryStorage = input[3];
       if (temporaryStorage.equalsIgnoreCase("E") && !temporaryStorage.isEmpty()) {
    	   flightDetailsInstance.setCLASS("E");
       } else if (temporaryStorage.equalsIgnoreCase("EB") && !temporaryStorage.isEmpty()) {
    	   flightDetailsInstance.setCLASS("EB");
       } else {
    	   try {
			throw new InvalidInputException("Type of flight travel class is incorrect");
		} catch (InvalidInputException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			isValidQuery = false;
		}
       }

       temporaryStorage = input[4];
       if (!temporaryStorage.isEmpty() && temporaryStorage.equalsIgnoreCase("Fare")) {
    	   flightDetailsInstance.setOUTPUT_PREFERENCE("Fare");
    	   FlightDetailsFactory.sortingBasis = "Fare";
       } else if (!temporaryStorage.isEmpty() && temporaryStorage.equalsIgnoreCase("Both")) {
    	   flightDetailsInstance.setOUTPUT_PREFERENCE("Both");
    	   FlightDetailsFactory.sortingBasis = "Both";
       } else {
    	   try {
			throw new InvalidInputException("Wrong input for preferences. Please select one of the given preferences.");
		} catch (InvalidInputException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			isValidQuery = false;
		}
       }
      
	}
	
	public FlightDetails getInstance() {
		if (isValidQuery) {
			return flightDetailsInstance;
		} else {
			return null;
		}
		
	}

}
