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

public class Leaderboard_Controller {
	
	private Leaderboard_Model model;
	// Jan Müller
	public Leaderboard_Controller(){
		
		//Lars Lutz 
		model= new Leaderboard_Model();
			
		
	}
	
	
	
	@FXML
	TextArea leaderText;
	// Lars Lutz
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
				Stage currentStage = (Stage) zurueck.getScene().getWindow();
			    currentStage.close();
			    
			    // oeffnet neues fenster
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../lobby/LobbyGui.fxml"));
		        Parent root1 = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setScene(new Scene(root1));  
		        stage.show();
		        stage.setResizable(false);
	}

}
