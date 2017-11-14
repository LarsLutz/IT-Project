package montageAnleitung;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class MontageAnleitung_Controller {
	//Jan Müller
	public MontageAnleitung_Controller(){
		
	}
	
	@FXML
	TextArea AnleitungsText;
	
	@FXML
	Button zurueck;
	
	@FXML
	public void zurueckKlick(MouseEvent e){
		System.exit(0);
	}
}
