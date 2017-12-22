package registrieren;

import java.io.IOException;

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
import javafx.stage.Stage;
import sound.MP3;

/** Führt die Registration eines neuen Users aus
 * @author Lars Lutz
 */

public class Registrieren_Controller {

	private Registrieren_Model model;

	public Registrieren_Controller(){
		model= new Registrieren_Model();

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

	@FXML
	private Label infolabel;


	// Nach erfolgreicher Registrierung gelangt man mit dem "Registrieren-Button" zum Login.
	@FXML
	/**
	 * Führt die Registration eines Users durch und überprüft einige Konformeinstellungen
	 * @param event Beim Maus klick
	 * @throws IOException Wen bei der SQL Abfrage etwas schiefläuft
	 */
	public void lobbyOeffnen(ActionEvent event) throws IOException {
		MP3.spieleMusik();

		String name = usernameRegistrierenTextfeld.getText();
		String password =pwFeld.getText();
		Boolean komform =true;

		if (name.length()<=3){
			infolabel.setText("Username oder Passwort zu kurz. (min. 4 Zeichen)");
			komform=false;
		}

		if (password.length()<=3 && komform ){
			komform=false;
			infolabel.setText("Username oder Passwort zu kurz. (min. 4 Zeichen)");
		}

		if (!password.equals(pwWiederholenFeld.getText())&& komform){
			infolabel.setText("Zwei verschiedene Passwörter eingegeben");
			komform=false;
		}

		if ( komform){

			model.setName(name);
			model.setPasswort(password);

			model.setSpieler();


			// schliesst aktuelles Fenster
			Stage currentStage = (Stage) registrierenButton.getScene().getWindow();
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

	// Mit dem BetÃ¤tigen des "Abbrechen-Buttons", kehrt man zum Login Fenster zurÃ¼ck
	@FXML
	public void fensterSchliessen() throws IOException {
		MP3.spieleMusik();
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
