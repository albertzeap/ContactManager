package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {
	
	@FXML
	private TextField tfEmail;
	
	@FXML
	public void btnOKClicked(ActionEvent event) {
		Stage mainWindow =  (Stage) tfEmail.getScene().getWindow();
		String email = tfEmail.getText();
		mainWindow.setTitle(email);
	}
	
	
}
