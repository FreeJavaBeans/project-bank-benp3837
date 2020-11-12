package com.revature.repo;

import java.sql.SQLException;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
//import com.revature.exceptions.InternalErrorException;
//import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface BankUserRepository {

	public List<User> findAllUsers();
	
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException;
	
	public void createUser (String username, String password, String address) throws SQLException; 
	
	public int deleteUser (User user);
	
}
	
