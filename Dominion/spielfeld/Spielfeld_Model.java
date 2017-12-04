package spielfeld;

import Logik.Spieler;

public class Spielfeld_Model{
	
	//Jan Mueller
	
	//bei wievielen Karten in der Hand wird das Deck disabelt? - zu beginn bei 5 da diese Anzahl Karten gezogen werden muss...
	private int wannDisabeln;
	private final int ANZAHL_START_HAND = 5;
	private boolean aktionsPhase;
	private boolean kaufPhase;
	private boolean discardPhase;
	
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
	
	public void setKaufPhase(boolean kaufPhase){
		this.kaufPhase = kaufPhase;
	}
	
	public boolean getKaufPhase(){
		return this.kaufPhase;
	}
	
	public void setDiscardPhase(boolean discardPhase){
		this.discardPhase = discardPhase;
	}
	
	public boolean getDiscardPhase(){
		return this.discardPhase;
	}
	
	public void setAktionsPhase(boolean aktionsPhase){
		this.aktionsPhase = aktionsPhase;
	}
	
	public boolean getAktionsPhase(){
		return this.aktionsPhase;
	}
	
	
}
