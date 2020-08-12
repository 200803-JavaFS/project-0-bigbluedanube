package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver {
	
	//this is an example of a Singleton Design Pattern. Only one Logger will ever exist.
	private static final Logger log =  LogManager.getLogger(Driver.class);

	public static void main(String[] args) {
		Log.info("The application has started");
		
		try {
			recur();
		} catch (Error e) {
			Log.error("Oh no! We've encountered an error!");
		}
		
		Log.info("The application is ending."); 

	}

}
