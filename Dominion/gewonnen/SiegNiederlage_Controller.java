package gewonnen;

import java.io.IOException;

/**
 * @autor Eduart Bunjaku
 */


import Logik.Spieler;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import kommunikation.Kommunikation;
import spielfeld.Spielfeld_Model;

/**
 * 
 * @author Eduart Bunjaku
 *
 */

public class SiegNiederlage_Controller {
	
	// Instanzdaten
	private Spieler s;
	private SiegNiederlage_Model model;
	
	
	// Konstruktor
	public SiegNiederlage_Controller(){
		s = new Spieler(0);
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
	
	//quasi unsere CompareTo Methode
	public void initialize(){

		if (Spielfeld_Model.getPlayername().equals("player1")){
			
			labNachricht.setText(Spielfeld_Model.getGewinner());
		}else {
			
			if (Spielfeld_Model.getGewinner().equals("GEWONNEN")){
				labNachricht.setText("VERLOREN");
			}
			if (Spielfeld_Model.getGewinner().equals("VERLOREN")){
				labNachricht.setText("GEWONNEN");
			}
			if (Spielfeld_Model.getGewinner().equals("UNENTSCHIEDEN")){
				labNachricht.setText("UNENTSCHIEDEN");
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
