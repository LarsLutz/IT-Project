package gewonnen;

import java.io.IOException;

/**
 * @autor Eduart Bunjaku
 */


import Logik.Spieler;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import kommunikation.Kommunikation;
import spielfeld.Spielfeld_Model;

/**
 * 
 * @author Eduart Bunjaku
 *
 */

public class SiegNiederlage_Controller {

	private SiegNiederlage_Model model;


	// Konstruktor
	public SiegNiederlage_Controller(){
		new Spieler(0);
		model =new SiegNiederlage_Model();
	}

	@FXML
	private Pane wurzel;

	public Pane getWurzel(){
		return this.wurzel;
	}

	@FXML
	Button bOk;

	@FXML
	Label labNachricht;

	@FXML
	ImageView gameOver;

	/** Beim Aufrufen des Fensters setzt die Methode den Text auf Gewinner, Verlierer oder Unentschieden.
	 * 
	 * 
	 */

	public void initialize(){

		if (Spielfeld_Model.getPlayername().equals("player1")){
			labNachricht.setText(Spielfeld_Model.getGewinner()+ "\n"+ "Erreicht Punkte: "+ Spielfeld_Model.getGesamtpunkte());

		}else {
			if (Spielfeld_Model.getGewinner().equals("GEWONNEN")){
				labNachricht.setText("VERLOREN"+"\n"+ "Erreicht Punkte: "+ Spielfeld_Model.getGesamtpunkte());
			}
			if (Spielfeld_Model.getGewinner().equals("VERLOREN")){
				labNachricht.setText("GEWONNEN"+"\n"+ "Erreicht Punkte: "+ Spielfeld_Model.getGesamtpunkte());
			}
			if (Spielfeld_Model.getGewinner().equals("UNENTSCHIEDEN")){
				labNachricht.setText("UNENTSCHIEDEN"+"\n"+ "Erreicht Punkte: "+ Spielfeld_Model.getGesamtpunkte());
			}
		}
	}

	public Label getLabNachricht(){
		return this.labNachricht;
	}

	public void setLabNachricht(Label labNachricht){
		this.labNachricht = labNachricht;
	}

	/**
	 * Wenn man auf den OK-Button klickt, wird das Programm beendet.
	 * 
	 * @param e Mausklick.
	 * @throws IOException
	 */

	public void okKlick(MouseEvent e) throws IOException{
		model.setLeaderboard();
		Kommunikation.conclose();
		Platform.exit();
	}



}
