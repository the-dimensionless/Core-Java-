/**
* Class name : MonitoringSystem
*
* Author info : @Sumit Kumar Singh
*
* Description : Main class that controls the Monitoring System
* 				, schedules timer for task scheduling and waits on it
* 				for notification. Subsequently, cancels the task and timer
* 				and restarts the Searching process on receiving an updation
* 				notification.
*/
package com.nagarro.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import com.nagarro.model.FlightDetails;
import com.nagarro.model.FlightDetailsFactory;

public class MonitoringSystem extends ConfigureMonitoringSystem {

	static MonitoringSystem obj = new MonitoringSystem();
	private HashMap<Path, Long> lastModifiedValues;

	public MonitoringSystem(ArrayList<String> arrayOfCompanies) throws IOException {
		lastModifiedValues = new HashMap<Path, Long>();

		for (String s : arrayOfCompanies) {
			Path currentFilePath = Paths.get(sourcePath.toAbsolutePath() + "\\" + s);
			FileTime file = Files.getLastModifiedTime(currentFilePath);
			lastModifiedValues.put(currentFilePath, file.toMillis());

		}
	}

	public MonitoringSystem() {
		
	}

	public void startMonitoring(FlightDetails ob) throws Throwable {

		Timer timer = new Timer();
		TimerTask task = new MonitorDirectory(sourcePath, lastModifiedValues,
				Files.getLastModifiedTime(sourcePath.toAbsolutePath()).toMillis());
		timer.schedule(task, 1, 5000);
		
		synchronized(MonitoringSystem.obj) {
			MonitoringSystem.obj.wait();
		}
		task.cancel();
		timer.cancel();
		System.out.println("System needs to be relaunched");
		this.finalize();
		new FlightSearcher(new FlightDetailsFactory().getFlightDetailsInstance());

	}

}
