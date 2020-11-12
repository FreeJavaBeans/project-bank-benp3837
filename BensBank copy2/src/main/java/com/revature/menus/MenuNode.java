package com.revature.menus;

import java.util.List;


//we're going to use these nodes to build a tree of menus
//each node represents a different menu. login, main, etc. They have parents and children
public class MenuNode {

	private Menu value;
	
	private MenuNode parent;
	
	private List<MenuNode> children;
	
	
	public MenuNode backward() {
		return parent;
	}
	
	
	public MenuNode forward(int i) {
		return children.get(i);
	}


	public MenuNode(Menu value, MenuNode parent, List<MenuNode> children) {
		super();
		this.value = value;
		this.parent = parent;
		this.children = children;
	}


	public Menu getValue() {
		return value;
	}


	public void setValue(Menu value) {
		this.value = value;
	}


	public MenuNode getParent() {
		return parent;
	}


	public void setParent(MenuNode parent) {
		this.parent = parent;
	}


	public List<MenuNode> getChildren() {
		return children;
	}


	public void setChildren(List<MenuNode> children) {
		this.children = children;
	}


	
	
	
}
