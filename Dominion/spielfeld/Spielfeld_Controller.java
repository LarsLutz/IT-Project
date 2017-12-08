package spielfeld;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import com.sun.java_cup.internal.runtime.Symbol;

import Logik.Spieler;
import Logik.Zaehler;
import SammlungP.Sammlung;
import chat.getNachricht;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import kommunikation.Decoder;
import kommunikation.Kommunikation;
import kommunikation.Updater;

public class Spielfeld_Controller {

	// Jan Mueller

	private Spielfeld_Model sm;
	private Sammlung sam;
	private Spieler spie;
	private int ivCounter = 0;
	private ArrayList<ImageView> viewList;
	private Decoder dec;
	private Thread thread;
	
	

	public Spielfeld_Controller() {
		sm = new Spielfeld_Model(13);
		sam = new Sammlung();
		spie = new Spieler(0);
		dec= new Decoder();
		
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new getLabel(this, sm), 0,1000);
	}
	
	@FXML
	BorderPane grundbp;

	@FXML
	ImageView hintergrund, rueckseiteNormal, rueckseiteDeck;
	@FXML
	ImageView kupfer, silber, gold, anwesen1, anwesen3, anwesen6;
	@FXML
	ImageView bazaarMiddle, villageMiddle, chancellorMiddle, marketMiddle, smithyMiddle;

	@FXML
	Button bSpeichern, bP1, bP2, bP3, bZugBeenden;

	@FXML
	TextArea tVerlauf, tEingabe;

	@FXML
	Pane pKupfer, pSilber, pGold, p1, p3, p6, pMeinDiscardPile, pMeinDeck, pTop;
	@FXML
	Pane pBazaarMiddle, pVillageMiddle, pChancellorMiddle, pMarketMiddle, pSmithyMiddle;

	@FXML
	Label anzahlMeinStapel, anzahlAblageStapel, infoLabel, verbAktionen, verbKaeufe, verbGuthaben, startLabel, opLogger;
//opLogger --> label zeigt an was gegner macht

	@FXML
	HBox hBoxBottom, hBoxRealHand;
	
	private void labelsAktualisieren(){
		verbGuthaben.setText(Zaehler.getGuthaben()+"");
		verbAktionen.setText(Zaehler.getAktionsZaehler()+"");
		verbKaeufe.setText(Zaehler.getKaufZaehler()+"");
		anzahlMeinStapel.setText(spie.deckliste.size() + "");
		anzahlAblageStapel.setText(spie.abwerfliste.size() + "");
		
		
	}
	
	public void standardAktionsKarteHandler(int no){
		spie.aktionsKarteSpielen(no);
		hBoxRealHand.getChildren().remove(no);
	}
	
	//Lars Lutz
	public void nachrichtSenden(String nachricht){
		
		String c1 =nachricht;
		 
		if (c1 != null && !c1.isEmpty()) { //Checkt ob überhaupt etwas gesendet werden kann
			try {
				Kommunikation.sendenClient(c1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void spielerEnabeln() {
		grundbp.setDisable(false);
		pMeinDeck.setDisable(true);
		bZugBeenden.setDisable(true);
		//TODO Jan Müller
		
	}
	
	
	
	
	

	// wird vor dem oeffnen des Fensters gemacht
	@FXML
	public void initialize(){
		
		
		String c2= Spielfeld_Model.getPlayername()+"-spielf-init-$START";
		try {
			Kommunikation.sendenClient(c2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		this.thread=new Thread(new Updater(dec));
		this.thread.start();
		
		
		viewList = new ArrayList<ImageView>();
		for (int i = 0; i < sm.getAnzahlStarthand(); i++) {
			this.karteZiehen();
		}
		pMeinDeck.setDisable(true);
		bazaarMiddle.setDisable(true);
		villageMiddle.setDisable(true);
		chancellorMiddle.setDisable(true);
		marketMiddle.setDisable(true);
		smithyMiddle.setDisable(true);
		kupfer.setDisable(true);
		silber.setDisable(true);
		gold.setDisable(true);
		anwesen1.setDisable(true);
		anwesen3.setDisable(true);
		anwesen6.setDisable(true);
		Zaehler.beginnZug();
		Zaehler.addGuthaben(50);
		Zaehler.kaufZaehler = 100;
		
		labelsAktualisieren();
	}

	// LÃ¶st das Ziehen bzw. Erzeugen einer Karte aus.
	@FXML
	public void karteZiehen() {
		// Behandlung des decks wenn dieses leer ist... -- wird nicht auf der Methode direkt gemacht um eine emptyStackException zu umgehen...
		if(spie.deckliste.size() == 0){
			spie.deckIstLeer();
		}

		// ziehen unter normalen umstaenden
		StackPane p = new StackPane();
		ImageView iv = new ImageView(new Image(this.getClass().getResourceAsStream(spie.deckliste.peek().getPfad())));
		viewList.add(iv);
		p.setOnMousePressed((event)->{ 
			p.setOpacity(0.5); 
			});
		p.setOnMouseReleased((event)->{ 
			 p.setOpacity(1);
		});
		 
		 
		// einzelne Karten werden von der Hand ausgespielt
		p.setOnMouseClicked((event)->{
			
			int aktuellerIndex = hBoxRealHand.getChildren().indexOf(p);
			
			//Geldkarten von Hand spielen
			if(spie.handliste.get(aktuellerIndex).getWert() >= 1 && sm.getKaufPhase() == true){
				spie.geldKarteSpielen(aktuellerIndex);
				hBoxRealHand.getChildren().remove(aktuellerIndex);
				//TODO -- hier sagen wieviel Geld der gegner gespielt hat
				nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Geld gespielt");
			}
			
			
			//Aktionskarten von Hand spielen
			if(sm.getAktionsPhase() == true && (spie.handliste.get(aktuellerIndex).getName().equals("Bazaar")) && Zaehler.aktionsZaehler > 0){
				standardAktionsKarteHandler(aktuellerIndex);
				sam.aktionsKarten[0].karteSpielen();
				//TODO -- Gegner spielt Basar
				nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Aktionskarte Basar gespielt");
			}
					
			if(sm.getAktionsPhase() == true && (spie.handliste.get(aktuellerIndex).getName().equals("Chancellor")) && Zaehler.aktionsZaehler > 0){
				standardAktionsKarteHandler(aktuellerIndex);
				sam.aktionsKarten[1].karteSpielen();
				spie.deckDiscard();
				nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Aktionskarte Kanzler gespielt");
			}
			
			if(sm.getAktionsPhase() == true && (spie.handliste.get(aktuellerIndex).getName().equals("Dorf")) && Zaehler.aktionsZaehler > 0){
				standardAktionsKarteHandler(aktuellerIndex);
				sam.aktionsKarten[2].karteSpielen();
				karteZiehen();
				//TODO -- Gegner spielt Aktionskarte Dorf
				nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Aktionskarte Dorf gespielt");
			}
			
			if(sm.getAktionsPhase() == true && (spie.handliste.get(aktuellerIndex).getName().equals("Markt")) && Zaehler.aktionsZaehler > 0){
				standardAktionsKarteHandler(aktuellerIndex);
				karteZiehen();
				sam.aktionsKarten[3].karteSpielen();
				//TODO -- Gegner spielt Aktionskarte Markt
				nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Aktionskarte Markt gespielt");
			}
			
			if(sm.getAktionsPhase() == true && (spie.handliste.get(aktuellerIndex).getName().equals("Smithy")) && Zaehler.aktionsZaehler > 0){
				standardAktionsKarteHandler(aktuellerIndex);
			for(int i = 0; i<3; i++) {
					karteZiehen();
				}
			//TODO -- Gegner spielt Schmied	
			nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Aktionskarte Schmied gespielt");
			}
				
			
			labelsAktualisieren();
			
			//Test
			System.out.println(spie.handliste);
			System.out.println(spie.abwerfliste);
		});
		
		
		
		
		
		spie.KarteZiehen(1);
		labelsAktualisieren();
		
		
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
		//TODO -- Gegner wechselt in Aktionsphase
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner wechselt in die Aktionsphase");
		sm.setAktionsPhase(true);
		startLabel.setText("Aktionsphase");
		bP1.setDisable(true);
		pMeinDeck.setDisable(true);
	}

	// Kaufphasen Knopf geklickt
	@FXML
	public void kaufPhase() {
		//TODO -- Gegner wechselt in Kaufphase
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner wechselt in Kaufphase");
		sm.setAktionsPhase(false);
		sm.setKaufPhase(true);
		startLabel.setText("Kaufphase");
		bP1.setDisable(true);
		bP2.setDisable(true);
		pMeinDeck.setDisable(true);
		bazaarMiddle.setDisable(false);
		villageMiddle.setDisable(false);
		chancellorMiddle.setDisable(false);
		marketMiddle.setDisable(false);
		smithyMiddle.setDisable(false);
		kupfer.setDisable(false);
		silber.setDisable(false);
		gold.setDisable(false);
		anwesen1.setDisable(false);
		anwesen3.setDisable(false);
		anwesen6.setDisable(false);
		
		
		
	}
	
	//Durch klick auf versch. Aktions- , Geld- und Punktekarten (in der Kaufphase)
	//werden diese bei entsprechendem Guthaben gekauft
	@FXML
	public void clickSmithyMiddle(){
		spie.kartenKaufen(sam.aktionsKarten[4]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Schmied
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Schmied");
	}
	
	@FXML
	public void clickMarketMiddle(){
		spie.kartenKaufen(sam.aktionsKarten[3]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Markt
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Markt");
	}
	
	@FXML
	public void clickChancellorMiddle(){
		spie.kartenKaufen(sam.aktionsKarten[1]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Kanzler
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Kanzler");
	}
	
	@FXML
	public void clickCellarMiddle(){
		spie.kartenKaufen(sam.aktionsKarten[2]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Dorf
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Dorf");
	}
	
	@FXML
	public void clickBazaarMiddle(){
		spie.kartenKaufen(sam.aktionsKarten[0]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Basar
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Basar");
	}
	
	@FXML
	public void clickKupfer(){
		spie.kartenKaufen(sam.geldKarten[0]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Kupfer
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Kupfer");
	}
	
	@FXML
	public void clickSilber(){
		spie.kartenKaufen(sam.geldKarten[1]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Silber
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Silber");
	}
	
	@FXML
	public void clickGold(){
		spie.kartenKaufen(sam.geldKarten[2]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Gold
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Gold");
	}
	
	@FXML
	public void clickAnwesen1(){
		spie.kartenKaufen(sam.punkteKarten[0]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Anwesen
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Anwesen");
	}
	
	@FXML
	public void clickAnwesen3(){
		spie.kartenKaufen(sam.punkteKarten[1]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Herzogtum
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Herzogtum");
	}
	
	@FXML
	public void clickAnwesen6(){
		spie.kartenKaufen(sam.punkteKarten[2]);
		
		labelsAktualisieren();
		//TODO -- Gegner kauft Provinz
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Provinz");
	}
	
	
	
	
	
	
	

	// Discardphasen Knopf geklickt
	@FXML
	public void discardPhase() {
		//TODO -- Gegner wirft seine Hand ab
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner wirft seine Hand ab");
		sm.setKaufPhase(false);
		sm.setDiscardPhase(true);

		spie.discard();

		hBoxRealHand.getChildren().clear();
		labelsAktualisieren();
		

		for (int i = 0; i < 5; i++) {
			this.karteZiehen();
		}
		
		sm.setDiscardPhase(false);
		
		bP3.setDisable(true);
		bP1.setDisable(true);
		bP2.setDisable(true);
		pMeinDeck.setDisable(true);
		bazaarMiddle.setDisable(true);
		villageMiddle.setDisable(true);
		chancellorMiddle.setDisable(true);
		marketMiddle.setDisable(true);
		smithyMiddle.setDisable(true);
		kupfer.setDisable(true);
		silber.setDisable(true);
		gold.setDisable(true);
		anwesen1.setDisable(true);
		anwesen3.setDisable(true);
		anwesen6.setDisable(true);
		bZugBeenden.setDisable(false);
	}

	// zugBeenden Knopf Klicken - erst nach abgeschlossenem Discard moeglich
	@FXML
	public void zugBeenden() {
		//TODO -- Gegner beendet seinen Zug
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner beendet seinen Zug");
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-zug-1");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO -- Du bist am Zug
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Du bist am Zug");
		grundbp.setDisable(true);
		opLogger.setDisable(false);
		Zaehler.beginnZug();
		labelsAktualisieren();
		//Sobald gegner Zug beenden drückt wird folgendes ausgefuehrt:
		
		
		
		
		
		//Eduart Bunjaku
		spie.setAktuelleRunde(spie.getAktuelleRunde()+1);
		System.out.println(spie.getAktuelleRunde());
		if(spie.getAktuelleRunde() == spie.getLetzteRunde()){
			spie.beendeSpiel(); // funktioniert noch nicht 
		}
		
		
	}
	
	//wieder Jan Mueller
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

	// Klickeffekt wird ausgelÃ¶st
	// Deck
	@FXML
	public void pressDeck() {
		rueckseiteDeck.setOpacity(0.5);
	}

	@FXML
	public void releaseDeck() {
		rueckseiteDeck.setOpacity(1);
	}

	// Kupfer
	@FXML
	public void pressKupfer() {
		kupfer.setOpacity(0.5);
	}

	@FXML
	public void releaseKupfer() {
		kupfer.setOpacity(1);
	}

	// Silber
	@FXML
	public void pressSilber() {
		silber.setOpacity(0.5);
	}

	@FXML
	public void releaseSilber() {
		silber.setOpacity(1);
	}

	// Gold
	@FXML
	public void pressGold() {
		gold.setOpacity(0.5);
	}

	@FXML
	public void releaseGold() {
		gold.setOpacity(1);
	}

	// anwesen1
	@FXML
	public void pressAnwesen1() {
		anwesen1.setOpacity(0.5);
	}

	@FXML
	public void releaseAnwesen1() {
		anwesen1.setOpacity(1);
	}

	// anwesen3
	@FXML
	public void pressAnwesen3() {
		anwesen3.setOpacity(0.5);
	}

	@FXML
	public void releaseAnwesen3() {
		anwesen3.setOpacity(1);
	}

	// anwesen6
	@FXML
	public void pressAnwesen6() {
		anwesen6.setOpacity(0.5);
	}

	@FXML
	public void releaseAnwesen6() {
		anwesen6.setOpacity(1);
	}

	// basar
	@FXML
	public void pressBazaarMiddle() {
		bazaarMiddle.setOpacity(0.5);
	}

	@FXML
	public void releaseBazaarMiddle() {
		bazaarMiddle.setOpacity(1);
	}

	// kanzler
	@FXML
	public void pressChancellorMiddle() {
		chancellorMiddle.setOpacity(0.5);
	}

	@FXML
	public void releaseChancellorMiddle() {
		chancellorMiddle.setOpacity(1);
	}

	// Schmied
	@FXML
	public void pressSmithyMiddle() {
		smithyMiddle.setOpacity(0.5);
	}

	@FXML
	public void releaseSmithyMiddle() {
		smithyMiddle.setOpacity(1);
	}

	// Keller
	@FXML
	public void pressCellarMiddle() {
		villageMiddle.setOpacity(0.5);
	}

	@FXML
	public void releaseCellarMiddle() {
		villageMiddle.setOpacity(1);
	}

	// markt
	@FXML
	public void pressMarketMiddle() {
		marketMiddle.setOpacity(0.5);
	}

	@FXML
	public void releaseMarketMiddle() {
		marketMiddle.setOpacity(1);
	}

	// soll den Text mit einem Klick auf Enter absenden(Chat - TODO)
	@FXML
	public void enterKlick() {
		System.out.println(
				"Taste gedrÃ¼ckt.. jetzt noch auf Enter... Bei tastendruck ist es kein MouseEvent sondern ein..?");
	}

}
