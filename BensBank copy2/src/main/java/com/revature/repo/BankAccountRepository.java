package com.revature.repo;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Account;

//abstract methods of what a bank account can do

public interface BankAccountRepository {

	
	
	public void createNewAccount(int id, BigDecimal balance) throws SQLException;

	public Account findAccountById(int id) throws SQLException;
	
	public Account withdrawBalance(BigDecimal withdrawal, int id) throws SQLException;
	
	public Account depositBalance(BigDecimal deposit, int id) throws SQLException;
	
	public void transferBalance(BigDecimal balance, int acct1, int acct2) throws SQLException;

	public List<Account> findAccountsByUserId(int id);
}
