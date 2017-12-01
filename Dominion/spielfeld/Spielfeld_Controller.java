package spielfeld;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import com.sun.java_cup.internal.runtime.Symbol;

import Logik.Spieler;
import Logik.Zaehler;
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
import javafx.scene.layout.StackPane;

public class Spielfeld_Controller {

	// Jan Mueller

	private Spielfeld_Model sm;
	private Sammlung sam;
	private Spieler spie;
	private int ivCounter = 0;
	private ArrayList<ImageView> viewList;
	

	public Spielfeld_Controller() {
		sm = new Spielfeld_Model(11);
		sam = new Sammlung();
		spie = new Spieler(0);
	}

	@FXML
	ImageView hintergrund, rueckseite, rueckseiteNormal, rueckseiteDeck;
	@FXML
	ImageView kupfer, silber, gold, anwesen1, anwesen3, anwesen6;
	@FXML
	ImageView bazaarMiddle, cellarMiddle, chancellorMiddle, marketMiddle, smithyMiddle;

	@FXML
	Button bSpeichern, bP1, bP2, bP3, bZugBeenden;

	@FXML
	TextArea tVerlauf, tEingabe;

	@FXML
	Pane pSeinDeck, pSeinDiscardPile, pKupfer, pSilber, pGold, p1, p3, p6, pMeinDiscardPile, pMeinDeck;
	@FXML
	Pane pBazaarMiddle, pCellarMiddle, pChancellorMiddle, pMarketMiddle, pSmithyMiddle;

	@FXML
	Label anzahlMeinStapel, anzahlAblageStapel, infoLabel, verbAktionen, verbKaeufe, verbGuthaben, startLabel,
			startLabel1;

	@FXML
	HBox hBoxBottom, hBoxRealHand;

	// wird vor dem oeffnen des Fensters gemacht
	@FXML
	public void initialize(){
		viewList = new ArrayList<ImageView>();
		for (int i = 0; i < sm.getAnzahlStarthand(); i++) {
			this.karteZiehen();
		}
		pMeinDeck.setDisable(true);

	}

	// Löst das Ziehen bzw. Erzeugen einer Karte aus...
	@FXML
	public void karteZiehen() {
		// behandlung des decks wenn dieses leer ist...
		if (spie.deckliste.size() == 0) {
			spie.deckIstLeer();
		}

		// ziehen unter normalen umstaenden
		StackPane p = new StackPane();
		ImageView iv = new ImageView(new Image(this.getClass().getResourceAsStream(spie.deckliste.peek().getPfad())));
		p.setOnMousePressed((event)->{ 
			p.setOpacity(0.5); 
			});
		 p.setOnMouseReleased((event)->{ 
			 p.setOpacity(1); 
		});

		spie.KarteZiehen(1);
		anzahlMeinStapel.setText(spie.deckliste.size() + "");
		anzahlAblageStapel.setText(spie.abwerfliste.size() + "");
		
		
		p.setMaxWidth(66);
		p.setMinWidth(66);
		p.setMaxHeight(120);
		p.setMinHeight(120);
		iv.fitWidthProperty().bind(p.widthProperty());
		iv.fitHeightProperty().bind(p.heightProperty());
		
		p.getChildren().add(iv);
		hBoxRealHand.getChildren().add(p);

		ivCounter++;
		if (ivCounter > 4000) {
			ivCounter = 0;
		}
		// testen.... Logger fuer geistig behinderti
//		System.out.println("Deckliste " + spie.deckliste);
//		System.out.println("Handliste " + spie.handliste);
//		System.out.println("Abwerfliste " + spie.abwerfliste);
	}

	// Aktionsphasen Knopf geklickt
	@FXML
	public void aktionsPhase() {
		startLabel.setText("Aktionsphase");
		bP1.setDisable(true);
		pMeinDeck.setDisable(true);
	}

	// Kaufphasen Knopf geklickt
	@FXML
	public void kaufPhase() {
		startLabel.setText("Kaufphase");
		bP1.setDisable(true);
		bP2.setDisable(true);
		pMeinDeck.setDisable(true);
	}

	// Discardphasen Knopf geklickt
	@FXML
	public void discardPhase() {

		// lokale Variable damit wir nachher wissen wieviele Karten zu ziehen
		// sind
		int groesseHand = spie.handliste.size();

		spie.discard();

		hBoxRealHand.getChildren().clear();
		anzahlAblageStapel.setText(spie.abwerfliste.size() + "");
		

		for (int i = 0; i < groesseHand; i++) {
			this.karteZiehen();
		}

		bP3.setDisable(true);
		bP1.setDisable(true);
		bP2.setDisable(true);
		bZugBeenden.setDisable(false);
	}

	// zugBeenden Knopf Klicken - erst nach abgeschlossenem Discard moeglich
	@FXML
	public void zugBeenden() {
		bZugBeenden.setDisable(true);
		pMeinDeck.setDisable(false);
		bP1.setDisable(false);
		bP2.setDisable(false);
		bP3.setDisable(false);
		
		
		
		
		
		//Eduart Bunjaku
		spie.setAktuelleRunde(spie.getAktuelleRunde()+1);
		System.out.println(spie.getAktuelleRunde());
		if(spie.getAktuelleRunde()==10){
			
		}
	}

	// folgende 5 geben beim drueberfahren mit der Maus Informationen ueber die
	// jeweilige AktionsKarte
	@FXML
	public void infoKanzler() {
		infoLabel.setText(sam.aktionsKarten[1].getBeschreibung());
	}

	@FXML
	public void infoSchmied() {
		infoLabel.setText(sam.aktionsKarten[4].getBeschreibung());
	}

	@FXML
	public void infoKeller() {
		infoLabel.setText(sam.aktionsKarten[2].getBeschreibung());
	}

	@FXML
	public void infoBasar() {
		infoLabel.setText(sam.aktionsKarten[0].getBeschreibung());
	}

	@FXML
	public void infoMarkt() {
		infoLabel.setText(sam.aktionsKarten[3].getBeschreibung());
	}

	// Klickeffekt wird ausgelöst
	// Deck
	@FXML
	public void pressDeck() {
		rueckseiteDeck.setOpacity(0.3);
	}

	@FXML
	public void releaseDeck() {
		rueckseiteDeck.setOpacity(1);
	}

	// Kupfer
	@FXML
	public void pressKupfer() {
		kupfer.setOpacity(0.3);
	}

	@FXML
	public void releaseKupfer() {
		kupfer.setOpacity(1);
	}

	// Silber
	@FXML
	public void pressSilber() {
		silber.setOpacity(0.3);
	}

	@FXML
	public void releaseSilber() {
		silber.setOpacity(1);
	}

	// Gold
	@FXML
	public void pressGold() {
		gold.setOpacity(0.3);
	}

	@FXML
	public void releaseGold() {
		gold.setOpacity(1);
	}

	// anwesen1
	@FXML
	public void pressAnwesen1() {
		anwesen1.setOpacity(0.3);
	}

	@FXML
	public void releaseAnwesen1() {
		anwesen1.setOpacity(1);
	}

	// anwesen3
	@FXML
	public void pressAnwesen3() {
		anwesen3.setOpacity(0.3);
	}

	@FXML
	public void releaseAnwesen3() {
		anwesen3.setOpacity(1);
	}

	// anwesen6
	@FXML
	public void pressAnwesen6() {
		anwesen6.setOpacity(0.3);
	}

	@FXML
	public void releaseAnwesen6() {
		anwesen6.setOpacity(1);
	}

	// basar
	@FXML
	public void pressBazaarMiddle() {
		bazaarMiddle.setOpacity(0.3);
	}

	@FXML
	public void releaseBazaarMiddle() {
		bazaarMiddle.setOpacity(1);
	}

	// kanzler
	@FXML
	public void pressChancellorMiddle() {
		chancellorMiddle.setOpacity(0.3);
	}

	@FXML
	public void releaseChancellorMiddle() {
		chancellorMiddle.setOpacity(1);
	}

	// Schmied
	@FXML
	public void pressSmithyMiddle() {
		smithyMiddle.setOpacity(0.3);
	}

	@FXML
	public void releaseSmithyMiddle() {
		smithyMiddle.setOpacity(1);
	}

	// Keller
	@FXML
	public void pressCellarMiddle() {
		cellarMiddle.setOpacity(0.3);
	}

	@FXML
	public void releaseCellarMiddle() {
		cellarMiddle.setOpacity(1);
	}

	// markt
	@FXML
	public void pressMarketMiddle() {
		marketMiddle.setOpacity(0.3);
	}

	@FXML
	public void releaseMarketMiddle() {
		marketMiddle.setOpacity(1);
	}

	// soll den Text mit einem Klick auf Enter absenden(Chat - TODO)
	@FXML
	public void enterKlick() {
		System.out.println(
				"Taste gedrückt.. jetzt noch auf Enter... Bei tastendruck ist es kein MouseEvent sondern ein..?");
	}

}
