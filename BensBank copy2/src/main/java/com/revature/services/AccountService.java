package com.revature.services;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Account;


public interface AccountService {

	public void createAccount(BigDecimal balance) throws SQLException;
	
	public BigDecimal getAccountBalanceById(int id) throws SQLException;
	
	public BigDecimal makeWithdrawal(BigDecimal withdrawal, int id) throws SQLException;
	
	public BigDecimal makeDeposit(BigDecimal deposit, int id) throws SQLException;
	
	public void makeTransaction(BigDecimal balance, int acct1, int acct2) throws SQLException;
	
	public List<Account> getAccountsByID(int id) throws SQLException;
}
