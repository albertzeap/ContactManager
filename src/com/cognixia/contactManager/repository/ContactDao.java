package com.cognixia.contactManager.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.cognixia.contactManager.model.Contact;
import com.cognixia.contactManager.model.User;

public interface ContactDao {

	// CREATE METHODS
	public boolean createContact(Contact contact) throws SQLException;
	
	// GET METHODS
	public Optional<Contact> getContactByPhoneNumber(String phoneNumber) throws SQLException;
	
	public boolean addContact(int userId, int contactId) throws SQLException;
	
	public List<Contact> getUserContacts(User user) throws SQLException;
	
	// DELETE METHODS
	public boolean deleteContact(int userId, int contactId) throws SQLException;
	
	// UPDATE METHODS
	public boolean updateContact(Contact contact) throws SQLException;
}
