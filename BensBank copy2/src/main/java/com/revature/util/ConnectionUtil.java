package com.revature.util;
//the purpose of this class is 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	//we're going to use a singleton 
	//the singleton pattern involves making a private constructor
	//so no other class can instance this object
	//store a static reference to the SINGLE copy of the object made
	//we provide a public method to access that single instance
	
	//"I'm going to make a single object, and provide access to the 
	//private constructor through a static variable"
	
	private static ConnectionUtil singleton = new ConnectionUtil();
	//this is the singular reference to your class
	
	private Connection conn; 
	
	//nobody else can call the private constructor
	private ConnectionUtil () {
		super();
		
		//there are two ways to get secrets into a java program (e.g. password
		
		//1.) Read from a properties file 
		//2.) Get a value from the system environment variables
		
		//store our secrets in the system environment variables
		//retrieve them here and use them
		//using the getenv() function!! 
		//Returns an immutable map of all the environment variables
		String password = System.getenv("DB_PASSWORD");
		String username = System.getenv("DB_USERNAME");
		String url = System.getenv("DB_URL");
		
		try {
			this.conn = DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			System.out.println("Failed to Connect to Database");
			System.out.println("Password " + password);
			System.out.println("Username " + username);
			System.out.println("URL " + url);
			e.printStackTrace();
		}
			
		
	}
	
	public static ConnectionUtil getConnectionUtil() {
		return singleton;
	}
	
	//what this does, is makes it so nobody else can ever make a ConnectionUtil
	//there is exactly one, and will only be one
	
	
	//we need a public method that will return a connection
	public Connection getConnection() {
		return conn;
	}
	
}
