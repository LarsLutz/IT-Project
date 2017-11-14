package registrieren;

// Eduart bunjaku
import javafx.application.Application;
import javafx.stage.Stage;
import login.Login_Controller;
import login.Login_Model;
import login.Login_View;

public class Registrieren_Main extends Application {
	

	
	
	@Override
	public void start(Stage registrierenStage) {
		
		Registrieren_View v = new Registrieren_View(registrierenStage);
		Registrieren_Model m = new Registrieren_Model();
		Registrieren_Controller c = new Registrieren_Controller();	
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}


}
