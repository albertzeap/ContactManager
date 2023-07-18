package com.cognixia.contactManager.repository;

import java.util.Optional;

import com.cognixia.contactManager.model.User;

public interface UserDao {
	
	// CREATE METHODS
	public boolean createUser(String email, String password, String phoneNumber);
	
	public Optional<User> loginUser(String email, String password);
}
