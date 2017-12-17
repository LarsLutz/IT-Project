package Logik;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import SammlungP.Spielfeldkarte;
import gewonnen.SiegNiederlage_Controller;
import gewonnen.SiegNiederlage_Main;
import gewonnen.SiegNiederlage_View;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import kommunikation.Kommunikation;
import spielfeld.Spielfeld_Model;
import Karte.AktionsKarte;
import Karte.GeldKarte;
import Karte.PunkteKarte;
import Karte.SuperKarte;
import SammlungP.Deck;
import java.util.Random;
import SammlungP.Sammlung;
import Logik.Zaehler;
import java.util.Stack;

public class Spieler {
	//Robin Widmer
	//send alli spielbare charte uf de hand
	public ArrayList<SuperKarte> handliste = new ArrayList<SuperKarte>();
	public Stack<SuperKarte> deckliste = new Stack<SuperKarte>();
	public Stack<SuperKarte> abwerfliste = new Stack<SuperKarte>();
	public int spielerNummer;
	private SuperKarte superkarte;
	private SiegNiederlage_Main bedingung;

//	private final int LETZTERUNDE = 10; // Edu --> Zug = 10 --> Spiel endet.

//	//Eduart Bunjaku
	final int LETZTERUNDE = 4; // Edu --> Zug = 10 --> Spiel endet.
	private int aktuelleRunde = 1; // erster Zug, Spielbeginn TODO getter und setter schreiben
	private int gesamtpunkte=0;
	private SiegNiederlage_Controller sgc;
	private Pane sieg;
	//Spielfeld_Model spielfModel;
	private int spie2Punkte;
	private Stage primaryStage;
	


	//Robin Widmer
	public Spieler(int spielerNummer) {
		this.spielerNummer = spielerNummer;
		setupStartdeck();
		//setupStarthand();
	
	}
		

	//Robin Widmer
	public void setupStartdeck(){
		GeldKarte startGeld = new GeldKarte(1,"Kupfer",0, "copper.jpg");
		PunkteKarte startPunkte = new PunkteKarte(1,"Anwesen", 1, "estate.jpg");
		
			for ( int i=0; i<7; i++){
				deckliste.push(startGeld);
			}
			for ( int i=0; i<3; i++){
				deckliste.push(startPunkte);
	}
			Schuffel(deckliste);
	}
	//Robin Widmer
	//legt abwerfliste auf deckliste wenn deck leer ist
	public void deckIstLeer(){
			deckliste.addAll(abwerfliste);
			abwerfliste.clear();
			Collections.shuffle(deckliste);
	}
	
	//Robin Widmer
	// zieht en zuefaelligi charte vom deck, machts Schuffel methode nutzlos, ueberprueft obs deck leer isch und duet demmentsprechend de abwerfstapel ufs deck lege
	public void KarteZiehen(int anzahlKarten){
		
		for (int i=0; i<anzahlKarten; i++){
			handliste.add(deckliste.pop());
		}
	}
	// starthand erstelle --> Auskommentiert da unkonventionell geloest..
	//public void setupStarthand() {
		//KarteZiehen(5);
	//}
	//Robin Widmer
	// deck mischle aber im moment useless
		public void Schuffel(Stack<SuperKarte> toSchuffel){
			Collections.shuffle(toSchuffel);
		}
		//Robin Widmer
//charte �berpruefe  -- ich checke ned wasi mit dere Methode sell mache
public Spielfeldkarte getSpielfeldkarte(SuperKarte K){
for(Spielfeldkarte sk: Sammlung.feldkarten){
	if(sk.art.equals(K)){
		return sk;}
	
}
return null;
}

//Robin Widmer
//Aktionkarte spielen
// TODO richtiger spieler
public void aktionsKarteSpielen(int indexH) {
	//handliste.get(indexH).karteSpielen(1); -- karteSpielen (ist die Funktion der Aktionskarte nehme ich an?) würde ich se
	//separat auf dem S_Controller aufrufen...
	Zaehler.aktionsZaehler--;
	abwerfliste.push(handliste.get(indexH));
	handliste.remove(indexH);
}

//Robin Widmer -- nichts mehr machen.. funktioniert jetzt
public void geldKarteSpielen(int indexH){
		Zaehler.addGuthaben(handliste.get(indexH).getWert());
		abwerfliste.push(handliste.get(indexH));
		handliste.remove(indexH);
}
//Robin Widmer

//charte chaufe
public void kartenKaufen(SuperKarte K){
	if(K.getKosten() <= Zaehler.getGuthaben()&&Zaehler.getKaufZaehler()>0){
		abwerfliste.add(K);
		int guthabenNachher = Zaehler.guthaben - K.getKosten();
		Zaehler.guthaben = guthabenNachher;
		Zaehler.kaufZaehler --;
		}	
	}


//Robin Widmer
	//Methode um gekaufte karte hinzuzuf�gen -- diese Methode ist mit karten Kaufen zusammengefügt worden :)
//public void karteErhalten(SuperKarte K){
//	abwerfliste.add(K);
//	}


//Jan Mueller -- Robin Widmer
//Methode leert ganze Hand und fuegt diese dem Abwerstapel hinzu. Dieser wird anschliessend gemischt
	public void discard(){
		for(int i = 0; i<handliste.size(); i++){
			abwerfliste.push(handliste.get(i));
		}

		handliste.clear();	
	}
	
	public void deckDiscard(){
		if(!deckliste.isEmpty()){
			while(!deckliste.isEmpty()){
				abwerfliste.push(deckliste.pop());
			}
			deckliste.clear();
		}
	}
	
	
	//Edu Bunjaku
	public void setAktuelleRunde(int aktuelleRunde){
		this.aktuelleRunde = aktuelleRunde;
	}
	
	public int getAktuelleRunde(){
		return this.aktuelleRunde;

	}
	
	public int getLetzteRunde(){
		return this.LETZTERUNDE;
	}
	
	public int getGesamtpunkte(){
		return this.gesamtpunkte;
	}
	public void setGesamtpunkte(int gesamtpunkte){
		this.gesamtpunkte = gesamtpunkte;
	}
	
	
	 
	
// Eduart Bunjaku
/**
 * @param Beendet Spiel, wenn 10 Züge vorbei sind und ruft Methode punkteBerechnen() auf.
 * @throws InterruptedException 
 * @throws IOException 
 */
//	public void beendeSpiel(){
//		//--Spielfeld_Model.getZugGegner()
//		//if( aktuelleRunde == LETZTERUNDE && Spielfeld_Model.getZugGegner() == LETZTERUNDE +1){
//			int gegnerZug = Spielfeld_Model.getZugGegner() + 1;
//			System.out.println("++++++++++++++++++++++++++++++++++++++++++DAS IST RUNDE "+ gegnerZug);
//			
//			punkteBerechnen();
//			
//			try {
//				Kommunikation.sendenClient(Spielfeld_Model.getPlayername() + "-spieler-punkte-" + this.gesamtpunkte);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//			
//			
//			
//		//}
//		//Platform.exit();
//	}
//	
	
	
// Edu
/**
 * @param Summiert die Punktkarten aus der Hand, Deck und Abwerfstapel.	
 */
	public void punkteBerechnen(){
		int summeHand = 0;
		int summeDeck = 0;
		int summeAbwurf = 0;
		
		for( int i = 0; i < handliste.size(); i++ ){
			summeHand = summeHand + handliste.get(i).getPunkte();
		}
		for( int i = 0; i < deckliste.size(); i++){
			summeDeck = summeDeck + deckliste.get(i).getPunkte();
		}
		for( int i = 0; i < abwerfliste.size(); i++){
			summeAbwurf = summeAbwurf + abwerfliste.get(i).getPunkte();
		}
		
		setGesamtpunkte(summeHand + summeDeck + summeAbwurf);
		

		System.err.println("AKTUELLE PUNKTE: " + gesamtpunkte+" <----------------------------");
		// eventuel statt syso das Label von siegniederlage-Controller ausgeben
		
		
			
	}


/**
 * 
 * @param s1 
 * @param s2
 * Vergleicht zwei Spieler Objekte miteinander und gibt den Text Sieger/Verlierer Text aus.
 * 
 */
public String punkteVergleich(){

	System.err.println("Gesamtpunkte "+gesamtpunkte+"_______ Gegener Punkte "+Spielfeld_Model.getPunkte());
	
	
	if (getGesamtpunkte() > Spielfeld_Model.getPunkte()){
			System.err.println("GEWONNEN");
			System.out.println("GETPUNKTE METHODE: "+Spielfeld_Model.getPunkte());
			return "Gewonnen";		
	}
	
	if(getGesamtpunkte() < Spielfeld_Model.getPunkte()){
		System.err.println("VERLOREN");
		System.out.println("GETPUNKTE METHODE: "+Spielfeld_Model.getPunkte());
		return "Verloren";
	}
	
	if(getGesamtpunkte() == Spielfeld_Model.getPunkte()) {
		System.err.println("UNENTSCHIEDEN");
		System.out.println("GETPUNKTE METHODE: "+Spielfeld_Model.getPunkte());
		return "Unentschieden";
	}
	
	return null;
	
	
	
}


	//Ist jetzt im Controller Spielfeld
//public void compareTo() {
//	
//	if(this.getGesamtpunkte() > Spielfeld_Model.getPunkte()){
//		 sgc.getLabNachricht().setText("Sie haben gewonnen");
//	}if(this.getGesamtpunkte() < Spielfeld_Model.getPunkte()){
//		sgc.getLabNachricht().setText("Sie haben verloren");
//	}else{
//		sgc.getLabNachricht().setText("Unentschieden");
//	}
//	System.out.println(" **************** Punkte beider SPIELER " + this.gesamtpunkte + " vs " + Spielfeld_Model.getPunkte());
//	
//	try {
//		this.laden();
//	} catch (IOException e) {
//		e.printStackTrace();
//		System.out.println("Siegesfenster geht nicht auf");
//	}
//	
//	
//}


//public void laden() throws IOException{
//	
//	
//    
//}
	

}




	



