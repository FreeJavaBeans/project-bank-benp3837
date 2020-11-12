package com.revature.menus;

import java.util.List;
import java.util.Scanner;

import com.revature.util.ScannerSingleton;


//all our menus will extend from this!!!!
//the only methods they'll have to implement are handleInput & buildMenu
public abstract class AbstractMenu implements Menu{

	private List<MenuLine> lines;
	
	private Scanner inputReader; //consider adding a scanner singleton
						//so you don't have to open and close 100 scanners
	
	public AbstractMenu() {
		super();
		inputReader = ScannerSingleton.getScanner();
		lines = buildMenu();
	}
	
	
	//these are the two abstract methods that the different menus provide implementation for
	
	//this one handles the user's input
	public abstract void handleInput();
	
	//this one creates all the menu lines
	public abstract List<MenuLine> buildMenu();

	
	
	//these methods below are already implemented within the AbstractMenu 
	
	//need to display all the MenuLines
	public String display() {
		String display = "";
		for(MenuLine ml : lines) {
			display += ml.display() + "\n";
		}
		return display;
	}

	
	//getters and setters 
	protected List<MenuLine> getLines() {
		return lines;
	}

	protected void setLines(List<MenuLine> lines) {
		this.lines = lines;
	}

	protected Scanner getInputReader() {
		return inputReader;
	}

	protected void setInputReader(Scanner inputReader) {
		this.inputReader = inputReader;
	}
	
	
	
	
}
