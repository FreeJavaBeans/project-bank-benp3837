package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserService {

	public User login(String username, String password) throws UserNotFoundException, InternalErrorException;
	
	public void createNewUser(String username, String password, String address) throws SQLException;
	
	public List<User> findAllUsers();
	
	
	
}
