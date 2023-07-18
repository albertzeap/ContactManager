package com.cognixia.contactManager.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.cognixia.contactManager.connection.ConnectionManager;
import com.cognixia.contactManager.model.User;

public class UserDaoSql implements UserDao {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public boolean createUser(String email, String password, String phoneNumber) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO user(email, password, phone_number) VALUES (?,?,?)");
		
		ps.setString(1, email);		
		ps.setString(2, password);		
		ps.setString(3, phoneNumber);		
		
		int count = ps.executeUpdate();
		
		if(count > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public Optional<User> getUserByCredentials(String email, String password) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
		
		ps.setString(1, email);		
		ps.setString(2, password);		
		
		ResultSet rs = ps.executeQuery();
		Optional<User> user = Optional.empty();
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String userEmail = rs.getString(2);
			String userPassword = rs.getString(3);
			String phoneNumber = rs.getString(4);
			
			user = Optional.of(new User(id, userEmail, userPassword, phoneNumber));
			
		}
		
		return user;
	}

}
