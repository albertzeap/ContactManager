package com.cognixia.contactManager.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.cognixia.contactManager.connection.ConnectionManager;
import com.cognixia.contactManager.model.Contact;

public class ContactDaoSql implements ContactDao {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public boolean createContact(Contact contact) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO contact(first_name, last_name, phone_number) VALUES (?,?,?)");
		
		ps.setString(1, contact.getFirstName());
		ps.setString(2, contact.getLastName());
		ps.setString(3, contact.getLastName());
		
		int count = ps.executeUpdate();
		
		if(count > 0) {
			return true;
		}
		
		return false;
	}
	
	
	@Override
	public Optional<Contact> getContactByPhoneNumber(String phoneNumber) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM contact WHERE phone_number = ?");
		
		ps.setString(1, phoneNumber);
		
		ResultSet rs = ps.executeQuery();
		Optional<Contact> contact = Optional.empty();
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String pNumber = rs.getString(4);
			
			contact = Optional.of(new Contact(id, firstName, lastName, pNumber));
		}
		
		return contact;
	}

	@Override
	public boolean addContact(int userId, int contactId) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO user_contact(user_id, contact_id) VALUES (?,?)");
		
		ps.setInt(1, userId);
		ps.setInt(2, contactId);
		
		int count = ps.executeUpdate();
		
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteContact(int userId, int contactId) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("DELETE FROM user_contact WHERE user_id = ?, contact_id = ?");
		
		ps.setInt(1, userId);
		ps.setInt(2, contactId);
		
		int count = ps.executeUpdate();
		
		if(count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateContact(Contact contact) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("UPDATE user_contact SET first_name = ?, last_name = ?, phone_number = ? WHERE contact_id = ?");
		
		ps.setString(1, contact.getFirstName());
		ps.setString(2, contact.getLastName());
		ps.setString(3, contact.getPhoneNumber());
		
		int count = ps.executeUpdate();
		
		if(count > 0) {
			return true;
		}
		
		return false;
	}


}
