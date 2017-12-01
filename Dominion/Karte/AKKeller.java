package Karte;

import Logik.Zaehler;
import Logik.Spieler;
//Robin Widmer
public class AKKeller extends AktionsKarte{
	
	final int kosten = 2;
	final String name = "Keller";
	private int karteZiehen;
	final int aktionsKarteSpielen = 1;
	private int kartenAbwerfen;
	final String typ = "Aktionskarte";
	final String pfad = "cellar.jpg";
	final String beschreibung = "Du erhaeltst +1 Aktion\nWirf gewŁnschte Anzahl Karten ab\n+1 Karte ziehen pro abgeworfene Karte";
	
	public AKKeller(int karteZiehen, int kartenAbwerfen){
		this.karteZiehen = karteZiehen;
		this.kartenAbwerfen = kartenAbwerfen;
	}
	
	public void karteSpielen(Spieler spieler){
		spieler.deckIstLeer();
		spieler.KarteZiehen(karteZiehen);
		Zaehler.addKauf(karteKaufen);
		//TODO any card to discard and draw as much cards as discarded
	}
	
	
	public String getTyp() {
		return typ;
	}
	public int getKarteZiehen() {
		return karteZiehen;
	}
	public void setKarteZiehen(int karteZiehen) {
		this.karteZiehen = karteZiehen;
	}
	public int getKartenAbwerfen() {
		return kartenAbwerfen;
	}
	public void setKartenAbwerfen(int kartenAbwerfen) {
		this.kartenAbwerfen = kartenAbwerfen;
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
