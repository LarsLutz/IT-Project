package Karte;

/**
 * 
 * @author Robin Widmer
 *
 */



public class PunkteKarte extends SuperKarte{
	private int punkte;
	private String name;
	private int kosten;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKosten() {
		return kosten;
	}

	public void setKosten(int kosten) {
		this.kosten = kosten;
	}

	public String getPfad() {
		return pfad;
	}

	public void setPfad(String pfad) {
		this.pfad = pfad;
	}

	public int getPunkte() {
		return punkte;
	}

	private String pfad;
	// groesse ??
	
	public PunkteKarte(int punkte, String name, int kosten, String pfad){
	this.punkte = punkte;
	this.name = name;
	this.kosten = kosten;
	this.pfad = pfad;
	}
	
	public void setPunkte(int i){
	this.punkte = i;

	}
}
