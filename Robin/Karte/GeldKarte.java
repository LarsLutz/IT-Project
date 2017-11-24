package Karte;

public class GeldKarte extends SuperKarte{
	private int wert;
	private String name;
	private int kosten;
	private String pfad;
	// groesse ??
	
	
	public GeldKarte(int wert, String name, int kosten, String pfad){
		this.wert = wert;
		this.name = name;
		this.kosten = kosten;
		this.pfad = pfad;
	}
	
	public void setWert(int i){
	this.wert = i;	
	}
	
}
