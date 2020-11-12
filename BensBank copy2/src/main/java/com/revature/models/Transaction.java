package com.revature.models;

import java.sql.Timestamp;

public class Transaction {

	private int transactionId;
	
	private Timestamp time;
	
	private double previousBalance;
	
	private double currentBalance;
	
	private User user;
	
	private Account account;

	
	//constructors, getters setters, etc
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transaction(int transactionId, Timestamp time, double previousBalance, double currentBalance, User user,
			Account account) {
		super();
		this.transactionId = transactionId;
		this.time = time;
		this.previousBalance = previousBalance;
		this.currentBalance = currentBalance;
		this.user = user;
		this.account = account;
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public Timestamp getTime() {
		return time;
	}


	public void setTime(Timestamp time) {
		this.time = time;
	}


	public double getPreviousBalance() {
		return previousBalance;
	}


	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}


	public double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		long temp;
		temp = Double.doubleToLongBits(currentBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(previousBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + transactionId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Transaction other = (Transaction) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (Double.doubleToLongBits(currentBalance) != Double.doubleToLongBits(other.currentBalance))
			return false;
		if (Double.doubleToLongBits(previousBalance) != Double.doubleToLongBits(other.previousBalance))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", time=" + time + ", previousBalance=" + previousBalance
				+ ", currentBalance=" + currentBalance + ", user=" + user + ", account=" + account + "]";
	}
	
	
	
	
	
	
}


