/**
* Class name : MonitorDirectory
*
* Author info : @Sumit Kumar Singh
*
* Description : Child class of Timer Task that performs the task of 
* 				Monitoring files in the given folder.
*/
package com.nagarro.controllers;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;
import com.nagarro.custom_exceptions.NoSuchDirectoryException;

public class MonitorDirectory extends TimerTask {
	private HashMap<Path, Long> lastModifiedValues;
	Path sourcePath;
	Long dirTS;

	public MonitorDirectory(Path sourcePath, HashMap<Path, Long> hm, Long dirTS) {
		this.lastModifiedValues = hm;
		this.sourcePath = sourcePath;
		this.dirTS = dirTS;
	}

	@Override
	public void run() {
		System.out.println("\nWatching . . .\n");
		// We will check if the directory exists
		Path p = Paths.get("AVIATION_COMPANIES_DATASET");
//		System.out.println("Path is "+p);
		
		if (!Files.exists(p.toAbsolutePath())) {
			try {
				throw new NoSuchDirectoryException("Seems like the specified directory has been deleted");
			} catch (NoSuchDirectoryException e) {
				e.printStackTrace();
			}
		}
		
		try {
			if (Files.getLastModifiedTime(p).toMillis() > dirTS ) {
				System.out.println("Directory has been modified");
				synchronized(MonitoringSystem.obj) {
					MonitoringSystem.obj.notify();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// if directory exists, we proceed to count no of files in directory
		
		try {
			DirectoryStream<Path> i = Files.newDirectoryStream(p);
//			i.forEach(j->System.out.println(j.toAbsolutePath()));
//			i.forEach(
//					j->new Timer().schedule( (new MonitorFiles(j, lastModifiedValues.get(j.toAbsolutePath()))), 2000)
//			);
			
			Iterator<Path> it = i.iterator();
			while (it.hasNext()) {
				
				Path ds = it.next();
				long timeStamp = lastModifiedValues.get(ds.toAbsolutePath());
				long latestTimeStamp = 0l;
				
				try {
					latestTimeStamp = Files.getLastModifiedTime(ds).toMillis();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if (latestTimeStamp > timeStamp) {
					System.out.println(ds.getFileName()+" File has been modified and necessary steps are to be taken");
				
					synchronized(MonitoringSystem.obj) {
						MonitoringSystem.obj.notify();
					}
					
				} else {
					System.out.println(ds.getFileName()+" has not been modified");
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
	}

	}
}
