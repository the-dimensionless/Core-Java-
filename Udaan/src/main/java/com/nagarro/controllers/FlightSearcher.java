/**
* Class name : FlightSearcher
*
* Author info : @Sumit Kumar Singh
*
* Description : Class that takes FlightDetails object as constructor parameter and 
* 				searches relevant and available flights.
* 				Also, starts the monitoring system.
*/
package com.nagarro.controllers;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;

import com.nagarro.flights_dataset.FlightDataSet;
import com.nagarro.model.FlightDetails;
import com.nagarro.structuredView.DemoView;
import com.nagarro.validators.CSVSplitterValidator;

public class FlightSearcher {
	
	private ArrayList<FlightDetails> listOfAvailableFlights;
	
	public FlightSearcher (FlightDetails ob) throws Throwable {
		
		FlightDataSet dataSet = new FlightDataSet();
		ArrayList<String> list = dataSet.getDetails();
		Path basePath = dataSet.createDir();
		
		listOfAvailableFlights = new ArrayList<FlightDetails>();
		
		for (String s : list) {
			System.out.println("Reading company data from "+basePath.toAbsolutePath()+"\\"+s);
			BufferedReader br = Files.newBufferedReader(Paths.get(basePath.toAbsolutePath()+"\\"+s));
			br.readLine();
			while(br.ready()) {
				String line[] = br.readLine().split("\\|");
				boolean isValid = new CSVSplitterValidator(line, ob.getVALID_TILL()).getValidity();
				if (isValid) {
					if (line[1].equals(ob.getDEP_LOC()) && line[2].equals(ob.getARR_LOC()) 
							&& line[8].equals(ob.getCLASS()) && line[7].equals("Y")) {
						//System.out.println("Found a flight!");
						ob.setName(s.substring(0, s.indexOf(".")));
						ob.setFLIGHT_NO(line[0]);
						ob.setFARE(Double.parseDouble(line[6]));
						ob.setFLIGHT_TIME(LocalTime.of(Integer.parseInt(line[4].substring(0, 2)), Integer.parseInt(line[4].substring(2, 4))));
						ob.setSEAT_AVAILABILITY(line[7]);
						ob.setFLIGHT_DURATION(Double.parseDouble(line[5]));
						listOfAvailableFlights.add(new FlightDetails(ob));
					}
				}
				
			}
		}
		
//		System.out.println(listOfAvailableFlights);
		new DemoView(listOfAvailableFlights).structuredSampleView();
		MonitoringSystem sys = new MonitoringSystem(list);
		sys.startMonitoring(ob);
	
	}

}
