package Karte;

import Logik.Spieler;
import Logik.Zaehler;

/**
* 
* @author Robin Widmer
*
*/

//Aktionskarte Kanzler: kostet 3, steigert Guthaben um 2 und legt das Deck auf den Abwerfstapel
public class AKChancellor extends AktionsKarte{

	final int kosten = 3;
	final String name = "Chancellor";
	final int guthaben = 2;
	private boolean deckDiscard;
	final String typ = "Aktionskarte";
	final String pfad = "chancellor.jpg";
	final String beschreibung = "Du erhaeltst +2 Guthaben\nDein Deck landet auf dem Abwerfstapel ";
	private Spieler s;
	
	public AKChancellor(boolean deckDiscard){
		this.deckDiscard = deckDiscard;
		s = new Spieler(0);
	}
	
	//Methode um den Effekt der Aktionskarte im Spiel auszuloesen, wird vom Spielfeld_Controller aufgerufen
	public void karteSpielen(){
		Zaehler.addGuthaben(this.guthaben);
	}
	
	
	public String getTyp() {
		return typ;
	}
	public boolean isDeckDiscard() {
		return deckDiscard;
	}
	public void setDeckDiscard(boolean deckDiscard) {
		this.deckDiscard = deckDiscard;
	}
	public int getKosten() {
		return kosten;
	}
	public String getName() {
		return name;
	}
	public int getGuthaben() {
		return guthaben;
	}
	
	public String getPfad(){
		return pfad;
	}
	
	public String getBeschreibung(){
		return beschreibung;
	}
	

}
