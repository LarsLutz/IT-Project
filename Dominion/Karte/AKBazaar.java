package Karte;
import Logik.Zaehler;

/**
 * 
 * @author Robin Widmer
 *
 */

//Aktionskarte Bazaar: kostet 5, zieht 1 Karte, steigert Aktionen um 2 und steigert Guthaben um 1
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

	//Methode um den Effekt der Aktionskarte im Spiel auszuloesen, wird vom Spielfeld_Controller aufgerufen
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
