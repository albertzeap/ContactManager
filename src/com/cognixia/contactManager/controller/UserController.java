package com.cognixia.contactManager.controller;

import java.sql.SQLException;
import java.util.Optional;

import com.cognixia.contactManager.exception.InvalidCredentialsException;
import com.cognixia.contactManager.model.User;
import com.cognixia.contactManager.repository.UserDao;
import com.cognixia.contactManager.repository.UserDaoSql;

public class UserController {
	
	private static User activeUser = null;
	
	public static User getActiveUser() {
		return activeUser;
	}

	public static void setActiveUser(User activeUser) {
		UserController.activeUser = activeUser;
	}
	
	public static boolean createUser(String email, String password, String phoneNumber) {
		UserDao userDao = new UserDaoSql();
		
		try {
			
			boolean created = userDao.createUser(email, password, phoneNumber);
			
			if(!created) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static void loginUser(String email, String password) throws SQLException, InvalidCredentialsException {
		
		UserDao userDao = new UserDaoSql();
		
		
			
			Optional<User> user = userDao.getUserByCredentials(email, password);
			
			if(user.isEmpty()) {
				throw new InvalidCredentialsException();
			}
			
			setActiveUser(user.get());
		
	}
}
