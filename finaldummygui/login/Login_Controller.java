package login;

// Eduart Bunjaku
import javafx.application.Platform;
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

public class Login_Controller {
	
	
	@FXML
    private Button registrierenButton;

    @FXML
    private PasswordField passwortFeld;

    @FXML
    private Button loginButton;

    @FXML
    private Label passwortLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextfeld;

    @FXML
    private Button abbrechenButton;
    
    @FXML
    private ImageView waldBildLogin;
    
    // Schliesst Login-Fenster, wenn man auf "Abbrechen-Button" klickt.
    @FXML
    public void schliessen(){
    	Platform.exit();
    }
    
    // Oeffnet Lobby-Fenster, wenn man auf "Login-Button" klickt.
    @FXML
    public void oeffneLobby(ActionEvent eevent) {
    	
try{
    		
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//lobby//LobbyGUI.fxml"));
    		Parent root1 = (Parent) fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setTitle("Lobby");
    		stage.setScene(new Scene(root1));
    		stage.show();
   
    	}catch (Exception e){
    		System.out.println("Lobby Fenster nicht gefunden");
    	}
    
    

    }
    
    // Oeffnet Registrieren-Fenster, wenn man auf "Registrieren-Button" klickt.
    @FXML
    public void oeffneRegistrieren(){
    	
    }
    
    


}