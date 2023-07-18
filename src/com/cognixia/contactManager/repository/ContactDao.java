package com.cognixia.contactManager.repository;

import java.util.Optional;

import com.cognixia.contactManager.model.Contact;

public interface ContactDao {

	// CREATE METHODS
	public boolean createContact(Contact contact);
	
	// GET METHODS
	public Optional<Contact> addContact(int userId, String phoneNumber);
	
	// DELETE METHODS
	public boolean deleteContact(int userId, int contactId);
	
	// UPDATE METHODS
	public boolean updateContact(Contact contact);
}
