package Karte;

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
}
