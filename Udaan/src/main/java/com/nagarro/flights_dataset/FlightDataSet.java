/**
* Class name : FlightDataSet
*
* Author info : @Sumit Kumar Singh
*
* Description : Class responsible for reading directory and collecting a list of filenames.
*/
package com.nagarro.flights_dataset;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FlightDataSet {
	
	private String folderName = "AVIATION_COMPANIES_DATASET";
	private Path sourcePath = null;
	private ArrayList<String> listOfAviationCompanies;
	
	/**
     * Non parameterized Constructor that sets the sourcePath address and 
     * creates the sourcePath directory if it does not exist.
     * @throws IOException
     */
	public Path createDir() throws IOException {		//try using exists
		sourcePath = Paths.get(folderName);
		boolean exists = Files.isReadable(sourcePath);
		if (!exists) {
			Files.createDirectories(sourcePath);	
		}
		return sourcePath;
	}
	
	/**
     * Adds the name of files in this directory to listOfAviationCompanies 
     * <p>(stores the names of files contained in this folder)
     * @param SourceDirectory : Path type object (path of sourceDirectory)
     * @return void
     * @throws IOException
     */
	private void listOfAllCompanies(Path sourceDirectory) throws IOException {
			listOfAviationCompanies = new ArrayList<String>();
			Stream<Path> is = Files.list(sourceDirectory);
			is.forEach(i-> listOfAviationCompanies.add(i.getFileName().toString()));
			is.close();
	}
	
	/**
     * Checks if targetDirectory exists<p>
     * Computes the names of files in targetDirectory<p>
     * returns An arrayList of such fileNames
     * @param None
     * @return ArrayList<String> that contains names of files in the sourceDirectory
     * @throws IOException
     */
	public ArrayList<String> getDetails() throws IOException {
		Path p = new FlightDataSet().createDir();
		listOfAllCompanies(p);
		return this.listOfAviationCompanies;
	}

}
