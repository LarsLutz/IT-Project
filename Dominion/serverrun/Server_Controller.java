package serverrun;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Server_Controller {
	
	@FXML
	Label l1, l2, lStatus, lAdresse;
	
	@FXML
	Button bSchliessen;
	
	public void initialize(){
		System.out.println("Hallo Welt");
		Server.serverStart();
	}
	
}
