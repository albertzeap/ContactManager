package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {			
			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			Scene login = new Scene(root);
			
			primaryStage.setTitle("Contact Manager");
			primaryStage.setScene(login);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
