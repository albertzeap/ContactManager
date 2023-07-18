package com.cognixia.contactManager.repository;

import java.sql.SQLException;
import java.util.Optional;

import com.cognixia.contactManager.model.Contact;

public interface ContactDao {

	// CREATE METHODS
	public boolean createContact(Contact contact) throws SQLException;
	
	// GET METHODS
	public Optional<Contact> getContactByPhoneNumber(String phoneNumber) throws SQLException;
	
	public boolean addContact(int userId, int contactId) throws SQLException;
	
	// DELETE METHODS
	public boolean deleteContact(int userId, int contactId) throws SQLException;
	
	// UPDATE METHODS
	public boolean updateContact(Contact contact) throws SQLException;
}
