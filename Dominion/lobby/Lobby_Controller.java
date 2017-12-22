package lobby;

import java.io.IOException;

import chat.Chat_Controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kommunikation.Kommunikation;
import sound.HintergrundSound;
import sound.MP3;
import spielfeld.Spielfeld_Controller;

/**
 * 
 * GUI @author Eduart Bunjaku
 * GUI @author Jan Mueller	
 *
 */

public class Lobby_Controller {

	private Lobby_Model lm;
	private HintergrundSound hs;
	//private Kommunikation kom;

	public Lobby_Controller(){
		lm = new Lobby_Model();
		hs = new HintergrundSound();
		//kom =new Kommunikation();

	}

	/**
	 * 
	 * @author Eduart Bunjaku
	 * @author Jan Mueller
	 *
	 */
	@FXML
	private ImageView lobbyFoto;

	@FXML
	private Button chatButton;

	@FXML
	private Button soundButton, soundAn;

	@FXML
	private Button neuesSpielButton;

	@FXML
	private Button anleitungButton;

	@FXML
	private Button beendenButton;

	@FXML
	private Button leaderBoardButton;


	/**
	 * 
	 * @author Lars Lutz
	 * Stellt die Verbindung mit dem Server her
	 *
	 */

	@FXML
	public void initialize(){
		hs.playHintergrundLoop();
		try {
			Kommunikation.clientcon();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	/**
	 * 
	 * Lambdas @author Lars Lutz fängt das Colse event vom Fenster ab
	 * rest @author Eduart Bunjaku / Jan Mueller		
	 *
	 */
	@FXML
	public void neuesSpiel(ActionEvent event) throws IOException {
		MP3.spieleMusik();
		// schliesst aktuelles Fenster
		Stage lobby = (Stage) neuesSpielButton.getScene().getWindow();
		lobby.close();

		//oeffnet neues fenster
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../spielfeld/SpielfeldGUI.fxml"));
		Parent wurzel = (Parent) fxmlLoader.load();
		Stage spielfeld = new Stage();
		spielfeld.setTitle("Dominion");
		spielfeld.setScene(new Scene(wurzel));
		spielfeld.show();
		spielfeld.setResizable(false);
		spielfeld.setFullScreen(true);
		spielfeld.setOnCloseRequest(event1 -> {
			fxmlLoader.<Spielfeld_Controller>getController().stopStage();
			try {
				Kommunikation.conclose();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		spielfeld.setOnHiding(event2 -> {
			fxmlLoader.<Spielfeld_Controller>getController().stopStage();


		});

	}

	/**
	 * 
	 * @author Eduart Bunjaku / Jan Mueller
	 *
	 */

	@FXML
	public void soundAbspielen(MouseEvent event) {
		MP3.spieleMusik();
		hs.playHintergrundLoop();

	}

	/**
	 * 
	 * @author Eduart Bunjaku / Jan Mueller
	 *
	 */

	@FXML
	public void soundAus(){
		MP3.spieleMusik();
		hs.stopHintergrundLoop();
	}

	/**
	 * 
	 * @author Lars Lutz / Jan Mueller
	 *
	 */
	@FXML
	public void chatOeffnen(ActionEvent event) throws IOException {
		MP3.spieleMusik();
		// oeffnet neues fenster wenn noch keins offen ist

		if(lm.getChatIstOffen() == false){
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../chat/ChatGUI.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Chat");
			stage.setScene(new Scene(root1)); 
			stage.show();
			stage.setResizable(false);

			stage.setOnCloseRequest(event1 -> {
				fxmlLoader.<Chat_Controller>getController().stopStage();
			});
		}
		lm.setChatIstOffen(true);
	}

	/**
	 * 
	 * @author Eduart Bunjaku
	 *
	 */


	@FXML
	public void leaderboardAnzeigen(ActionEvent event) throws IOException {
		MP3.spieleMusik();

		// oeffnet neues fenster
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../leaderboard/LeaderboardGUI.fxml"));
		Parent wurzel = (Parent) fxmlLoader.load();
		Stage leaderboard = new Stage();
		leaderboard.setScene(new Scene(wurzel));  
		leaderboard.show();
		leaderboard.setResizable(false);
	}



	/**
	 * 
	 * @author Jan Mueller
	 *
	 */

	@FXML
	public void anleitungAnzeigen(ActionEvent event)throws IOException {
		MP3.spieleMusik();

		// oeffnet neues fenster
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../montageAnleitung/MontageAnleitungGUI.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));  
		stage.show();
		stage.setResizable(false);
	}


	/**Beendet das Programm.
	 * 
	 * @author Eduart Bunjaku
	 *
	 */

	@FXML
	public void beenden(ActionEvent event) {
		MP3.spieleMusik();
		Stage lobby = (Stage) leaderBoardButton.getScene().getWindow();
		lobby.close();
		try {
			Kommunikation.conclose();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Platform.exit();
	}



}
