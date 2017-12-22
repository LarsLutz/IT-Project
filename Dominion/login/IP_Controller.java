package login;


/** Fenster für die Eingabe der Serveradresse
 * @author Lars Lutz
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kommunikation.Kommunikation;

public class IP_Controller {


	@FXML
	Button bOK, blokal;

	@FXML
	Label lInfoText, lIPAdresse;

	@FXML
	TextField tEingabe;




	@FXML
	/**
	 * Setzt die IP Adresse für die Server Verbindung.
	 */
	public void okKlick(){

		String ipadresse;
		ipadresse= tEingabe.getText();
		Kommunikation.setIpadresse(ipadresse);
		Stage currentStage = (Stage) bOK.getScene().getWindow();
		currentStage.close();
	}


	/**
	 * setzt die Lokale Ip Adresse ins Textfeld (vom Standard Netzwerkadapter)
	 * @throws UnknownHostException gibt einen Fehler wenn IP Adresse nicht gelesen werden kann
	 */
	public void localKlick() throws UnknownHostException{

		String ipadresse;
		InetAddress adress= InetAddress.getLocalHost();
		ipadresse= adress.toString();
		String [] part =ipadresse.split("/");

		ipadresse= part[1];


		tEingabe.setText(ipadresse);


	}






}
