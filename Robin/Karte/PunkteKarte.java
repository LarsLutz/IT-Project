package Karte;

public class PunkteKarte extends SuperKarte{
	public int punkte;
	private String name;
	private int kosten;
	// groesse ??
	
	public PunkteKarte(int punkte, String name, int Kosten){
	this.punkte = punkte;
	this.name = name;
	this.kosten = kosten;
	}
	
	public void setPunkte(int i){
	this.punkte = i;

	}
}
