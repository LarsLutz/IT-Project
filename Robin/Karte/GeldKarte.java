package Karte;

public class GeldKarte extends SuperKarte{
	private int wert;
	private String name;
	private int kosten;
	// groesse ??
	
	
	public GeldKarte(int wert, String name, int kosten){
		this.wert = wert;
		this.name = name;
		this.kosten = kosten;
	}
	
	public void setWert(int i){
	this.wert = i;	
	}
	
}
