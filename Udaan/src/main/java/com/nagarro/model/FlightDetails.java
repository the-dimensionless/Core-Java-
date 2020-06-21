/**
* Class name : FlightDetails
*
* Author info : @Sumit Kumar Singh
*
* Description : Model class for storing Flight Details.
*/
package com.nagarro.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightDetails implements PriceRegulator {
	
	private String name;
	private String FLIGHT_NO;
	private String DEP_LOC;
	private String ARR_LOC;
	private LocalTime FLIGHT_TIME;
	private LocalDate VALID_TILL;
	private double baseFARE;
	private double totalFare;
	private String CLASS;
	private String SEAT_AVAILABILITY;
	private double FLIGHT_DURATION;
	
	/** 
	 * Constructor that sets values of user given inputs
	 * @param FlightDetails object : Contains FlightDetails object
	 * with only query parameters set
	 * 
	 */
	public FlightDetails(FlightDetails ob) {
		this.SEAT_AVAILABILITY = ob.getSEAT_AVAILABILITY();
		this.FLIGHT_DURATION = ob.getFLIGHT_DURATION();
		this.FLIGHT_NO = ob.getFLIGHT_NO();
		this.baseFARE = ob.getFARE();
		this.CLASS = ob.getCLASS();
		this.FLIGHT_TIME = ob.getFLIGHT_TIME();
		this.name = ob.getName();
	}
	public FlightDetails() {
		
	}
	
	/** Returns Duration of Flight
	 * @return Double
	 */
	public double getFLIGHT_DURATION() {
		return FLIGHT_DURATION;
	}
	
	/** Sets Duration of Flight
	 * @param double fLIGHT_DURATION
	 * 						: Type double
	 */
	public void setFLIGHT_DURATION(double fLIGHT_DURATION) {
		FLIGHT_DURATION = fLIGHT_DURATION;
	}
	private String OUTPUT_PREFERENCE;
	
	public String getName() {
		return name;
	}
	
	/** Sets name of Flight Company
	 * @param name
	 * 				: String
	 */
	public void setName(String name) {
		this.name = name;
	}
	public String getFLIGHT_NO() {
		return FLIGHT_NO;
	}
	
	/** Sets Flight Number
	 * @param fLIGHT_NO
	 * 				: String
	 */
	public void setFLIGHT_NO(String fLIGHT_NO) {
		FLIGHT_NO = fLIGHT_NO;
	}
	public String getDEP_LOC() {
		return DEP_LOC;
	}
	
	/** Sets Departure Location
	 * @param dEP_LOC
	 * 				: String
	 */
	public void setDEP_LOC(String dEP_LOC) {
		DEP_LOC = dEP_LOC;
	}
	public String getARR_LOC() {
		return ARR_LOC;
	}
	
	/** Sets Arrival Location
	 * @param dEP_LOC
	 * 				: String
	 */
	public void setARR_LOC(String aRR_LOC) {
		ARR_LOC = aRR_LOC;
	}
	public LocalTime getFLIGHT_TIME() {
		return FLIGHT_TIME;
	}
	
	/** Sets Departure Time of Flight
	 * @param fLIGHT_TIME
	 * 				: LocalTime
	 */
	public void setFLIGHT_TIME(LocalTime fLIGHT_TIME) {
		FLIGHT_TIME = fLIGHT_TIME;
	}
	public LocalDate getVALID_TILL() {
		return VALID_TILL;
	}
	
	/** Sets Flight Validity Date
	 * @param vALID_TILL
	 * 				: LocalDate
	 */
	public void setVALID_TILL(LocalDate vALID_TILL) {
		VALID_TILL = vALID_TILL;
	}
	
	public double getFARE() {
		return baseFARE;
	}
	
	/** Sets Base Fare of Flight
	 * @param fARE
	 * 				: double
	 */
	public void setFARE(double fARE) {
		baseFARE = fARE;
	}
	
	/** Computes total Fare of Flight
	 * @return totalFare
	 * 				: double
	 */
	public double getTotalFare() {
		if (this.CLASS.equals("E")) {
			this.totalFare = this.baseFARE * ECONOMY_TAX_PERCENT;
		} else {
			this.totalFare = this.baseFARE * BUSINESS_TAX_PERCENT;
		}
		return totalFare;
	}
	
	/** Sets Total Fare of Flight
	 * @param totalFare
	 * 				: double
	 */
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	public String getCLASS() {
		return CLASS;
	}
	
	/** Sets travel class of Flight
	 * @param cLASS
	 * 				: String
	 */
	public void setCLASS(String cLASS) {
		CLASS = cLASS;
	}
	public String getSEAT_AVAILABILITY() {
		return SEAT_AVAILABILITY;
	}
	
	/** Sets indicator value for Seat Availability
	 * @param sEAT_AVAILABILITY
	 * 				: String
	 * 				: Y for available seat, N otherwise
	 */
	public void setSEAT_AVAILABILITY(String sEAT_AVAILABILITY) {
		SEAT_AVAILABILITY = sEAT_AVAILABILITY;
	}
	public String getOUTPUT_PREFERENCE() {
		return OUTPUT_PREFERENCE;
	}
	
	/** Sets user's choice for sorting result list
	 * @param oUTPUT_PREFERENCE
	 * 				: String
	 * 				: Can be of 2 types -> ByFare or ByBothFareAndDuration
	 */
	public void setOUTPUT_PREFERENCE(String oUTPUT_PREFERENCE) {
		OUTPUT_PREFERENCE = oUTPUT_PREFERENCE;
	}
	
	@Override
	/** Displays flight details<p>
	 * Flight Company Name<p>
	 * Flight Number, Flight Seat Availability Indicator, Flight Departure Time <p>
	 * Flight Duration, Flight Travel Class, Total Payable Fare
	 */
	public String toString() {
		return "\nFlightDetails : Company Name : "+this.name+"\n" + "Flight No : "+this.FLIGHT_NO + " [Flight Seat Availability] : "
				+this.getSEAT_AVAILABILITY() + " [Flight Time] : "+this.getFLIGHT_TIME()+" hrs " 
				+"\n[Flight Duration] : "+this.getFLIGHT_DURATION() +" hrs "+ " [Class] : "+this.getCLASS()
				+" Fare : "+String.format("%.2f", this.getTotalFare())+"\n";
	}
	

}
