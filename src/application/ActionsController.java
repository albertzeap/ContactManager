package application;

import java.io.IOException;
import java.sql.SQLException;

import com.cognixia.contactManager.controller.ContactController;
import com.cognixia.contactManager.controller.UserController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ActionsController {
	
	// TFA - TextFieldAdd: this refers to the text fields within the add scene
	@FXML
	private TextField tfaFirstName;
	@FXML
	private TextField tfaLastName;
	@FXML
	private TextField tfaPhoneNumber;
	@FXML
	private Label addStatus;
	
	@FXML
	private MenuBar addMenuBar;
	
	// Event Listener on MenuItem.onAction
	@FXML
	public void navigateHome(ActionEvent event) {
		
		Stage dashBoardWindow = (Stage) addMenuBar.getScene().getWindow();
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("ContactList.fxml"));
			Scene login = new Scene(root);
			
			
			dashBoardWindow.setScene(login);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Event Listener on MenuItem.onAction
	@FXML
	public void addContactClicked(ActionEvent event) {
		Stage dashBoardWindow =  (Stage) addMenuBar.getScene().getWindow();
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("AddContactScene.fxml"));
			Scene addContact = new Scene(root);
			dashBoardWindow.setScene(addContact);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void addSubmit(ActionEvent event) {
		
		addStatus.setText("");
		
		// Retrieve text field values 
		String firstName = tfaFirstName.getText();
		String lastName = tfaLastName.getText();
		String phoneNumber = tfaPhoneNumber.getText();
		
		System.out.println(firstName + " " + lastName + " " + phoneNumber);
		System.out.println(UserController.getActiveUser());
		
		// Pass values into contact controller to add the contact
		try {
			ContactController.addContact(firstName, lastName, phoneNumber);
			
			// Reset text if no errors are thrown
			tfaFirstName.setText("");
			tfaLastName.setText("");
			tfaPhoneNumber.setText("");
			
			// Prompt success message
			addStatus.setText("Contact Added Successfully!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// Event Listener on MenuItem.onAction
	@FXML
	public void logoutClicked(ActionEvent event) {
		Stage dashBoardWindow = (Stage) addMenuBar.getScene().getWindow();
		
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
}
