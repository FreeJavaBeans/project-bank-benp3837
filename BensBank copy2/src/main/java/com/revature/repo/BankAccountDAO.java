package com.revature.repo;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;

import com.revature.util.ConnectionUtil;

public class BankAccountDAO implements BankAccountRepository{

	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	



	@Override
	public void createNewAccount(int id, BigDecimal balance) {
		Connection conn = cu.getConnection();
		
		//in a try statement, do an insert statement to create a new account
		try {
			
			String sql = "insert into accounts (account_balance, user_id) "
						 + "values (?, ?); ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ps.setInt(1,account.getAccountId());
			ps.setBigDecimal(1, balance);
			ps.setInt(2, id);
			
			//execute the above query 
		    ps.executeUpdate();
		    
		    
			
			//this is where I tried to reinvent the wheel to set the SERIAL account_id 
		    
			//String sql2 = "select account_id from accounts where user_id = ?;";
			
			//PreparedStatement ps2 = conn.prepareStatement(sql2);
			
			//ps2.setInt(1, userId);
			
			//ResultSet results = ps2.executeQuery();
			
			//int accountId = results.getInt("account_id");
			
			//process the results for a new id
			//results.next();
			//account.setAccountId(getAccountId("account_id"));

			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Create Account Failed :(");
		}
			
	
	}

	
	@Override
	public Account findAccountById(int id) {
		Connection conn = cu.getConnection();	

		try {
			
			String sql = "select * from accounts where account_id = ?;";
				
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet results = ps.executeQuery();
			
			while (results.next()) {
				int accountId = results.getInt("account_id");
				BigDecimal balance = results.getBigDecimal("account_balance");
				int userId = results.getInt("user_id");
				
				Account a = new Account(accountId, balance, userId);
				
				return a;
			}
			
		} catch (SQLException e) {	
			System.out.println("woah woah woah");
			e.printStackTrace();
		
		}
		
		return null;  //this is causing the exception to run, but I can't delete it
		//cause the method needs a guaranteed return value
		//don't remember the fix
		
	}
	

	@Override
	public Account withdrawBalance(BigDecimal withdrawal, int id) throws SQLException {
		Connection conn = cu.getConnection();
	
		//perform an update statement to decrease account_balance by a user inputted number
		try {
			
			String sql1 = "update accounts set account_balance = account_balance - ? "
					+ "where account_id = ?; ";
					
			String sql = "select * from accounts where account_id = ?;";
	

			//this does the actual update (first query)
			PreparedStatement pss = conn.prepareStatement(sql1);
			pss.setBigDecimal(1, withdrawal);
			pss.setInt(2, id);
			pss.executeUpdate();
			
			
			//and this returns the new info (second query)
			PreparedStatement ps = conn.prepareStatement(sql);		
			ps.setInt(1,id);
			
			ResultSet results = ps.executeQuery();
			
		
			
			
			while (results.next()) {
				int accountId = results.getInt("account_id");
				BigDecimal balance = results.getBigDecimal("account_balance");
				int userId = results.getInt("user_id");
				
				Account a = new Account(accountId, balance, userId);
				
				return a;
			}
			
		//getting "no results returned by query" 
		//but the table updates when I use it from the main menu
		} catch (SQLException e) {
			System.out.println("whatchu doin man?");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	@Override
	public Account depositBalance(BigDecimal deposit, int id) throws SQLException {
		Connection conn = cu.getConnection();
		
		//perform an update statement to decrease account_balance by a user inputted number
		try {
			
			String sql1 = "update accounts set account_balance = account_balance + ? "
					+ "where account_id = ?; ";
					
			String sql = "select * from accounts where account_id = ?;";
	

			//this does the actual update (first query)
			PreparedStatement pss = conn.prepareStatement(sql1);
			pss.setBigDecimal(1, deposit);
			pss.setInt(2, id);
			pss.executeUpdate();
			
			
			//and this returns the new info (second query)
			PreparedStatement ps = conn.prepareStatement(sql);		
			ps.setInt(1,id);
			
			ResultSet results = ps.executeQuery();
			
			while (results.next()) {
				int accountId = results.getInt("account_id");
				BigDecimal balance = results.getBigDecimal("account_balance");
				int userId = results.getInt("user_id");
				
				Account a = new Account(accountId, balance, userId);
				
				return a;
			}
			
		//getting "no results returned by query" 
		//but the table updates when I use it from the main menu
		} catch (SQLException e) {
			System.out.println("whatchu doin man?");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public void transferBalance(BigDecimal balance, int acct1, int acct2) throws SQLException {
		Connection conn = cu.getConnection();
		//hmmmm what's the best way to do this
		try {
			
			String sqlw = "update accounts set account_balance = account_balance - ? "
					+ "where account_id = ?; ";
			
			PreparedStatement psw = conn.prepareStatement(sqlw);
			psw.setBigDecimal(1, balance);
			psw.setInt(2, acct1);
			psw.executeUpdate();
			
			
			String sqld = "update accounts set account_balance = account_balance + ? "
					+ "where account_id = ?; ";
			
			PreparedStatement psd = conn.prepareStatement(sqld);
			psd.setBigDecimal(1, balance);
			psd.setInt(2, acct2);
			psd.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("hi");
		}
	
		
	}
	
	
	
//employees will use this to view customer accounts (select * from accounts where user_id = ?)
	public List<Account> findAccountsByUserId(int id) {
		Connection conn = cu.getConnection();	

		try {
			
			String sql = "select * from accounts where user_id = ?;";
				
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet results = ps.executeQuery();
			
			if (results.next()) {
				int accountId = results.getInt("account_id");
				BigDecimal balance = results.getBigDecimal("account_balance");
				int userId = results.getInt("user_id");

				Account a = new Account(accountId, balance, userId);
				
				List<Account> la = new ArrayList<Account>();
				la.add(a);			
				
				return la;
			}
			
		
			
		} catch (SQLException e) {	
			System.out.println("woah woah woah");
			e.printStackTrace();
		
		}
		
		return null;
	}


	


	


	
	
}
