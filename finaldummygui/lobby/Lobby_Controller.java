package lobby;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

// Eduart Bunjaku - Jan Müller

public class Lobby_Controller {
	
	public Lobby_Controller(){
		
	}
	
	@FXML
    private ImageView lobbyFoto;

    @FXML
    private Button chatButton;

    @FXML
    private Button spielLadenButton;

    @FXML
    private Button neuesSpielButton;

    @FXML
    private Button anleitungButton;

    @FXML
    private Button beendenButton;

    @FXML
    private Button leaderBoardButton;

    @FXML
    public void neuesSpiel(ActionEvent event) throws IOException {
    	// schliesst aktuelles Fenster
    	Stage currentStage = (Stage) neuesSpielButton.getScene().getWindow();
    	currentStage.close();
    		    
   	    // oeffnet neues fenster
   		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../spielfeld/SpielfeldGUI.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();
    }

    @FXML
    public void spielLaden(ActionEvent event) {
    	System.out.println("TODO... SpielLaden");
    }

    @FXML
    public void chatOeffnen(ActionEvent event) {
    	System.out.println("Hier stellt sich die Frage wie wir das machen wollen...");
    	System.out.println("Chat sollte auch vom Spielfeld selber aus aufgerufen werden - daher sollte das GUI");
    	System.out.println("meiner Meinung nach als eigene Stage erscheinen (mit eigenem Fenster) -- LG der Führer");
    }


    @FXML
    public void leaderboardAnzeigen(ActionEvent event) throws IOException {
    	// schliesst aktuelles Fenster
    	Stage currentStage = (Stage) leaderBoardButton.getScene().getWindow();
    	currentStage.close();
    		    
    	// oeffnet neues fenster
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../leaderboard/LeaderboardGUI.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }



    @FXML
    public void anleitungAnzeigen(ActionEvent event)throws IOException {
    	// schliesst aktuelles Fenster
    	Stage currentStage = (Stage) anleitungButton.getScene().getWindow();
    	currentStage.close();
    		    
    	// oeffnet neues fenster
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../montageAnleitung/MontageAnleitungGUI.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }



    @FXML
    public void beenden(ActionEvent event) {
    	Stage currentStage = (Stage) leaderBoardButton.getScene().getWindow();
    	currentStage.close();
    }



}
