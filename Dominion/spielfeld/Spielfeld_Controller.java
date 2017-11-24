package spielfeld;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Spielfeld_Controller {
	
	//Begonnen von Jan Müller - würde das gerne weiterführen :)
	//aufgrund der komplexität (Dynamik etc) habe ich das GUI nicht vervollständigt
	
	private Spielfeld_Model sm;
	
	
	public Spielfeld_Controller(){
		sm = new Spielfeld_Model();
	}
	
	@FXML
	ImageView hintergrund, rueckseite, rueckseiteNormal;
	ImageView kupfer, silber, gold, anwesen1, anwesen3, anwesen6;
	ImageView bazaarMiddle, cellarMiddle, chancellorMiddle, marketMiddle, smithyMiddle;
	
	@FXML
	Button bSpeichern, bP1, bP2, bP3, bZugBeenden;
	
	@FXML
	TextArea tVerlauf, tEingabe;
	
	@FXML
	Pane pSeinDeck, pSeinDiscardPile, pKupfer, pSilber, pGold, p1, p3, p6, pMeinDiscardPile, pMeinDeck;
	Pane pBazaarMiddle, pCellarMiddle, pChancellorMiddle, pMarketMiddle, pSmithyMiddle;
	
	@FXML
	Label anzahlSeinStapel, infoLabel, verbAktionen, verbKaeufe, verbGuthaben;
	
	public void karteZiehen(){
		System.out.println("Diese Aktion löst das Ziehen eine Karte aus.. natürlich nur if...");
	}
	
	@FXML
	public void infoKanzler(){
		infoLabel.setText("Der Kanzler führt und verwaltet das\nReich");
	}
	
	@FXML
	public void infoSchmied(){
		infoLabel.setText("ziehe 3 Karten");
	}
	
	
	@FXML
	public void enterKlick(){
		System.out.println("Taste gedrückt.. jetzt noch auf Enter... Bei tastendruck ist es kein MouseEvent sondern ein..?");
	}
	
	@FXML
	public void infoDiscard(){
		infoLabel.setText("Sein Ablagestapel");
	}
	
	public void infoMeinDiscard(){
		infoLabel.setText("MEIN Abwerfstapel");
	}
	
}
