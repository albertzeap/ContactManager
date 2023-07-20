package com.cognixia.contactManager.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cognixia.contactManager.model.Contact;
import com.cognixia.contactManager.repository.ContactDao;
import com.cognixia.contactManager.repository.ContactDaoSql;

public class ContactController {
	
	private static List<Contact> contacts = new ArrayList<>();
	
	public static List<Contact> getContacts() {
		return contacts;
	}

	public static void setContacts(List<Contact> contacts) {
		ContactController.contacts = contacts;
	}
	
	public static void updateContacts() {
		ContactDao contactDao = new ContactDaoSql();
		try {
			List<Contact> contacts = contactDao.getUserContacts(UserController.getActiveUser());
			setContacts(contacts);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean addContact(String firstName, String lastName, String phoneNumber) throws SQLException {
		
		ContactDao contactDao = new ContactDaoSql();
		Optional<Contact> exists = contactDao.getContactByPhoneNumber(phoneNumber);
		
		if(exists.isEmpty()) {
			Contact contact = new Contact(0, firstName, lastName, phoneNumber);
			contactDao.createContact(contact);
			Optional<Contact> newContact = contactDao.getContactByPhoneNumber(contact.getPhoneNumber());
			System.out.println(newContact.get());
			contactDao.addContact(UserController.getActiveUser().getId(), newContact.get().getId());
			return true;
		} else {
			contactDao.addContact(UserController.getActiveUser().getId(), exists.get().getId());			
		}
		
		
		return true;
	}
	
	
	public static void updateContact(String id, String name, String phoneNumber) {
		
		int contactId = Integer.valueOf(id);
		String[] flName = name.split(" ");
		
		ContactDao contactDao = new ContactDaoSql();
		
		try {
			Contact contact = new Contact(contactId, flName[0], flName[1], phoneNumber);
			
			contactDao.updateContact(contact);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteContact(String id) {
		
		int contactId = Integer.valueOf(id);
	
		ContactDao contactDao = new ContactDaoSql();
		
		try {
			
			boolean success = contactDao.deleteContact(UserController.getActiveUser().getId(), contactId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
