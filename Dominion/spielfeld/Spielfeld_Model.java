package spielfeld;

import Logik.Spieler;

public class Spielfeld_Model{
	
	//Jan Mueller
	
	//bei wievielen Karten in der Hand wird das Deck disabelt? - zu beginn bei 5 da diese Anzahl Karten gezogen werden muss...
	private int wannDisabeln;
	private final int ANZAHL_START_HAND = 5;
	
	public Spielfeld_Model(int wannDisablen){
		this.wannDisabeln = wannDisablen;
	}
	
	public void setWannDisabeln(int wannDisabeln){
		this.wannDisabeln = wannDisabeln;
	}
	
	public int getWannDisabeln(){
		return this.wannDisabeln;
	}
	
	public int getAnzahlStarthand(){
		return this.ANZAHL_START_HAND;
	}
	
}
