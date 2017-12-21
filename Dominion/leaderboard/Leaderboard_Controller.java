package leaderboard;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * 
 * @author Eduart Bunjaku
 *
 */

public class Leaderboard_Controller {
	
	//Instanzdaten
	private Leaderboard_Model model;
	
	// Konstruktor
	public Leaderboard_Controller(){
		
		model= new Leaderboard_Model();
					
	}
	
	
	
	@FXML
	TextArea leaderText;
	
	/** Setzt den Inhalt der Textarea.
	 * 
	 */
	public void initialize() {
		leaderText.appendText("Rang \t\t   Spieler \t\t\t Punkte \n");
	    leaderText.appendText(model.getLeader());
	}

	
	@FXML
	
	public void setLeader(){
		leaderText.appendText(model.getLeader());
	}
	
	@FXML
	Button zurueck;
	
	
	
	@FXML
	public void zurueckKlick(MouseEvent event) throws IOException{
		
				// schliesst aktuelles Fenster
				Stage leaderboard = (Stage) zurueck.getScene().getWindow();
			    leaderboard.close();
	}

}
