package Karte;
import Logik.Zaehler;
import Logik.Spieler;
//Robin Widmer
public class AKMarkt extends AktionsKarte{
	
	final int kosten = 5;
	final String name = "Markt";
	final int karteZiehen = 1;
	final int aktionsKarteSpielen = 1;
	final int karteKaufen = 1;
	final int guthaben = 1;
	final String typ = "Aktionskarte";
	final String pfad = "market.jpg";
	final String beschreibung = "Ziehe eine Kart\nDu erhaeltst +1 Aktion\nDu erhaeltst +1 Kaeufe\nDu erhaeltst +1 Guthaben";
	
	
	
	public AKMarkt(){
		
	}
	
	public void karteSpielen(Spieler spieler){
		spieler.deckIstLeer();
		spieler.KarteZiehen(karteZiehen);
		Zaehler.addAktion(karteKaufen);
		Zaehler.addGuthaben(guthaben);
		Zaehler.addKauf(karteKaufen);
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
	
	


	// karteZiehen ++
	// aktionskarteSpielen ++
	// karteKaufen ++
	// guthaben ++
	// setKosten 5
	
}
