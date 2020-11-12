package com.revature.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class BankUserDAO implements BankUserRepository {

	//STEAL ALL THIS IMPLEMENTATION FROM BANKDAO 
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	@Override
	public List<User> findAllUsers() {
		Connection conn = cu.getConnection();
		
		//select * from users
		//populate a list of users using the select statement results
		///List<User> lu = results of the select statement
		//return lu;
		return null;
	}

	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException {
		Connection conn = cu.getConnection();
		
		try {
			
			String sql = "select * from users where username = ? and \"password\" = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				//set the user's field variables
				User u = new User();
				
				u.setUsername(res.getString("username"));
				u.setPassword("");
				u.setAddress(res.getString("address"));
				u.setUserId(res.getInt("user_id"));
				
				return u;
				
			}else {
				throw new UserNotFoundException();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();
		}
	}

	public void createUser(String username, String password, String address) throws SQLException {
		Connection conn = cu.getConnection();
		
		//in a try statement, do an insert statement to create a new user
		
		try {
			
		String sql = "insert into users (username, \"password\", address) "
				+ "values (?, ?, ?);";
			
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString (1, username);
		ps.setString (2, password);
		ps.setString (1, address);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("hi");
		}			

	}
	


	
//looks like I won't implement this and users are born in this world to survive for eternity
	public int deleteUser(User user) {
		Connection conn = cu.getConnection();
		// TODO Auto-generated method stub
		return 0;
	}

	

}
