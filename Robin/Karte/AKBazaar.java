package Karte;

public class AKBazaar extends AktionsKarte{
	
	final int kosten = 5;
	final String name = "Bazaar";
	final int karteZiehen = 1;
	final int aktionsKarteSpielen = 2;
	final int guthaben = 1;
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

	// karteZiehen ++
	// aktionskarteSpielen +2
	// guthaben ++
	// setKosten 5???
}
