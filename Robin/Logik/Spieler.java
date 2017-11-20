package Logik;

import java.util.ArrayList;
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

public class Spieler {
	
	//send alli spielbare charte uf de hand
	public ArrayList<SuperKarte> handliste;
	public ArrayList<SuperKarte> deckliste;
	public ArrayList<SuperKarte> abwerfliste;
	public final int spielerNummer;

	public Spieler(int spielerNummer) {
		this.spielerNummer = spielerNummer;
		handliste = new ArrayList<SuperKarte>();
		deckliste = new ArrayList<SuperKarte>();
		abwerfliste = new ArrayList<SuperKarte>();
		setupStarthand();
		//sött Startdeck erstelle
		GeldKarte startGeld = new GeldKarte(1,"Kupfer",0);
		PunkteKarte startPunkte = new PunkteKarte(1,"Anwesen",1);{
		
		for ( int i=0; i>5; i++){
			deckliste.add(startGeld);
		}
		for ( int i=0; i>3; i++){
			deckliste.add(startPunkte);
		}
		}}

	
	
	// zieht en zuefälligi charte vom deck, machts Schöffel methode nutzlos, überprueft obs deck leer isch und duet demmentsprechend de abwerfstapel ufs deck lege
	public void KarteZiehen(int anzahlKarten){
		for (int i=0; i>anzahlKarten; i++){
		if(deckliste.isEmpty()){
			deckliste.addAll(abwerfliste);
			abwerfliste.clear();
		}
		Random zufall = new Random();
		int rand = zufall.nextInt(deckliste.size());
		handliste.add(deckliste.get(rand));
		deckliste.remove(rand);
	}
	}
	// starthand erstelle
	public void setupStarthand() {
		KarteZiehen(5);
	}
//charte überpruefe
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
//		if(sk.art.getKosten() > Zaehler.this.getGuthaben()){
//	}
//			return null;
//		}else
//		Zaehler.this.getGuthaben(Zaehler.this.getGuthaben() - sk.art.getKosten());
//		sk.anzahlVorhanden--;
		return K;
	}else{return null;
	
	}
}
	//Methode um gekaufte karte hinzuzufügen


public void karteErhalten(SuperKarte K){
	abwerfliste.add(K);




//charte spelle
//public void aktionsKarteSpielen(AktionsKarte AK){
//addGuthaben(Karte.AktionsKarte.get)
	 //charte ufem spielfeld chaufe

}
}




	



