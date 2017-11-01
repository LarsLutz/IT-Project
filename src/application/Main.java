package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Model mo = new Model(0);
		View v = new View(primaryStage);
		Controller c = new Controller();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
