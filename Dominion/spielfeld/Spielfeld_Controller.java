package spielfeld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

import Logik.Spieler;
import Logik.Zaehler;
import SammlungP.Sammlung;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import kommunikation.Decoder;
import kommunikation.Kommunikation;
import kommunikation.Updater;

/**
 * 
 * @author  Jan Mueller / Lars Lutz
 * FXML GUI @author Jan Mueller 
 * "Logik" @author Jan Mueller
 *  (Lars Lutz Messages)
 */

public class Spielfeld_Controller {


	private Spielfeld_Model sm;
	private Spieler spie;
	private ArrayList<ImageView> viewList;
	private Decoder dec;
	private Thread thread;
	private Timer timer;
	private Updater updater;
	public int rundenZaehler = 1;
	
	
    /**
     * 
     * @author  Jan Mueller
     *
     */
	public Spielfeld_Controller() {
		sm = new Spielfeld_Model(13);
		spie = new Spieler(0);
		dec= new Decoder();
		
		//Lars Lutz
		timer = new Timer();
		
		timer.scheduleAtFixedRate(new getLabel(this, sm), 0,1000);
	}
	
    /**
     * 
     * @author  Jan Mueller
     *
     *Alle SceneBuilder Elemente mit FXML tag
     */
	
	@FXML
	BorderPane grundbp;

	@FXML
	ImageView rueckseiteNormal, rueckseiteDeck;
	@FXML
	ImageView kupfer, silber, gold, anwesen1, anwesen3, anwesen6;
	@FXML
	ImageView bazaarMiddle, villageMiddle, chancellorMiddle, marketMiddle, smithyMiddle;

	@FXML
	Button bSpeichern, bP1, bP2, bP3, bZugBeenden;

	@FXML
	TextArea tVerlauf;
	
	@FXML
	TextField tEingabe;

	@FXML
	Pane pKupfer, pSilber, pGold, p1, p3, p6, pMeinDiscardPile, pMeinDeck, pTop;
	@FXML
	Pane pBazaarMiddle, pVillageMiddle, pChancellorMiddle, pMarketMiddle, pSmithyMiddle;

	@FXML
	Label anzahlMeinStapel, anzahlAblageStapel, infoLabel, verbAktionen, verbKaeufe, verbGuthaben, startLabel, opLogger, lAktRun, lAktRunCount;

	@FXML
	HBox hBoxBottom, hBoxRealHand;
	
    /**
     * 
     * @author Jan Mueller
     * 
     * Methode wird immer wieder aufgerufen um unten aufgelistete "StandardLabels" zu aktualisieren
     */
	
	private void labelsAktualisieren(){
		verbGuthaben.setText(Zaehler.getGuthaben()+"");
		verbAktionen.setText(Zaehler.getAktionsZaehler()+"");
		verbKaeufe.setText(Zaehler.getKaufZaehler()+"");
		anzahlMeinStapel.setText(spie.deckliste.size() + "");
		anzahlAblageStapel.setText(spie.abwerfliste.size() + "");
		if(Spielfeld_Model.getPlayername().equals("player2")){
			lAktRunCount.setText(rundenZaehler+""+""+" / 20");
		}
		
		
	}
	
    /**
     * 
     * @author  Jan Mueller
     * @param Index der HBox an dem die abzuwerfende Aktionskarte ist
     * entfernt die angeklickte Aktionskarte aus der Hand
     */
	
	public void standardAktionsKarteHandler(int no){
		spie.aktionsKarteSpielen(no);
		hBoxRealHand.getChildren().remove(no);
	}
	
    /**
     * 
     * @author  Lars Lutz
     *
     */
	public void nachrichtSenden(String nachricht){
		
		String c1 =nachricht;
		 
		if (c1 != null && !c1.isEmpty()) { //Checkt ob �berhaupt etwas gesendet werden kann
			try {
				Kommunikation.sendenClient(c1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
    /**
     * 
     * @author  Jan Mueller
     * 
     * setDisable(false/true) auf alles was ein Spieler in seinem Zug braucht)
     *
     */
	public void spielerEnabeln() {
		grundbp.setDisable(false);
		pMeinDeck.setDisable(true);
		bZugBeenden.setDisable(true);
		bP1.setDisable(false);
		bP2.setDisable(false);
		bP3.setDisable(false);
		
	}
	
	
    /**
     * 
     * @author  Lars Lutz
     *
     */
	public void stopStage(){
		timer.cancel();
		timer.purge();
		updater.schliessen();

	    System.err.println("Stage is closing");
	}
	
	
	

    /**
     * 
     * @author  Jan Mueller / Lars Lutz
     * passiert sobald das Fenster aufgeht
     */
	@FXML
	public void initialize(){
		//Jan Mueller - 
		lAktRunCount.setText(rundenZaehler+""+" / 20");
		//Chatstyle
		tVerlauf.setStyle("-fx-text-inner-color: red;");
		tVerlauf.setOpacity(0.45);
		//css Code von Stack overflow - setzt Hintergrundbild (kein ImageView damit Vollbild funktioniert)
		grundbp.setStyle("-fx-background-image: url(\"/spielfeld/BildSpielbrett.jpg\");-fx-background-size: cover, auto;-fx-background-repeat: no-repeat;");
		
		//Lars Lutz
		opLogger.setText("Du bist am Zug" );
		String c2= Spielfeld_Model.getPlayername()+"-spielf-init-$START";
		try {
			Kommunikation.sendenClient(c2);
			System.out.println("Sende startbefehl");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		updater= new Updater(dec);
		this.thread=new Thread(updater);
		this.thread.start();
		
	    //Jan Mueller 
		viewList = new ArrayList<ImageView>();
		//Starthand aufbauen (fuer spieler)
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
		
		labelsAktualisieren();
	}

    /**
     * 
     * @author  Jan Mueller
     *
     * Nachrichten @author Lars Lutz
     * behandelt viel mehr als karteZiehen
     */
	
	@FXML
	public void karteZiehen() {
		// Behandlung des decks wenn dieses leer ist
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
			
			//Geldkarten von Hand spielen - wenn der Wert groesser als 1 ist (sind alle anderen Karten nicht) und wir in der Kaufphase sind kann die Karte gespielt werden
			if(spie.handliste.get(aktuellerIndex).getWert() >= 1 && sm.getKaufPhase() == true){
				spie.geldKarteSpielen(aktuellerIndex);
				hBoxRealHand.getChildren().remove(aktuellerIndex);
				//Nachrichten - Lars Lutz
				nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Geldkarte gespielt");
			}
			
			
			//Aktionskarten von Hand spielen - einzeln nach richtiger Aktionskarten fragen - Nachrichten von Lars Lutz
			if(sm.getAktionsPhase() == true && (spie.handliste.get(aktuellerIndex).getName().equals("Bazaar")) && Zaehler.aktionsZaehler > 0){
				standardAktionsKarteHandler(aktuellerIndex);
				Sammlung.aktionsKarten[0].karteSpielen();
				karteZiehen();
				
				nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Aktionskarte Basar gespielt");
			}
					
			if(sm.getAktionsPhase() == true && (spie.handliste.get(aktuellerIndex).getName().equals("Chancellor")) && Zaehler.aktionsZaehler > 0){
				standardAktionsKarteHandler(aktuellerIndex);
				Sammlung.aktionsKarten[1].karteSpielen();
				spie.deckDiscard();
				labelsAktualisieren();
				
				nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Aktionskarte Kanzler gespielt");
			}
			
			if(sm.getAktionsPhase() == true && (spie.handliste.get(aktuellerIndex).getName().equals("Dorf")) && Zaehler.aktionsZaehler > 0){
				standardAktionsKarteHandler(aktuellerIndex);
				Sammlung.aktionsKarten[2].karteSpielen();
				karteZiehen();
				
				nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Aktionskarte Dorf gespielt");
			}
			
			if(sm.getAktionsPhase() == true && (spie.handliste.get(aktuellerIndex).getName().equals("Markt")) && Zaehler.aktionsZaehler > 0){
				standardAktionsKarteHandler(aktuellerIndex);
				karteZiehen();
				Sammlung.aktionsKarten[3].karteSpielen();
				
				nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Aktionskarte Markt gespielt");
			}
			
			if(sm.getAktionsPhase() == true && (spie.handliste.get(aktuellerIndex).getName().equals("Smithy")) && Zaehler.aktionsZaehler > 0){
				standardAktionsKarteHandler(aktuellerIndex);
			for(int i = 0; i<3; i++) {
					karteZiehen();
				}
			
			nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner hat Aktionskarte Schmied gespielt");
			}
				
			
			labelsAktualisieren();			
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
		
	}
	
    /**
     * 
     * @author  Jan Mueller
     * 
     * Klick auf den Aktionsphasen Knopf
     * Nachrichten von @author Lars Lutz
     */
	@FXML
	public void aktionsPhase() {
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner wechselt in die Aktionsphase");
		sm.setAktionsPhase(true);
		startLabel.setText("Aktionsphase");
		bP1.setDisable(true);
		pMeinDeck.setDisable(true);
	}

	
    /**
     * 
     * @author  Jan Mueller
     * Klick auf den kaufPhasen Knopf
     * ausser Nachrichten @author Lars Lutz
     */
	
	@FXML
	public void kaufPhase() {
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
	
    /**
     * 
     * @author  Jan Mueller
     * 
     * Durch klick auf versch. Aktions- , Geld- und Punktekarten (in der Kaufphase da nur dann nicht disabelt)
	 * werden diese bei entsprechendem Guthaben gekauft
	 * 
     *Nachrichten @author Lars Lutz
     */

	
	@FXML
	public void clickSmithyMiddle(){
		spie.kartenKaufen(Sammlung.aktionsKarten[4]);
		
		labelsAktualisieren();
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Schmied");
	}
	
	@FXML
	public void clickMarketMiddle(){
		spie.kartenKaufen(Sammlung.aktionsKarten[3]);
		labelsAktualisieren();
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Markt");
	}
	
	@FXML
	public void clickChancellorMiddle(){
		spie.kartenKaufen(Sammlung.aktionsKarten[1]);
		labelsAktualisieren();
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Kanzler");
	}
	
	@FXML
	public void clickCellarMiddle(){
		spie.kartenKaufen(Sammlung.aktionsKarten[2]);
		labelsAktualisieren();
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Dorf");
	}
	
	@FXML
	public void clickBazaarMiddle(){
		spie.kartenKaufen(Sammlung.aktionsKarten[0]);
		labelsAktualisieren();
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Basar");
	}
	
	@FXML
	public void clickKupfer(){
		spie.kartenKaufen(Sammlung.geldKarten[0]);
		labelsAktualisieren();
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Kupfer");
	}
	
	@FXML
	public void clickSilber(){
		spie.kartenKaufen(Sammlung.geldKarten[1]);
		labelsAktualisieren();
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Silber");
	}
	
	@FXML
	public void clickGold(){
		spie.kartenKaufen(Sammlung.geldKarten[2]);
		labelsAktualisieren();
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Gold");
	}
	
	@FXML
	public void clickAnwesen1(){
		spie.kartenKaufen(Sammlung.punkteKarten[0]);
		labelsAktualisieren();
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Anwesen");
	}
	
	@FXML
	public void clickAnwesen3(){
		spie.kartenKaufen(Sammlung.punkteKarten[1]);
		labelsAktualisieren();

		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Herzogtum");
	}
	
	@FXML
	public void clickAnwesen6(){
		spie.kartenKaufen(Sammlung.punkteKarten[2]);
		labelsAktualisieren();
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner kauft Provinz");
	}

    /**
     * 
     * @author  Jan Mueller
     *Nachtrichten @author Lars Lutz
     *Discardphasen Knopf geklickt
     *
     */
	@FXML
	public void discardPhase() {
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner wirft seine Hand ab");
		sm.setKaufPhase(false);
		sm.setDiscardPhase(true);
		
		//"aktualisiert" Logik
		spie.discard();

		hBoxRealHand.getChildren().clear();
		labelsAktualisieren();
		
		//5 Karten nachziehen
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
	
	
    /**
     * 
     * @author  Jan Mueller
     * zugBeenden Knopf Klicken - erst nach abgeschlossenem Discard moeglich
     *Nachrichten @author Lars Lutz
     *	
     */
	
	@FXML
	public void zugBeenden() throws IOException{
		//Label oben rechts
		if(Spielfeld_Model.getPlayername().equals("player2")){
			rundenZaehler++;
		}
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Gegner beendet seinen Zug");
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-zug-1");
		
		//relevant fuer SiegNiederlage
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-runde-"+ spie.getAktuelleRunde());
		//@author Lars Lutz
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-label-Du bist am Zug");
		//Jan Mueller
		bZugBeenden.setDisable(true);
		Zaehler.beginnZug();
		
		labelsAktualisieren();
		opLogger.setText("Gegner am Zug");

	/**
	 * 
	 * @author Lars Lutz und Jan Mueller
	 * um GameOver Screen auzurufen
	 * 
	 * 
	 */
			
	if(Spielfeld_Model.getPlayername().equals("player2")){
		spie.setAktuelleRunde(spie.getAktuelleRunde()+1);
		System.out.println("Aktuelle Runde: " +spie.getAktuelleRunde());
		
		if(spie.getAktuelleRunde() == spie.getLetzteRunde()){
			spie.punkteBerechnen();
			nachrichtSenden(Spielfeld_Model.getPlayername() + "-spieler-punkte-" + spie.getGesamtpunkte());
			nachrichtSenden(Spielfeld_Model.getPlayername()+"-spielf-ende-$Ende");
			
		}
	}

	
}
	
    /**
     * 
     * @author  Lars Lutz
     *
     */
	public void setResultat(){
		grundbp.setDisable(true);
		spie.punkteBerechnen();
		spie.punkteVergleich();
		
		try {
			nachrichtSenden(Spielfeld_Model.getPlayername() + "-spieler-finale-" + Spielfeld_Model.getGewinner());
			neuesFenster();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
    /**
     * 
     * @author  Jan Mueller
     * GameOver Screen aufrufen wenn Zug beenden geklickt wird
     * 
     */
	public void neuesFenster() throws IOException{
		
		//aktuelles Fenster schliessen
		Stage currentStage = (Stage) bZugBeenden.getScene().getWindow();
		currentStage.close();
	
		//Game Over Screen einblenden
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gewonnen/SiegNiederlageGUI.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setFullScreen(false);
		stage.setScene(new Scene(root1));  
		stage.show();
	}
	
    /**
     * 
     * @author  Jan Mueller
     * on MouseEntered - damals noch keine Kenntnisse ueber Tooltips
     */
	
	@FXML
	public void infoKanzler() {
		infoLabel.setText(Sammlung.aktionsKarten[1].getBeschreibung());
	}

	@FXML
	public void infoSchmied() {
		infoLabel.setText(Sammlung.aktionsKarten[4].getBeschreibung());
	}

	@FXML
	public void infoKeller() {
		infoLabel.setText(Sammlung.aktionsKarten[2].getBeschreibung());
	}

	@FXML
	public void infoBasar() {
		infoLabel.setText(Sammlung.aktionsKarten[0].getBeschreibung());
	}

	@FXML
	public void infoMarkt() {
		infoLabel.setText(Sammlung.aktionsKarten[3].getBeschreibung());
	}

    /**
     * 
     * @author  Jan Mueller
     * Klickeffekt hinzugefuegt (opacity)
     *
     */
	
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

	
    /**
     * Beim dr�cken von Enter wird der Inhalt vom Textfeld gesendet
     * @author  Lars Lutz  
     *    
     * 
     */
	
	
	
	@FXML
	public void sendenEnter(KeyEvent keyevent) throws InterruptedException{

		if (keyevent.getCode() == KeyCode.ENTER)  {

		String c1;
		c1= Spielfeld_Model.getSpielername()+"-spielf-chat-"+ tEingabe.getText().replaceAll("-", "_");
		if (c1 != null && !c1.isEmpty()) { //Checkt ob �berhaupt etwas gesendet werden kann
			try {
				Kommunikation.sendenClient(c1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			tEingabe.clear();
			
			
		}
		}
		
	}

}
