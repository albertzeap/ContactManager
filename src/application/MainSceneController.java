package application;

import java.sql.SQLException;

import com.cognixia.contactManager.controller.UserController;
import com.cognixia.contactManager.exception.InvalidCredentialsException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainSceneController {
	
	@FXML
	private TextField tfEmail;
	
	@FXML
	private PasswordField tfPassword;
	
	@FXML
	private Label loginMessage;
	
	@FXML
	public void btnOKClicked(ActionEvent event) {
		
		Stage loginWindow =  (Stage) tfEmail.getScene().getWindow();
		
		String email = tfEmail.getText();
		String password = tfPassword.getText();
		
		try {
			UserController.loginUser(email, password);
			
			if(UserController.getActiveUser() != null) {
				loginMessage.setText("Login successful!");
				BorderPane root = new BorderPane();
				Scene dashboard = new Scene(root,400,400);
				loginWindow.setScene(dashboard);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidCredentialsException e) {
			loginMessage.setText(e.getMessage());
		}
		
		
	}
	
	
}
