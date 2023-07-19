package application;

import java.io.IOException;
import java.sql.SQLException;

import com.cognixia.contactManager.controller.UserController;
import com.cognixia.contactManager.exception.InvalidCredentialsException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {
	
	@FXML
	private TextField tfEmail;
	
	@FXML
	private PasswordField tfPassword;
	
	@FXML
	private Label loginMessage;
	
	@FXML
	// This button onClick event watches for valid user credentials for login 
	public void btnOKClicked(ActionEvent event) {
		
		Stage loginWindow =  (Stage) tfEmail.getScene().getWindow();
		
		String email = tfEmail.getText();
		String password = tfPassword.getText();
		
		try {
			UserController.loginUser(email, password);
			
			if(UserController.getActiveUser() != null) {
				loginMessage.setText("Login successful!");

				Parent root = FXMLLoader.load(getClass().getResource("ContactList.fxml"));
				Scene dashboard = new Scene(root);
				loginWindow.setScene(dashboard);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCredentialsException e) {
			loginMessage.setText(e.getMessage());
		}
		
	}
	
	
}
