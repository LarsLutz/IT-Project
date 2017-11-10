package leaderboard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class Leaderboard_Controller {
	
	
	// Jan Müller
	public Leaderboard_Controller(){
		
	}
	
	@FXML
	TextArea leaderText;
	
	@FXML
	Button zurueck;
	
	@FXML
	public void zurueckKlick(MouseEvent e){
		System.exit(0);
	}

}
