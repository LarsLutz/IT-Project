package lobby;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

// Eduart Bunjaku

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
    public void neuesSpiel(ActionEvent event) {
    	System.out.println("neues spiel");
    }

    @FXML
    public void spielLaden(ActionEvent event) {
    	System.out.println("Spielladen");
    }

    @FXML
    public void chatOeffnen(ActionEvent event) {
    	System.out.println("Chat Roulette");
    }


    @FXML
    public void leaderboardAnzeigen(ActionEvent event) {
    	System.out.println("Leaderboard");
    }



    @FXML
    public void anleitungAnzeigen(ActionEvent event) {
    	System.out.println("Anleitung zeigen");
    }



    @FXML
    public void beenden(ActionEvent event) {
    	Platform.exit();
    }



}
