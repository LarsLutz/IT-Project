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
	
	//send alli spielbare charte uf de hand
	public ArrayList<SuperKarte> handliste = new ArrayList<SuperKarte>();
	public Stack<SuperKarte> deckliste = new Stack<SuperKarte>();
	public Stack<SuperKarte> abwerfliste = new Stack<SuperKarte>();
	public int spielerNummer;

	public Spieler(int spielerNummer) {
		this.spielerNummer = spielerNummer;
		setupStartdeck();
		//setupStarthand();
	}
		

	
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
	// zieht en zuef�lligi charte vom deck, machts Sch�ffel methode nutzlos, �berprueft obs deck leer isch und duet demmentsprechend de abwerfstapel ufs deck lege
	public void KarteZiehen(int anzahlKarten){
		
		for (int i=0; i<anzahlKarten; i++){
			if(deckliste.isEmpty()){
				//deckliste.addAll(abwerfliste);
				for(int p = 0; p<abwerfliste.size(); p++){
					deckliste.push(abwerfliste.pop());
				}
				
				Collections.shuffle(deckliste);
			}
				
			handliste.add(deckliste.pop());
			
			
		
//		Random zufall = new Random();
//		int rand = zufall.nextInt(deckliste.size());
//		handliste.add(deckliste.get(rand));
//		deckliste.remove(rand);
	}
	}
	// starthand erstelle --> Auskommentiert da unkonventionell geloest..
	//public void setupStarthand() {
		//KarteZiehen(5);
	//}
	// deck mischle aber im moment useless
		public void Schuffel(Stack<SuperKarte> toSchuffel){
			Collections.shuffle(toSchuffel);
		}
//charte �berpruefe
public Spielfeldkarte getSpielfeldkarte(SuperKarte K){
for(Spielfeldkarte sk: Sammlung.feldkarten){
	if(sk.art.equals(K)){
		return sk;}
	
}
return null;
}
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
		Collections.shuffle(abwerfliste);
		handliste.clear();
	}

}




	



