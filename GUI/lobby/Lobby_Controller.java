package lobby;

// Eduart Bunjaku
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Lobby_Controller {
	
	public Lobby_Controller(){
		
	}
	
	@FXML
    private Button neuesSpielButton;
	
    @FXML
    private Button spielLadenButton;

    @FXML
    private Button chatButton;
    
    @FXML
    private Button leaderboardButton;

    @FXML
    private Button anleitungButton;

    @FXML
    private Button beendenButton;


    // "neues Spiel-Button"--> oeffnet ein leeres Spielfeld-Fenster.
    @FXML
    void spielfeldOeffnen(MouseEvent event) {

    }

    // "Spiel laden-Button" --> oeffnet gespeichertes Spiel.
    @FXML
    void spielLaden(MouseEvent event) {

    }

    // "Chat-Button" --> oeffnet Chatfenster
    @FXML
    void chatOeffnen(MouseEvent event) {

    }

    // "Leaderboard-Button"--> zeigt den 
    @FXML
    void leaderZeigen(MouseEvent event) {

    }

    // "Anleitung-Button" --> oeffnet ein Fenster mit dem Link zur Spielanleitung.
    @FXML
    void anlZeigen(MouseEvent event) {

    }

    // "Beenden-Button" --> schliesst das Lobby-Fenster.
    @FXML
    void lobbySchliessen(MouseEvent event) {

    }

}
