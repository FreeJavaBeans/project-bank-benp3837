package com.revature.menus;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.services.AccountService;
import com.revature.services.BankAccountService;
import com.revature.services.BankUserService;
import com.revature.services.UserService;

public class MainMenu extends AbstractMenu {

	AccountService as = new BankAccountService();
	UserService us = new BankUserService();
	
	
	//here you'll provide implementations for the actions of the main menu's lines
		@Override
		public List<MenuLine> buildMenu() {
			
			//this one's not working yet. some notes in your project notes.
			
			MenuLine l1 = new MenuLine(0, ()->"\n1: Create New Account", ()->{
					
				//enter the values for the new account
				BigDecimal balance;
				System.out.print("Please Enter Account Starting Balance: ");
				balance = this.getInputReader().nextBigDecimal();
				//accountId = 
				
				try {
					as.createAccount(balance);
					System.out.println("Account Created with Balance of $" + balance);
				} catch (SQLException e) {
					System.out.println("uhh hi");
				}
				
			});
			
			MenuLine l2 = new MenuLine(1, ()->"2: View Account Balance", ()->{
				//all set up, but it throws the NumberFormatException 
					int accountId;
					System.out.print("Please Enter Account ID: ");
					accountId = this.getInputReader().nextInt();

					try {
						System.out.println("\nYour balance: $" 
									  	  + as.getAccountBalanceById(accountId));
					}catch (SQLException e) {
						System.out.println("Sorry darlin'");
					}
				});
			
			MenuLine l3 = new MenuLine(2, ()->"3: Make a Withdrawal", ()->{
					BigDecimal balance;
					int accountId;
					System.out.println("Enter Account Id to Withdraw from ");
					accountId = this.getInputReader().nextInt();
					
					System.out.println("How much would you like to withdraw? ");
					balance = this.getInputReader().nextBigDecimal();
					
					BigDecimal isZero = new BigDecimal(0);
					
					
					if(balance.compareTo(isZero) < 0) {
						System.out.println("Cannot Withdraw Negative Balace!");
					}else {
						try {
							as.makeWithdrawal(balance, accountId);
							System.out.println("\nYour new balance: $" 
									  	  + as.getAccountBalanceById(accountId));
						}catch (SQLException e) {
							System.out.println("Sorry darlin'");
						}
					}
			});
			
			MenuLine l4 = new MenuLine(3, ()->"4: Make a Deposit", ()->{
				BigDecimal balance;
				int accountId;
				System.out.println("Enter Account Id to Deposit to ");
				accountId = this.getInputReader().nextInt();
				System.out.println("How much would you like to deposit? ");
				balance = this.getInputReader().nextBigDecimal();
						
				BigDecimal isZero = new BigDecimal(0);
				
				if(balance.compareTo(isZero) < 0) {
					System.out.println("Cannot Deposit Negative Balace!");
					
				}else {
					try {
						as.makeDeposit(balance, accountId);
						System.out.println("\nYour new balance: $" 
								  	  + as.getAccountBalanceById(accountId));
					}catch (SQLException e) {
						System.out.println("Sorry buddy");
					}
				}
			});
			
			MenuLine l5 = new MenuLine(4, ()->"5: Transfer Money", ()->{

				//enter the bank ID you'll like to transfer money to
				int acct1;
				System.out.print("Enter Account to Transfer FROM: ");
				acct1 = this.getInputReader().nextInt();
				
				//enter the balance you would like to transfer
				int acct2;
				System.out.print("Enter Account to Transfer TO: ");
				acct2 = this.getInputReader().nextInt();
				
				//System.out.println("Successfully Transferred $" + balance);
				BigDecimal balance;
				System.out.println("Enter Amount to be Transferred");
				balance = this.getInputReader().nextBigDecimal();
				
				BigDecimal isZero = new BigDecimal(0);
				
				if(balance.compareTo(isZero) < 0) {
					System.out.println("Cannot Withdraw Negative Balace!");
					
				}else{
					
					try {
						as.makeTransaction(balance, acct1, acct2);
						System.out.println("Account #" + acct1 + " has deposited $" + balance 
								+ " to Account #" + acct2);
						
					} catch (SQLException e) {
						System.out.println("No. Wrong.");
					}	
				
				}
				
			});
			
			MenuLine l6 = new MenuLine(5, ()->"6: New User", ()->{

				//enter the values for the new account
				String username;
				System.out.print("Please Enter Username: ");
				username = this.getInputReader().nextLine();
				
				String password;
				System.out.print("Please Enter Password: ");
				password = this.getInputReader().nextLine();
				
				String address;
				System.out.print("Please Enter Address: ");
				address = this.getInputReader().nextLine();
				
				try {
					us.createNewUser(username, password, address);
					System.out.println("User " + username + " created!");
				} catch (SQLException e) {
					System.out.println("uhh hi");
				}
				
				
				});
			
			MenuLine l7 = new MenuLine(6, ()->"7: View Accounts (employees only!)", ()->{
				
				//first we have to have the employee enter their employee_id
				
				int employeeId;
				System.out.print("Please Enter Your Employee Id to View Accounts: ");
				employeeId = this.getInputReader().nextInt();
				System.out.println("Hello employee #" + employeeId);
				
				int userId;
				System.out.print("Please Enter User Id to View Accounts: ");
				userId = this.getInputReader().nextInt();

				try {	
					System.out.println(as.getAccountsByID(userId));
				}catch (SQLException e) {
					System.out.println("Sorry darlin'");
				} 
			});
			
			MenuLine l8 = new MenuLine(7, ()->"8: Go Back", ()->{
				MenuSelector.getMenuSelector().traverse(-1); 
			});
			
			
			
			List<MenuLine> ret = new ArrayList<MenuLine>();
			
			ret.add(l1);
			ret.add(l2);
			ret.add(l3);
			ret.add(l4);
			ret.add(l5);
			ret.add(l6);
			ret.add(l7);
			ret.add(l8);
			return ret;
		}
	
	
	//Then here, you'll implement the previously abstract handleInput method
	@Override
	public void handleInput() {
		String input = this.getInputReader().nextLine();
		
		try {
			//turns the nextLine() input into an int, subtract by one to work w menu
			int choice = Integer.parseInt(input) - 1;
			
			if(choice >=0 && choice < this.getLines().size()) { //if it's inbounds
				//perform the action that the chosen line does
				this.getLines().get(choice).doAction();
			} else {
				//otherwise tell the user to make a valid choice
				System.out.println("Please Make a Valid Choice");
			}
			
		
			//this exception gets thrown after every action completes - whyyyy????
		} catch (NumberFormatException e) {
			System.out.println("hi Please Make a Valid Choice");
			e.printStackTrace();
		}
	}
	
	
}
