package registrieren;

import javafx.application.Platform;
// Eduart Bunjaku
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    
    @FXML
    private ImageView waldBildReg;
    
    
    // Nach erfolgreicher Registrierung gelangt man mit dem "Registrieren-Button" in die Lobby.
    @FXML
   public void lobbyOeffnen(MouseEvent event) {

    }

    // Mit dem Betätigen des "Abbrechen-Buttons", schlisst man das Fenster "Registrieren".
    @FXML
   public void fensterSchliessen() {
    	Platform.exit();
    }
	

}
