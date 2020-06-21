/**
* Class name : CompareByBothFareAndDuration
*
* Author info : @Sumit Kumar Singh
*
* Description : Class responsible sorting based on Fare and Duration.
*/
package com.nagarro.model;

import java.util.Comparator;

public class CompareByBothFareAndDuration implements Comparator<FlightDetails> {
	/**
     * Compare two FlightDetails objects based on Fare and Duration
     * @param flight1 : FlightDetails
     * @param flight2 : FlightDetails
     * @return value of int type	
     */
	@Override
	public int compare(FlightDetails o1, FlightDetails o2) {
		if (o1.getFLIGHT_DURATION() < o2.getFLIGHT_DURATION()) {
			return -1;
		} else if (o1.getFLIGHT_DURATION() == o2.getFLIGHT_DURATION()) {
			return new CompareByFare().compare(o1, o2);
		} else {
			return 1;
		}
	}

}
