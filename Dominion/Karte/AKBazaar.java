package Karte;
//Robin Widmer
public class AKBazaar extends AktionsKarte{
	
	final int kosten = 5;
	final String name = "Bazaar";
	final int karteZiehen = 1;
	final int aktionsKarteSpielen = 2;
	final int guthaben = 1;
	final String pfad = "bazaar.jpg";
	//TODO insert description of card here :) 
	final String beschreibung = "Ziehe eine Karte\nDu erhaeltst +2 Aktionen\nDu erhaeltst +1 Guthaben";
	
	//Konstruktor
	public AKBazaar(){
		
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

	// karteZiehen ++
	// aktionskarteSpielen +2
	// guthaben ++
	// setKosten 5???
}
