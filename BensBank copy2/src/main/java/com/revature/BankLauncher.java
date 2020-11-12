package com.revature;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.revature.menus.MenuSelector;

import com.revature.util.ConnectionUtil;

public class BankLauncher {
	
	//you'll wanna use this logger for the logging transactions requirement!!
	//you can use it p much anywhere
	public static Logger logger = LogManager.getLogger("com.revature.bensbank");

	
	public static void main(String[] args) throws IOException {

		
	
		//this just makes sure your logger works.
		logger.debug("testing testing");
		
		MenuSelector ms = MenuSelector.getMenuSelector();
		//instantiates the MenuSelector object with its getter

		
		//we'll wanna do is give the user the login menu first
		while(true) {
			System.out.println(ms.display());
			ms.handleInput();
		}
		
		
		
		
	}
	
}


