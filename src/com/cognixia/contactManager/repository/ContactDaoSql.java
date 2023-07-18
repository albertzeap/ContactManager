package com.cognixia.contactManager.repository;

import java.util.Optional;

import com.cognixia.contactManager.model.Contact;

public class ContactDaoSql implements ContactDao {

	@Override
	public boolean createContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Contact> addContact(int userId, String phoneNumber) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean deleteContact(int userId, int contactId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

}
