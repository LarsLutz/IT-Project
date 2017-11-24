package Karte;

public class PunkteKarte extends SuperKarte{
	private int punkte;
	private String name;
	private int kosten;
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
