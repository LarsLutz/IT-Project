package anleitung;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

//Jan Müller
public class Anleitung_Controller {
	
	public Anleitung_Controller(){
		
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
