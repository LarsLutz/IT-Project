package login;

import java.io.IOException;

import chat.Chat_Model;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lobby.*;
import registrieren.Registrieren_Model;
import sound.MP3;
import spielfeld.Spielfeld_Model;

public class Login_Controller {

	MP3 mp3 = new MP3();
	private Login_Model model;
	
	public Login_Controller(){
		model= new Login_Model();

	}
	
    @FXML
    private AnchorPane root;
	
	@FXML
    private Button registrierenButton;

    @FXML
    private PasswordField passwortFeld;

    @FXML
    private Button loginButton;
    
    public Button getLoginButton(){
    	return loginButton;
    }
    
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
    
    @FXML 
    
    private Label infolabel;
    
    
    
    // Schliesst Login-Fenster, wenn man auf "Abbrechen-Button" klickt.   
    @FXML
    public void schliessen(){
    	Platform.exit();
    }
    
    // Oeffnet Lobby-Fenster, wenn man auf "Login-Button" klickt.
    @FXML
    public void oeffneLobby(ActionEvent event) throws IOException {
    	mp3.spieleMusik();
    	
    	String name = usernameTextfeld.getText();
    	String password =passwortFeld.getText();
    	
    	if (!name.isEmpty() && !password.isEmpty()){
    	
    	model.setName(name);
		model.setPasswort(password);
		
		String ausgabe= model.getLogin();
		
		if (ausgabe =="leer$"){
			infolabel.setText("Falscher Username");
		}else{
		
		String teile[]= ausgabe.split("-");
		
		String bname = teile[1];
		String bpasswort = teile[2];
		
		
    	if( name.equals(bname)&& password.equals(bpasswort)){
    		
    		model.setSessionID();
    		Chat_Model.setSpielername(bname);
    		Spielfeld_Model.setSpielername(bname);
    	
    	
    	
    	// schliesst aktuelles Fenster
		Stage currentStage = (Stage) loginButton.getScene().getWindow();
	    currentStage.close();
	    
	    // oeffnet neues fenster
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../lobby/LobbyGui.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();
        stage.setResizable(false);
    	}else {
    		
    		infolabel.setText("Login Daten Falsch");
    	}
    	
		}
    }else{
    	
    	infolabel.setText("Kein Wert eingegeben");
    }
    	
    }
    
    
    
    // Oeffnet Registrieren-Fenster, wenn man auf "Registrieren-Button" klickt.
    @FXML
   public void oeffneRegistrieren(ActionEvent event) throws IOException{

    	mp3.spieleMusik();
    	// closes current window
		Stage currentStage = (Stage) registrierenButton.getScene().getWindow();
	    currentStage.close();
	    
	    // opens new window 'LoginView.fxml'
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../registrieren/RegistrierenGUI.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();
        stage.setResizable(false);
    	
    }
    
    
    
    


}
