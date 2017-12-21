package montageAnleitung;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MontageAnleitung_Controller {
    /**
     * 
     * @author  Jan Mueller
     * Text Anleitung @author Robin Widmer
     *
     */
	public void initialize(){
		AnleitungsText.setOpacity(0.5);
	}
	
	
	public MontageAnleitung_Controller(){
		
	}
	
	@FXML
	TextArea AnleitungsText;
	
	@FXML
	Button zurueck;
	
	@FXML
	public void zurueckKlick(MouseEvent e) throws IOException {
		// schliesst aktuelles Fenster
    	Stage currentStage = (Stage) zurueck.getScene().getWindow();
    	currentStage.close();
	}
}
