package montageAnleitung;

import javafx.application.Application;
import javafx.stage.Stage;

public class MontageAnleitung_Model extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		MontageAnleitung_Model mam = new MontageAnleitung_Model();
		MontageAnleitung_Controller mac = new MontageAnleitung_Controller();
		MontageAnleitung_View mav = new MontageAnleitung_View(primaryStage);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}


	
}
