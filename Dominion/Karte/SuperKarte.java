package Karte;
//Robin Widmer
public class SuperKarte {

	protected double groesse;
	protected int kosten;
	protected String name;
	protected int wert;
	protected int punkte;
	
	protected int karteZiehen;
	protected int aktionsKarteSpielen;
	protected int karteKaufen;
	protected int guthaben;
	protected String beschreibung;
	protected String pfad;
	

	protected boolean seite;
	
		
	public int getKosten() {
		return kosten;
	}
	public String getName() {
		return name;
	}
	public int getWert() {
		return wert;
	}
	public int getPunkte() {
		return punkte;
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
	public String getBeschreibung(){
		return beschreibung;
	}
	public String getPfad(){
		return pfad;
	}
	public void karteSpielen(int i) {
		
	}
}
