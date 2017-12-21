package Logik;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import SammlungP.Spielfeldkarte;
import gewonnen.SiegNiederlage_Controller;
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
import java.util.Random;
import SammlungP.Sammlung;
import Logik.Zaehler;
import java.util.Stack;

public class Spieler {
    /**
     * 
     * @author Robin Widmer
     *
     */
	public ArrayList<SuperKarte> handliste = new ArrayList<SuperKarte>();
	public Stack<SuperKarte> deckliste = new Stack<SuperKarte>();
	public Stack<SuperKarte> abwerfliste = new Stack<SuperKarte>();
	public int spielerNummer;
	private SuperKarte superkarte;
	final int LETZTERUNDE = 3;
	private int aktuelleRunde = 1;
	private int gesamtpunkte=0;
	


    /**
     * 
     * @author Robin Widmer
     *
     */
	public Spieler(int spielerNummer) {
		this.spielerNummer = spielerNummer;
		setupStartdeck();
	}
		

	
    /**
     * 
     * @author Robin Widmer
     *
     */
	
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
	
    /**
     * 
     * @author Robin Widmer
     *
     */
	
	
	//legt abwerfliste auf deckliste wenn deck leer ist
	public void deckIstLeer(){
			deckliste.addAll(abwerfliste);
			abwerfliste.clear();
			Collections.shuffle(deckliste);
	}
	
	
    /**
     * 
     * @author Robin Widmer
     *
     */
	
	public void KarteZiehen(int anzahlKarten){
		
		for (int i=0; i<anzahlKarten; i++){
			handliste.add(deckliste.pop());
		}
	}

		public void Schuffel(Stack<SuperKarte> toSchuffel){
			Collections.shuffle(toSchuffel);
		}
		
	    /**
	     * 
	     * @author Robin Widmer
	     *
	     */

		public Spielfeldkarte getSpielfeldkarte(SuperKarte K){
			for(Spielfeldkarte sk: Sammlung.feldkarten){
				if(sk.art.equals(K)){
					return sk;}
	
			}
			return null;
		}

	    /**
	     * 
	     * @author  Robin Widmer
	     *
	     */
		
public void aktionsKarteSpielen(int indexH) {
	//handliste.get(indexH).karteSpielen(1); -- karteSpielen (ist die Funktion der Aktionskarte nehme ich an?) würde ich se
	//separat auf dem S_Controller aufrufen...
	Zaehler.aktionsZaehler--;
	abwerfliste.push(handliste.get(indexH));
	handliste.remove(indexH);
}


/**
 * 
 * @author  Robin Widmer
 *
 */

	public void geldKarteSpielen(int indexH){
		Zaehler.addGuthaben(handliste.get(indexH).getWert());
		abwerfliste.push(handliste.get(indexH));
		handliste.remove(indexH);
}


/**
 * 
 * @author  Robin Widmer
 *
 */

	public void kartenKaufen(SuperKarte K){
		if(K.getKosten() <= Zaehler.getGuthaben()&&Zaehler.getKaufZaehler()>0){
			abwerfliste.add(K);
			int guthabenNachher = Zaehler.guthaben - K.getKosten();
			Zaehler.guthaben = guthabenNachher;
			Zaehler.kaufZaehler --;
		}	
	}



    /**
     * 
     * @author  Robin Widmer / Jan Mueller
     *
     */
	
	public void discard(){
		for(int i = 0; i<handliste.size(); i++){
			abwerfliste.push(handliste.get(i));
		}

		handliste.clear();	
	}
	
    /**
     * 
     * @author  Robin Widmer / Jan Mueller
     *
     */
	
	public void deckDiscard(){
		if(!deckliste.isEmpty()){
			while(!deckliste.isEmpty()){
				abwerfliste.push(deckliste.pop());
			}
			deckliste.clear();
		}
	}
	
	
    /**
     * 
     * @author  Robin Widmer
     *
     */
	
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
	

/**Diese Methode iteriert durch die verschiedenen Stapel (Deck, Abwurfstapel und Hand)
 * und summiert die Punkte der Punktekarten.
 * @author Eduart Bunjaku
 * 
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
		
		
		Spielfeld_Model.setGesamtpunkte(summeHand + summeDeck + summeAbwurf);
		
		setGesamtpunkte(summeHand + summeDeck + summeAbwurf);
		
		System.err.println("Gesamtpunkte: " +getGesamtpunkte());
		
		
			
	}


/**Diese Methode vergleicht die Punkte der beiden Spieler und legt den Sieger bzw.
 * den Verlierer fest.
 * @author Eduart Bunjaku
 * 
 */
public void punkteVergleich(){

	System.err.println("Gesamtpunkte "+getGesamtpunkte()+"_______ Gegener Punkte "+Spielfeld_Model.getPunkte());
	
	
	if (getGesamtpunkte() > Spielfeld_Model.getPunkte()){
			System.err.println("GEWONNEN");
			System.out.println("GETPUNKTE METHODE: "+Spielfeld_Model.getPunkte());
			Spielfeld_Model.setGewinner("GEWONNEN");		
	}
	
	if(getGesamtpunkte() < Spielfeld_Model.getPunkte()){
			System.err.println("VERLOREN");
			System.out.println("GETPUNKTE METHODE: "+Spielfeld_Model.getPunkte());
			Spielfeld_Model.setGewinner("VERLOREN");
	}
	
	if(getGesamtpunkte() == Spielfeld_Model.getPunkte()) {
			System.err.println("UNENTSCHIEDEN");
			System.out.println("GETPUNKTE METHODE: "+Spielfeld_Model.getPunkte());
			Spielfeld_Model.setGewinner("UNENTSCHIEDEN");
	}

}

}




	



