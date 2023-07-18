package com.cognixia.contactManager.controller;

import com.cognixia.contactManager.repository.UserDao;
import com.cognixia.contactManager.repository.UserDaoSql;

public class UserController {

	public boolean createUser(String email, String password, String phoneNumber) {
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
}
