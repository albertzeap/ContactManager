package com.cognixia.contactManager.repository;

import java.sql.SQLException;
import java.util.Optional;

import com.cognixia.contactManager.model.User;

public interface UserDao {
	
	// CREATE METHODS
	public boolean createUser(String email, String password, String phoneNumber) throws SQLException;
	
	public Optional<User> getUserByCredentials(String email, String password) throws SQLException;
}
