package gewonnen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SiegNiederlage_Controller {
	//Jan Müller
	public SiegNiederlage_Controller(){
		
	}
	
	@FXML
	Button bOk;
	
	@FXML
	Label labNachricht;
	
	@FXML
	ImageView gameOver;
	
	
	public void okKlick(MouseEvent e){
		System.exit(0);
	}
	

}
