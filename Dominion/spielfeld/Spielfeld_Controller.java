package spielfeld;

import java.util.Random;

import Logik.Spieler;
import SammlungP.Sammlung;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Spielfeld_Controller {
	
	//Jan Müller
	
	private Spielfeld_Model sm;
	private Sammlung sam;
	private Spieler spie;
	
	
	public Spielfeld_Controller(){
		sm = new Spielfeld_Model(5);
		sam = new Sammlung();
		spie = new Spieler(0);
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
	Label anzahlMeinStapel, anzahlAblageStapel, infoLabel, verbAktionen, verbKaeufe, verbGuthaben, startLabel, startLabel1;
	
	@FXML
	HBox hBoxHand;
	
	
	//Löst das Ziehen bzw. Erzeugen einer Karte aus...
	@FXML
	public void karteZiehen(){
		Pane p = new Pane();
		//ImageView iv = new ImageView(new Image(this.getClass().getResourceAsStream("copper.jpg")));
		ImageView iv = new ImageView(new Image(this.getClass().getResourceAsStream(spie.deckliste.peek().getPfad())));
		spie.KarteZiehen(1);
		anzahlMeinStapel.setText(spie.deckliste.size()+"");
		
		//was passiert wenn mein deck auf 0 kommt?
		if(spie.deckliste.size() == 0){
			anzahlMeinStapel.setStyle("-fx-text-fill: red");
		}
		if(spie.handliste.size() == sm.getWannDisabeln()){
			startLabel.setText("");
			startLabel1.setText("");
			pMeinDeck.setDisable(true);
			bP1.setDisable(false);
			bP2.setDisable(false);
			bP3.setDisable(false);
		}
		
		p.setMaxWidth(66);
		p.setMaxHeight(100);
		//p.setStyle("-fx-background-color: red");
		p.getChildren().add(iv);
		iv.setScaleX(0.3);
		iv.setScaleY(0.3);
		iv.setLayoutY(iv.getLayoutY()-160);
		hBoxHand.getChildren().add(p);
	}
	
	
	//Aktionsphasen Knopf geklickt
	@FXML
	public void aktionsPhase(){
		startLabel.setText("Aktionsphase");
		bP1.setDisable(true);
	}
	
	//Kaufphasen Knopf geklickt
	@FXML
	public void kaufPhase(){
		startLabel.setText("Kaufphase");
		bP1.setDisable(true);
		bP2.setDisable(true);
	}
	
	//Discardphasen Knopf geklickt
	@FXML
	public void discardPhase(){
		
		//TODO -- alles abwerfen und 5 neue Karten ziehen
		
		
		
		bP1.setDisable(true);
		bP2.setDisable(true);
		bP3.setDisable(true);
		bZugBeenden.setDisable(false);
	}
	
	//zugBeenden Knopf Klicken - erst nach abgeschlossenem Discard moeglich
	@FXML
	public void zugBeenden(){
		bZugBeenden.setDisable(true);
		pMeinDeck.setDisable(false);
		sm.setWannDisabeln(1);
	}
	
	
	//folgende 5 geben beim drueberfahren mit der Maus Informationen ueber die jeweilige AktionsKarte
	@FXML
	public void infoKanzler(){
		infoLabel.setText(sam.aktionsKarten[1].getBeschreibung());
	}
	
	@FXML
	public void infoSchmied(){
		infoLabel.setText(sam.aktionsKarten[4].getBeschreibung());
	}
	
	@FXML
	public void infoKeller(){
		infoLabel.setText(sam.aktionsKarten[2].getBeschreibung());
	}
	
	@FXML
	public void infoBasar(){
		infoLabel.setText(sam.aktionsKarten[0].getBeschreibung());
	}
	
	@FXML
	public void infoMarkt(){
		infoLabel.setText(sam.aktionsKarten[3].getBeschreibung());
	}
	
	
	//soll den Text mit einem Klick auf Enter absenden(Chat - TODO)
	@FXML
	public void enterKlick(){
		System.out.println("Taste gedrückt.. jetzt noch auf Enter... Bei tastendruck ist es kein MouseEvent sondern ein..?");
	}
	
	//weitere Infos ueber Karten, wenn man ueber diese drueber faehrt
	@FXML
	public void infoDiscard(){
		infoLabel.setText("Sein Ablagestapel");
	}
	
	public void infoMeinDiscard(){
		infoLabel.setText("MEIN Abwerfstapel");
	}
	
}
