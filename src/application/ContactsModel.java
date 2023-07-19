package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ContactsModel  {
	
	private SimpleIntegerProperty contactId;
	private SimpleStringProperty contactName;
	private SimpleStringProperty contactNumber;
	
	
	public ContactsModel(Integer contactId, String contactName, String contactNumber) {
		super();
		this.contactId = new SimpleIntegerProperty(contactId);
		this.contactName =  new SimpleStringProperty(contactName);
		this.contactNumber =  new SimpleStringProperty(contactNumber);
	}
	
	public int getContactId() {
		return contactId.get();
	}
	public void setContactId(int contactId) {
		this.contactId = new SimpleIntegerProperty(contactId);
	}
	public String getContactName() {
		return contactName.get();
	}
	public void setContactName(String contactName) {
		this.contactName = new SimpleStringProperty(contactName);
	}
	public String getContactNumber() {
		return contactNumber.get();
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = new SimpleStringProperty(contactNumber);
	}
	
	
	
}
