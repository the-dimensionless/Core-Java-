/**
* Class name : Driver
*
* Author info : @Sumit Kumar Singh
*
* Description : Main class for Driving program as given in the problem statement.
*/
package com.nagarro.controllers;

import java.util.Scanner;

import com.nagarro.model.FlightDetails;
import com.nagarro.model.FlightDetailsFactory;

public class Driver 
{
	/**
	 * Main Function acts as the initial Controller of software at startup
	 * @param args
	 * @throws Throwable
	 */
    public static void main( String[] args ) throws Throwable
    {
    	Scanner kb = new Scanner(System.in);
    	
    	FlightDetailsFactory flightDetailsFactoryInstance = null;
    	FlightDetails flightQueryInstance = null;
    	
    	while (flightQueryInstance == null) {
    		entryInformation();
    		
    		flightDetailsFactoryInstance = new FlightDetailsFactory();
    		flightDetailsFactoryInstance.setUserInput(kb.nextLine());
    		
        	flightQueryInstance = flightDetailsFactoryInstance.getFlightDetailsInstance();
        	
        	if (flightQueryInstance != null) {
        		new FlightSearcher(flightQueryInstance);
        		break;
        	}
    	}
        kb.close();
    }
    
    public static void entryInformation() {
    	System.out.println("Please enter Query as per the given rules");
    	System.out.println("<Arrival Location> <Depature Location> <Date> <Travel Class> <Sorting Basis>");
    	System.out.println("Arrival/Departure Location - Should be 3 letter alphabetic code for location");
    	System.out.println("Date - format as (dd-mm-yyyy)");
    	System.out.println("Travel Class - 'E' for Economy or 'EB' for Business ");
    	System.out.println("Sorting Basis - 'Fare' for sorting on basis of fare\n"
    					+  "                'Both' for sorting on basis of both Fare and Duration");
    }
}
