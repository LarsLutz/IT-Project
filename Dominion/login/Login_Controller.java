package login;

import java.io.IOException;

import chat.Chat_Model;
// Eduart Bunjaku
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import kommunikation.Kommunikation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sound.MP3;
import spielfeld.Spielfeld_Model;

/**
 * 
 * @author Eduart Bunjaku GUI
 * @author Lars Lutz
 *
 */

public class Login_Controller {

	//Instanzdaten
	private Login_Model model;

	//Konstruktor
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


	/**
	 * @author Lars Lambdas Öffnet das Ip Fenster immer wieder solange kein Wert eingegeben wurde (Falsche eingaben werden nicht abgefangen)
	 */
	public void initialize() throws IOException{

		if (Kommunikation.getIpadresse().isEmpty()){

			loginButton.setDisable(true);
			registrierenButton.setDisable(true);


			// oeffnet neues fenster
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../login/IPGui.fxml"));
			Parent wurzel = (Parent) fxmlLoader.load();
			Stage login = new Stage();
			login.setScene(new Scene(wurzel));  
			login.show();
			login.setResizable(false);
			login.setAlwaysOnTop(true);
			login.setOnHiding(event2 -> {
				fxmlLoader.<IP_Controller>getController();
				try {
					if (Kommunikation.getIpadresse().isEmpty()){
						initialize();
					}else{
						loginButton.setDisable(false);
						registrierenButton.setDisable(false);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			});

		}


	}


	// Schliesst Login-Fenster, wenn man auf "Abbrechen-Button" klickt.   
	@FXML
	public void schliessen(){
		MP3.spieleMusik();
		Platform.exit();
	}

	/**
	 * Überprüft ob die eingegebenen Logindaten korrekt sind
	 * @param event Wartet auf das Klick event
	 * @throws IOException Falls ein Error in der Abfrage vorkommt
	 */


	@FXML
	public void oeffneLobby(ActionEvent event) throws IOException {
		MP3.spieleMusik();

		// Lars Lutz
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

				String bid =teile[0];
				String bname = teile[1];
				String bpasswort = teile[2];





				if( name.equals(bname)&& password.equals(bpasswort)){

					model.setSessionID();
					Chat_Model.setSpielername(bname);
					Spielfeld_Model.setSpielername(bname);
					Spielfeld_Model.setSpielerid(bid);



					// schliesst aktuelles Fenster
					Stage login = (Stage) loginButton.getScene().getWindow();
					login.close();

					// oeffnet neues fenster
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../lobby/LobbyGui.fxml"));
					Parent wurzel = (Parent) fxmlLoader.load();
					Stage lobby = new Stage();
					lobby.setScene(new Scene(wurzel));  
					lobby.show();
					lobby.setResizable(false);
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

		MP3.spieleMusik();

		// closes current window
		Stage login = (Stage) registrierenButton.getScene().getWindow();
		login.close();

		// opens new window 'LoginView.fxml'
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../registrieren/RegistrierenGUI.fxml"));
		Parent wurzel = (Parent) fxmlLoader.load();
		Stage registrieren = new Stage();
		registrieren.setScene(new Scene(wurzel));  
		registrieren.show();
		registrieren.setResizable(false);

	}






}
