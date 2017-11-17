package registrieren;

import java.io.IOException;

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

// Eduart Bunjaku

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
   public void lobbyOeffnen(ActionEvent event) throws IOException {
    	
    	// schliesst aktuelles Fenster
		Stage currentStage = (Stage) registrierenButton.getScene().getWindow();
	    currentStage.close();
	    
	    // oeffnet neues fenster
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../lobby/LobbyGui.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();
        stage.setResizable(false);
  
    

    }

    // Mit dem Betätigen des "Abbrechen-Buttons", kehrt man zum Login Fenster zurück
    @FXML
   public void fensterSchliessen() throws IOException {
    	// schliesst aktuelles Fenster
    			Stage currentStage = (Stage) abbrechenButton.getScene().getWindow();
    		    currentStage.close();
    		    
    		    // oeffnet neues fenster
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../login/LoginGUI.fxml"));
    	        Parent root1 = (Parent) fxmlLoader.load();
    	        Stage stage = new Stage();
    	        stage.setScene(new Scene(root1));  
    	        stage.show();
    	        stage.setResizable(false);
    }
	

}
