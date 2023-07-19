package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	Stage window;
	Scene login, dashboard;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
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
