/**
* Class name : CSVSplitterValidator
*
* Author info : @Sumit Kumar Singh
*
* Description : Class responsible for reading row from csv files and validating entries.
*/
package com.nagarro.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.nagarro.custom_exceptions.InvalidContentsException;

public class CSVSplitterValidator {
	
	//private FlightDetails readyForProcessing;
	private boolean isValidCSV = false;
	public CSVSplitterValidator(String[] read, LocalDate localDate) {
		
		if (read.length != 9) {
			try {
				throw new InvalidContentsException("Wrong data format in DataSet. Contact Support");
			} catch (InvalidContentsException e) {
				System.out.println(e.getMessage());
				return;
			}
		}
		
		String temporaryStorage = read[0];
		if (!temporaryStorage.substring(0, 2).matches("^[a-zA-Z0-9]"+"[a-zA-Z0-9]$")) {
			
		}
		
		temporaryStorage = read[1];
		if ( !temporaryStorage.matches("[a-zA-Z]"+"[a-zA-Z]"+"[a-zA-Z]") || temporaryStorage.length() != 3) {
				System.out.println("Wrong value for Departure Location in DataSet");
				System.out.println(temporaryStorage);
				return;
		}
		
		temporaryStorage = read[2];
		if ( !temporaryStorage.matches("[a-zA-Z]"+"[a-zA-Z]"+"[a-zA-Z]") || temporaryStorage.length() != 3) {
			try {
				throw new InvalidContentsException("Arrival Location in DataSet is incorrect ");
			} catch (InvalidContentsException e) {
				System.out.println(e.getMessage());
				return;
			}
		}
		
		temporaryStorage = read[3];
		try {
			LocalDate d2 = LocalDate.parse(temporaryStorage, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			
			if (!d2.isAfter(localDate)) {
				return;
			}
		} catch (Exception e) {
			System.out.println("Problem with Date Format in Dataset. Contact Support");
			System.out.println(temporaryStorage);
			return;
		}
		
		temporaryStorage = read[4];
		if (temporaryStorage.length() != 4) {
			System.out.println("Problem with flight time in dataset. Contact Support");
			return;
		}
		try {
			Integer.parseInt(temporaryStorage);
		} catch (Exception e) {
			System.out.println("Problem with flight time in dataset. Contact Support");
			return;
		}
		
		temporaryStorage = read[5];
		try {
			Double.parseDouble(temporaryStorage);
		} catch (Exception e) {
			System.out.println("Problem with flight duration in dataset. Contact Support");
			return;
		}
		
		temporaryStorage = read[6];
		try {
			Double.parseDouble(temporaryStorage);
		} catch (Exception e) {
			System.out.println("Problem with flight fare in dataset. Contact Support");
			return;
		}
		
		temporaryStorage = read[7];
		if (!temporaryStorage.equals("Y") && !temporaryStorage.equals("N")) {
			System.out.println("Error in availability in dataset. Contact Support "+temporaryStorage);
			return;
		}
		temporaryStorage = read[8];
		if (!temporaryStorage.equals("E") && !temporaryStorage.equals("EB")) {
			System.out.println("Problem with flight travel class. Contact Support");
			return;
		}
		
		this.isValidCSV = true;
		
	}

	public boolean getValidity() {
		return isValidCSV;
	}

}
