package Logik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import SammlungP.Spielfeldkarte;
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
//Geldcharte spiele
public void geldKarteSpielen(GeldKarte gk){
	Zaehler.addGuthaben(gk.getGuthaben());
}
//Robin Widmer

//charte chaufe
public SuperKarte kartenKaufen(SuperKarte K){
	Spielfeldkarte sk = getSpielfeldkarte(K);
	if(sk.anzahlVorhanden > 0){
		if(sk.art.getKosten() > Zaehler.getGuthaben()){
	}
			return null;
		}else
		Zaehler.setGuthaben(Zaehler.getGuthaben() - sk.art.getKosten());
		sk.anzahlVorhanden--;
		return K;
	}


//Robin Widmer
	//Methode um gekaufte karte hinzuzuf�gen
public void karteErhalten(SuperKarte K){
	abwerfliste.add(K);
	}


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
// Nach Spielende werden Punkte berechnet und Sieger/Verlierer bekannt gegeben
//	public void beendeSpiel(){
//	if(Spieler1.spielerNummer.getRunde() == LETZTERUNDE && Spieler2.spielerNummer.getRunde() == LETZTERUNDE){
//		this.punkteBerechnen();
//
//	
//	}
//		
//	}
	
	
	
// Edu
// Summiert die Punktkarten aus der Hand, Deck und Abwerfstapel	
	public void punkteBerechnen(){
		int summe = 0;
//		SuperKarte [] handListe = new SuperKarte[handliste.size()];
//		SuperKarte [] deckListe = new SuperKarte[handliste.size()];
//		SuperKarte [] abwerfListe = new SuperKarte[handliste.size()];
//		
//		handliste.toArray(handListe);
		
		int[] punkte = new int[handliste.size() + deckliste.size() + abwerfliste.size()];
		
	//	int p = handliste.getClass().getResourceAsStream(superkarte.getPunkte());
	//	int p = handliste.get(0).getPunkte();
		
	}
	

}




	



