package anleitung;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Anleitung_Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		Anleitung_Model am = new Anleitung_Model();
		Anleitung_Controller ac = new Anleitung_Controller();
		Anleitung_View av = new Anleitung_View(primaryStage);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
