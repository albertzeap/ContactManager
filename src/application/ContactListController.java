package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.cognixia.contactManager.controller.ContactController;
import com.cognixia.contactManager.controller.UserController;
import com.cognixia.contactManager.model.Contact;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ContactListController implements Initializable {	
	
	@FXML
	private TableView<ContactsModel> contactTable;
	
	@FXML
    public TableColumn<ContactsModel, Integer> contactId;

    @FXML
    public TableColumn<ContactsModel, String> contactName;

    @FXML
    public TableColumn<ContactsModel, String> contactNumber;
    
    @FXML
	private TextField tfContactID;
	@FXML
	private TextField tfContactName;
	@FXML
	private TextField tfContactPhoneNumber;
	
	@FXML
	private MenuItem miLogout;	
	
	// add your data here from any source 
	private ObservableList<ContactsModel> contactsModel = FXCollections.observableArrayList();
	
	
	public void refreshScene() {
		Stage dashBoardWindow = (Stage) contactTable.getScene().getWindow();
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("ContactList.fxml"));
			Scene dashboard = new Scene(root);
			
			
			dashBoardWindow.setScene(dashboard);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
			ContactController.updateContacts();
			List<Contact> contacts = ContactController.getContacts();
		
			// Add the new values into the table
			for(Contact contact : contacts) {
				System.out.println(contact);
				contactsModel.add(new ContactsModel(contact.getId(),contact.getFirstName() + " " + contact.getLastName(), contact.getPhoneNumber()));
			}
		
		
		
		 	contactId.setCellValueFactory(new PropertyValueFactory<>("contactId"));
		 	
	        contactName.setCellValueFactory(new PropertyValueFactory<>("contactName"));
	        
	        contactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
	        
	        //add your data to the table here.
	        contactTable.setItems(contactsModel);
	        
	        // Allow data to be updated when clicked
	        contactTable.setOnMouseClicked((MouseEvent event) -> {
	    		ContactsModel contact = contactTable.getSelectionModel().getSelectedItem();
	    		if(contact != null) {
	    			tfContactID.setText(String.valueOf(contact.getContactId()));
	    			tfContactName.setText(String.valueOf(contact.getContactName()));
	    			tfContactPhoneNumber.setText(String.valueOf(contact.getContactNumber()));		
	    		}
	        });
	        
		
	}
		
	@FXML
	public void navigateHome(ActionEvent event) {
		refreshScene();
	}
	
	@FXML
	public void logoutClicked(ActionEvent event) {
		Stage dashBoardWindow = (Stage) contactTable.getScene().getWindow();
	
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			Scene login = new Scene(root);
			
			UserController.setActiveUser(null);
			
			dashBoardWindow.setScene(login);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	// Event Listener on Button.onAction
	@FXML
	public void addContactClicked(ActionEvent event) {
		
		Stage dashBoardWindow =  (Stage) contactTable.getScene().getWindow();
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("AddContactScene.fxml"));
			Scene addContact = new Scene(root);
			dashBoardWindow.setScene(addContact);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void updateContactClicked(ActionEvent event) {
		
		ContactController.updateContact(tfContactID.getText(), tfContactName.getText(), tfContactPhoneNumber.getText());
		refreshScene();
	}
	
	// Event Listener on Button.onAction
	@FXML
	public void deleteContactClicked(ActionEvent event) {
		System.out.println("CLICKED");
		
		ContactController.deleteContact(tfContactID.getText());
		refreshScene();
	}

	
    
}
