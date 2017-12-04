package Logik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import SammlungP.Spielfeldkarte;
import javafx.application.Platform;
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

//	private final int LETZTERUNDE = 10; // Edu --> Zug = 10 --> Spiel endet.

//	//Eduart Bunjaku
	final int LETZTERUNDE = 10; // Edu --> Zug = 10 --> Spiel endet.
	private int aktuelleRunde = 1; // erster Zug, Spielbeginn TODO getter und setter schreiben



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
			if(deckliste.size() == 0){
				deckIstLeer();
			}
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
//Aktionscharte spiele
// TODO neuindexierung der Hand ohne das Kartereihenfolge ge�ndert wird
public void aktionsKarteSpielen(AktionsKarte ak, int indexH) {
	if (Zaehler.aktionsZaehler > 0)
	abwerfliste.push(handliste.get(indexH));
	handliste.remove(indexH);
	handliste.add(handliste.get(handliste.size()));
	handliste.remove(handliste.size());
	ak.getAktionsKarteSpielen();
	Zaehler.aktionsZaehler--;
	
}

//Robin Widmer
//Geldcharte spiele
public void geldKarteSpielen(GeldKarte gk){
	Zaehler.addGuthaben(gk.getGuthaben());
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


//Jan Mueller
//Methode leert ganze Hand und fuegt diese dem Abwerstapel hinzu. Dieser wird anschliessend gemischt
	public void discard(){
		for(int i = 0; i<handliste.size(); i++){
			abwerfliste.push(handliste.get(i));

		}
		
		handliste.clear();

		
//		 Nach Abwurf soll Runde um 1 erhöht werden.
//				aktuelleRunde++;
//				Zaehler.setRunde(aktuelleRunde);
//				System.out.println("DAS IST DIE ------> " +Zaehler.getRunde()+" RUNDE");	

			
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
	 
	
// Eduart Bunjaku
/**
 * @param Beendet Spiel, wenn 10 Züge vorbei sind und ruft Methode punkteBerechnen() auf.
 */
	public void beendeSpiel(){
		if(aktuelleRunde == LETZTERUNDE){
			punkteBerechnen();
			Platform.exit();
	}
		
	}
	
	
	
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
		
		int gesamtsumme = summeHand + summeDeck + summeAbwurf;
		
		System.out.println("AKTUELLE PUNKTE: " + gesamtsumme );
	
	}
	

}




	



