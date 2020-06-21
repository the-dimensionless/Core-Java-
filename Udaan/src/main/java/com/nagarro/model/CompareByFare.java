/**
* Class name : CompareByFare
*
* Author info : @Sumit Kumar Singh
*
* Description : Class responsible sorting based on Fare.
*/
package com.nagarro.model;

import java.util.Comparator;

public class CompareByFare implements Comparator<FlightDetails> {

	/**
     * Compare two FlightDetails objects based on Fare
     * @param flight1 : FlightDetails
     * @param flight2 : FlightDetails
     * @return value of int type	
     */
	@Override
	public int compare(FlightDetails flight1, FlightDetails flight2) {
			if (flight1.getFARE() <= flight2.getFARE()) {
				return -1;
			} else {
				return 1;
			}
	}

}
