package com.cognixia.contactManager.controller;

import java.sql.SQLException;
import java.util.Optional;

import com.cognixia.contactManager.model.Contact;
import com.cognixia.contactManager.repository.ContactDao;
import com.cognixia.contactManager.repository.ContactDaoSql;

public class ContactController {
	
	public static boolean addContact(String firstName, String lastName, String phoneNumber) throws SQLException {
		
		ContactDao contactDao = new ContactDaoSql();
		Optional<Contact> exists = contactDao.getContactByPhoneNumber(phoneNumber);
		
		if(exists.isEmpty()) {
			Contact contact = new Contact(0, firstName, lastName, phoneNumber);
			contactDao.createContact(contact);
			Optional<Contact> newContact = contactDao.getContactByPhoneNumber(contact.getPhoneNumber());
			contactDao.addContact(UserController.getActiveUser().getId(), newContact.get().getId());
			return true;
		} 
		contactDao.addContact(UserController.getActiveUser().getId(), exists.get().getId());
		
		
		return true;
	}
}
