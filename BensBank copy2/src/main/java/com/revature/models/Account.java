package com.revature.models;

import java.math.BigDecimal;

public class Account {

	private int accountId;
	
	//private String accountType; //do I need this?
	
	private BigDecimal balance;
	
	private int userId;
	
	//constructors, getters and setters, etc
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	} 

	public Account(int accountId, BigDecimal balance, int userId) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.userId = userId;
	}
	

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	
	
}


