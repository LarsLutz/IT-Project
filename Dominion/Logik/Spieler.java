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
     * Instanziert eine ArrayList für die Karten in der Hand
     * Instanziert ein Stack für das Deck des Spielers
     * Instanziert ein Stack für den Abwerfstapel des Spielers
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
     * Konstruktor für das Spieler Objekt
     */
	
	public Spieler(int spielerNummer) {
		this.spielerNummer = spielerNummer;
		setupStartdeck();
	}
		

	
    /**
     * 
     * @author Robin Widmer
     * Erstellt die Kartenobjekte die jeder Spieler zu beginn des Spiels bekommt, direkt in das Deck des Spielers, 7 Kupfer und 3 Anwesen
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
     * Methode die alle Objekte aus der Abwerfliste in das Deck verschiebt und es mischelt
     */
	
	
	public void deckIstLeer(){
			deckliste.addAll(abwerfliste);
			abwerfliste.clear();
			Collections.shuffle(deckliste);
	}
	
	
    /**
     * @param Integer Wert wieviele Karten gezogen werden sollen
     * @author Robin Widmer
     * Methode die ein Integer Wert entgegen nimmt um die obersten Kartenobjekte vom Deck der Hand hinzuzufuegen
     */
	
	public void KarteZiehen(int anzahlKarten){
		
		for (int i=0; i<anzahlKarten; i++){
			handliste.add(deckliste.pop());
		}
	}
	
	
	/**
	 * @author Robin Widmer
	 * @param Stack
	 * Methode um ein Behaelter mit Karten Objekten zu mischeln
	 * 
	 */
	
	
	public void Schuffel(Stack<SuperKarte> toSchuffel){
			Collections.shuffle(toSchuffel);
		}
		
	/**
	 * @param SuperKarte Objekt übergeben um die richtige Karte auf dem Spielfeld zu erhalten
	 * @author Robin Widmer
	 * Methode um die richtige Spielfeldkarte zu erhalten
	 */
	
	public Spielfeldkarte getSpielfeldkarte(SuperKarte K){
			for(Spielfeldkarte sk: Sammlung.feldkarten){
				if(sk.art.equals(K)){
					return sk;}
	
			}
			return null;
	}

	/**
	 * @param Index der Aktionskarte auf der Hand die gespielt werden sollte
	 * @author  Robin Widmer
	 * Methode die mit dem Index der ArrayList "Handliste" die richtige Aktionskarte auswaehlt und diese von der Handliste auf die Abwerfliste legt, 
	 * ebenfalls werden die Aktionen um 1 verringert
	 */

	public void aktionsKarteSpielen(int indexH) {
		Zaehler.aktionsZaehler--;
		abwerfliste.push(handliste.get(indexH));
		handliste.remove(indexH);
	}


	/**
	 * @param Index der Geldkarte auf der Hand die gespielt werden sollte
	 * @author  Robin Widmer
	 * Methode die mit dem Index der ArrayList "Handliste" die richtige Geldkarte auswaehlt und diese von der Handliste auf die Abwerfliste legt,
	 */

	public void geldKarteSpielen(int indexH){
		Zaehler.addGuthaben(handliste.get(indexH).getWert());
		abwerfliste.push(handliste.get(indexH));
		handliste.remove(indexH);
}


	/**
	 * @param Kartenobjekt von der Karte die gekauft werden sollte
	 * @author  Robin Widmer
	 * Methode ueberprueft ob genug Guthaben vorhanden ist, legt die gekaufte Karte auf die Abwerfliste
	 * Kaeufe werden um 1 reduziert und die Kosten werden dem Guthaben abgezogen
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
     * Methode wirft alle Kartenobjekte aus der Handliste auf die Abwerfliste als Sicherheit wird die Handliste mit .clear geleert
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
     * Methode die ueberprueft ob die Deckliste nicht leer ist und wirft alle Kartenobjekte von der Deckliste auf die Abwerfliste als Sicherheit wird die Deckliste mit .clear geleert 
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




	



