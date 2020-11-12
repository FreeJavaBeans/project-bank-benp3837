package com.revature.menus;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;


public class MenuSelector implements Displayable{

	private MenuNode currentMenu;
	
	private User currentUser;
	
	private static MenuSelector ms = new MenuSelector();
	
	private MenuSelector() {
		super();
		//export menu building to a function
		this.currentMenu = buildMenus();
	}
	
	
	public String display() {
		// TODO Auto-generated method stub
		return currentMenu.getValue().display();
	}
	
	//this lets us move forward/backward
	public void traverse(int i) {
		if(i == -1) {
			this.currentMenu = currentMenu.backward();
		} else {
			this.currentMenu = currentMenu.forward(i);
		}
	}
	
	
	private MenuNode buildMenus() {
		
		MenuNode login = new MenuNode(new LoginMenu(), null, null);
		MenuNode main = new MenuNode(new MainMenu(), login, null);
		
		//here's a list of login's children, just has main for now
		List<MenuNode> loginChildren = new ArrayList<MenuNode>();
		loginChildren.add(main);
		login.setChildren(loginChildren);
		
		
		//login is the MenuNode returned because we start in the login menu!!
		return login;
		//eventually we'll create children for login

	}

	
	public void reset() {
		this.currentMenu = buildMenus();
		this.currentUser = null;
	}
	
	
	public void handleInput() {
		this.currentMenu.getValue().handleInput();
	}

	public static MenuSelector getMenuSelector() {
		return ms;
	}


	public User getCurrentUser() {
		return currentUser;
	}


	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	
	
}
