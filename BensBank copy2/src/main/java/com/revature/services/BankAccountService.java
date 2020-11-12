package com.revature.services;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.revature.BankLauncher;
import com.revature.menus.MenuSelector;
import com.revature.models.Account;
import com.revature.repo.BankAccountDAO;
import com.revature.repo.BankAccountRepository;

public class BankAccountService implements AccountService{

	static BankAccountRepository bar = new BankAccountDAO();
	
	@Override
	public void createAccount(BigDecimal balance) throws SQLException {
		
		//get the account created from the DAO
		int id = MenuSelector.getMenuSelector().getCurrentUser().getUserId();
		
		//a.setUserId(userId);
		//a.setAccountId(accountId);
		bar.createNewAccount(id, balance);
	}

	@Override
	public BigDecimal getAccountBalanceById(int id) throws SQLException {
		Account a = bar.findAccountById(id);
		return a.getBalance();
	}
	
	
	public BigDecimal makeWithdrawal(BigDecimal withdrawal, int id) throws SQLException {
		Account a = bar.withdrawBalance(withdrawal, id);
		BankLauncher.logger.info("Account #" + a.getAccountId() + " has withdrawn $" + withdrawal); 
		return a.getBalance();
		//this won't execute because a is null, BECAUSE the query won't return results...
		
				
		//we do the SQL update statement in the DAO
		//then send the new balance here to be displayed in the main menu,
		//where the user will choose the bank accoumt to withdraw from,
		//and the balance to withdraw  	
	}

	@Override
	public BigDecimal makeDeposit(BigDecimal deposit, int id) throws SQLException {
		Account a = bar.depositBalance(deposit, id);
		BankLauncher.logger.info("Account #" + a.getAccountId() + " has deposited $" + deposit); 
		return a.getBalance();
	
	}
	
	@Override
	public void makeTransaction(BigDecimal balance, int acct1, int acct2) throws SQLException {
		bar.transferBalance(balance, acct1, acct2);
		BankLauncher.logger.info("Account #" + acct1 + " has deposited $" + balance 
									+ " to Account #" + acct2);
	}

	@Override
	public List<Account> getAccountsByID(int id) throws SQLException {
		List<Account> la = bar.findAccountsByUserId(id);
		return la;
	}

	
	
	
}
