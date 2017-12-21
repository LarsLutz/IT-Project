package Karte;
import Logik.Zaehler;
import Logik.Spieler;

/**
 * 
 * @author Robin Widmer
 *
 */

//Aktionskarte Markt: kostet 5, zieht 1 Karte, steigert die Aktionen um 1, steigert die Kaeufe um 1 und steigert Guthaben um 1
public class AKMarkt extends AktionsKarte{
	
	final int kosten = 5;
	final String name = "Markt";
	final int karteZiehen = 1;
	final int aktionsKarteSpielen = 1;
	final int karteKaufen = 1;
	final int guthaben = 1;
	final String typ = "Aktionskarte";
	final String pfad = "market.jpg";
	final String beschreibung = "Ziehe eine Karte\nDu erhaeltst +1 Aktion\nDu erhaeltst +1 Kaeufe\nDu erhaeltst +1 Guthaben";
	
	public AKMarkt(){
		
	}
	
	//Methode um den Effekt der Aktionskarte im Spiel auszuloesen, wird vom Spielfeld_Controller aufgerufen
	public void karteSpielen(){
		Zaehler.addAktion(this.aktionsKarteSpielen);
		Zaehler.addGuthaben(this.guthaben);
		Zaehler.addKauf(this.karteKaufen);
	}
	
	public String getTyp() {
		return typ;
	}
	
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
	
	public int getKarteKaufen() {
		return karteKaufen;
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
