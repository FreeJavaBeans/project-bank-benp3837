package com.revature.menus;

public class MenuLine implements Displayable {
	
	private int lineNumber;
	
	//when we make a menuLine, we pass in an item to display
	//like a food or an order
	private Displayable item;
	
	//then we also pass in a function for the line to do when it's chosen
	private Actionable action;
	
	public String display() {
		// TODO Auto-generated method stub
		return item.display();
	}

	public void doAction() {
		action.action();
		
	}
	
	public MenuLine(int lineNumber, Displayable item, Actionable action) {
		super();
		this.lineNumber = lineNumber;
		this.action = action;
		this.item = item;
	}
	//getters and setters for lineNumber
	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
}
