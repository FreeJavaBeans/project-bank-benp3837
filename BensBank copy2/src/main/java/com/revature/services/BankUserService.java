package com.revature.services;

import java.sql.SQLException;
import java.util.List;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
//import com.revature.models.User;

import com.revature.BankLauncher;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.repo.BankUserDAO;
import com.revature.repo.BankUserRepository;

//while the DAO's methods go and gets data from the server,
//the service takes that data and uses it in its service methods.


public class BankUserService implements UserService {

	//bankuserrepository has the abstract stuff = bankuserDAO has the implementation
	private BankUserRepository bur = new BankUserDAO();
	//this is restaurantuserdao = new trickoreatuserdao in the demo
	
	
	
	
	public User login(String username, String password) throws UserNotFoundException, InternalErrorException {
		User login = bur.findUserByUsernameAndPassword(username, password);
		BankLauncher.logger.info(login.getUsername() + " has logged in");
		return login;
	}

		
	
	
	public void createNewUser(String username, String password, String address) throws SQLException {
		bur.createUser(username, password, address);
		
	}




	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
	

