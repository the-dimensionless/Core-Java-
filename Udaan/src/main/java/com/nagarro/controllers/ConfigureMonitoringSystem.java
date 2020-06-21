/**
* Class name : ConfigureMonitoringSystem
*
* Author info : @Sumit Kumar Singh
*
* Description : Configuration class for setting target source folder and watch duration.
*/
package com.nagarro.controllers;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ConfigureMonitoringSystem {
	
	public static Path sourcePath = Paths.get("AVIATION_COMPANIES_DATASET");
	public static long watchDuration = 5l;
	
	/**
     * Returns Path of targetDirectory
     * @return object of Path type
     */
	public Path getSourcePath() {
		return Paths.get("AVIATION_COMPANIES_DATASET");
	}
	
	public long getWatchDuration() {
		return 5l;
	}
	
	/**
     * Sets sourcePath Directory
     * @param p: Path : Path of target Directory
     * @return void
     */
	public void setSourcePath(Path p) {
		sourcePath = p;
	}
	
	/**
	 * Sets the period between two successive monitor processes
	 * @param time: Long
     */
	public void setWatchDuration(Long time) {
		watchDuration = time;
	}

}
