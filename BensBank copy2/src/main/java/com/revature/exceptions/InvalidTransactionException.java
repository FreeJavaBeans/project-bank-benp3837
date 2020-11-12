package com.revature.exceptions;

public class InvalidTransactionException extends Exception {

	public String getMessage() {
		return "That's an invalid transaction, buddy";
	}
	
}
