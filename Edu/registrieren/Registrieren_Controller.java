package registrieren;

// Eduart Bunjaku
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Registrieren_Controller {
	
	public Registrieren_Controller(){
		
		
	}
	
	@FXML
    private Label pwRegistrieren;

    @FXML
    private PasswordField pwFeld;

    @FXML
    private Button registrierenButton;

    @FXML
    private Label pwWiederholen;

    @FXML
    private PasswordField pwWiederholenFeld;

    @FXML
    private Label usernameRegistrieren;

    @FXML
    private Button abbrechenButton;

    @FXML
    private TextField usernameRegistrierenTextfeld;
    
    
    // Nach erfolgreicher Registrierung gelangt man mit dem "Registrieren-Button" in die Lobby.
    @FXML
    void lobbyOeffnen(MouseEvent event) {

    }

    // Mit dem Betätigen des "Abbrechen-Buttons", schlisst man das Fenster "Registrieren".
    @FXML
    void fensterSchliessen(MouseEvent event) {

    }
	

}
