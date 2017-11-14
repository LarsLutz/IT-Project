package montageAnleitung;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MontageAnleitung_Main extends Application{
	@Override
	public void start(Stage primaryStage){
		MontageAnleitung_Model mam = new MontageAnleitung_Model();
		MontageAnleitung_Controller mac = new MontageAnleitung_Controller();
		MontageAnleitung_View mav = new MontageAnleitung_View(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
