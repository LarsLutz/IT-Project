package Karte;
import Logik.Zaehler;
import Logik.Spieler;

/**
 * 
 * @author Robin Widmer
 *
 */


public class AKBazaar extends AktionsKarte{
	
	final int kosten = 5;
	final String name = "Bazaar";
	final int karteZiehen = 1;
	final int aktionsKarteSpielen = 2;
	final int guthaben = 1;
	final String pfad = "bazaar.jpg";
	final String beschreibung = "Ziehe eine Karte\nDu erhaeltst +2 Aktionen\nDu erhaeltst +1 Guthaben";
	
	//Konstruktor
	public AKBazaar(){
		
	}
	
	public void karteSpielen(){
		Zaehler.addAktion(this.aktionsKarteSpielen);
		Zaehler.addGuthaben(this.guthaben);
	}
	
	
	
	public String getTyp() {
		return typ;
	}
	final String typ = "Aktionskarte";
	
	public int getKosten() {
		return kosten;
	}
	public String getName() {
		return name;
	}
	public int getKarteZiehen() {
		return karteZiehen;
	}
	public int getAktionsKarteSpielen() {
		return aktionsKarteSpielen;
	}
	public int getGuthaben() {
		return guthaben;
	}
	
	public String getPfad(){
		return pfad;
	}
	
	public String getBeschreibung(){
		return this.beschreibung;
	}


}
