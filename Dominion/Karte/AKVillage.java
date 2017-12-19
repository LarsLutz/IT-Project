package Karte;

import Logik.Zaehler;
import Logik.Spieler;

/**
 * 
 * @author Robin Widmer
 *
 */


public class AKVillage extends AktionsKarte{
	
	final int kosten = 3;
	final String name = "Dorf";
	final int karteZiehen = 1;
	final int aktionsKarteSpielen = 2;
	final String typ = "Aktionskarte";
	final String pfad = "village.jpg";
	final String beschreibung = "Ziehe eine Karte\nDu erhaeltst +2 Aktionen";
	
	public AKVillage(){
		
	}
	
	public void karteSpielen(){
		Zaehler.addAktion(this.aktionsKarteSpielen);		
	}
	
	
	public String getTyp() {
		return typ;
	}

	public int getKarteZiehen() {
		return karteZiehen;
	}

	public int getKosten() {
		return kosten;
	}
	public String getName() {
		return name;
	}
	public int getAktionsKarteSpielen() {
		return aktionsKarteSpielen;
	}
	
	public String getPfad(){
		return pfad;
	}
	
	public String getBeschreibung(){
		return this.beschreibung;
	}


	// aktionskarteSpielen ++
	// kartenAbwerfen ??
	// karteZiehen = anzahl Karte abgeworfen
	// setKosten 2
}
