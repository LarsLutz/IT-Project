package spielfeld;

import Logik.Spieler;
import chat.Chat_Model;

public class Spielfeld_Model{
	
	//Jan Mueller
	
	//bei wievielen Karten in der Hand wird das Deck disabelt? - zu beginn bei 5 da diese Anzahl Karten gezogen werden muss...
	private int wannDisabeln;
	private final int ANZAHL_START_HAND = 5;
	private boolean aktionsPhase;
	private boolean kaufPhase;
	private boolean discardPhase;
	private static Boolean istneu;
	private static String update ="";
	private static String spielername;
	private static String playername="johndoe";
	private static String zug;
	
	




	public Spielfeld_Model(int wannDisablen){
		this.wannDisabeln = wannDisablen;
	}
	
	public static String getZug() {
		return zug;
	}




	public static void setZug(String zug) {
		Spielfeld_Model.zug = zug;
	}

	
	
	public static Boolean getIstneu() {
		return istneu;
	}


	public static void setIstneu(Boolean istneu) {
		Spielfeld_Model.istneu = istneu;
	}
	
	public static String getUpdate() {
		return update;
	}


	public static void setUpdate(String update) {
		Spielfeld_Model.update = update;
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
	
	public static String getSpielername() {
		return spielername;
	}


	public static void setSpielername(String spielername) {
		Spielfeld_Model.spielername = spielername;
	}
	
public static void verarbeiteString(String c){
		
		Chat_Model.setIstneu(true);
		String daten=c;
		
		String[] parts = daten.split("-");
		
		String variable= parts[0];
		String wert = parts[1];
		String name = parts[2];
		String head = parts[3];
		
		System.err.println("verarbeite Spielfeld: "+ wert);
		
		switch (variable){
        case "label":   Spielfeld_Model.setUpdate(wert);       				
        break;
        case "init": Spielfeld_Model.setPlayername(head);
        break;
        case "zug" : Spielfeld_Model.setZug(wert);
        break;
		}
		
		
		
		
	}




public static String getPlayername() {
	return playername;
}




public static void setPlayername(String playername) {
	Spielfeld_Model.playername = playername;
}
	
	
}
