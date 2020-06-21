/**
* Class name : DemoView
*
* Author info : @Sumit Kumar Singh
*
* Description : Class responsible for showing results.
*/
package com.nagarro.structuredView;

import java.util.ArrayList;

import com.nagarro.model.CompareByBothFareAndDuration;
import com.nagarro.model.CompareByFare;
import com.nagarro.model.FlightDetails;
import com.nagarro.model.FlightDetailsFactory;

public class DemoView {
	
	private ArrayList<FlightDetails> listOfFlightDetails;
	
	/** Initializes variable listOfFlightDetails
	 * @param listOfFlightDetails
	 * 				: ArrayList<FlightDetails>
	 * 				: list of available flights
	 */
	public DemoView(ArrayList<FlightDetails> listOfFlightDetails) {
		this.listOfFlightDetails = listOfFlightDetails;
	}
	
	/** display list of available flights
	 */
	public void structuredSampleView () {
		if (FlightDetailsFactory.sortingBasis.equalsIgnoreCase("Fare")) {
			listOfFlightDetails.sort(new CompareByFare());
		} else if (FlightDetailsFactory.sortingBasis.equalsIgnoreCase("both")) {
			listOfFlightDetails.sort(new CompareByBothFareAndDuration());
		}
		
		System.out.println("\nAvailable Flights are as follows -------------------->");
		for (FlightDetails fd : listOfFlightDetails) {
			System.out.println(fd.toString());
		}
	}
	

}
