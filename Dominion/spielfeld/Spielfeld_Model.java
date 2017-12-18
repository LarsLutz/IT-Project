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
	private static Boolean istneu= false;
	private static String update ="";
	private static String spielername;
	private static String playername="johndoe";
	private static String zug="0";
	private static String punkte="0";
	private static String chat="";
	private static String zugGegner;
	private static String ende = "johndoe";
	private static String gewinner="";
	private static String spielerid="";
	private static int gesamtpunkte=0;
	




	public static String getEnde() {
		return ende;
	}

	public static void setEnde(String ende) {
		Spielfeld_Model.ende = ende;
	}

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
		
		Spielfeld_Model.setIstneu(true);
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
        case "init": Spielfeld_Model.setUpdate(wert);
        break;
        case "zug" : Spielfeld_Model.setZug(wert);
        break;
        case "punkte": Spielfeld_Model.setPunkte(wert);
        break;
        case "chat":	Spielfeld_Model.setChat(name+"    "+wert);
        break;
        case "runde": Spielfeld_Model.setZugGegner(wert);
        break;
        case "ende": Spielfeld_Model.setEnde(wert);
        break;
        case "finale": Spielfeld_Model.setGewinner(wert);
        break;
		}
		
		
		
		
	}




public static String getPlayername() {
	return playername;
}




public static void setPlayername(String playername) {
	Spielfeld_Model.playername = playername;
}

public static int getPunkte() {
	
	int punkt= Integer.parseInt(punkte);
	return punkt;
}

public static void setPunkte(String punkte) {
	Spielfeld_Model.punkte = punkte;
	System.err.println("Gegner Punkte "+ Spielfeld_Model.getPunkte());
}

public static String getChat() {
	return chat;
}

public static void setChat(String chat) {
	Spielfeld_Model.chat = chat;
}

public static int getZugGegner() {
	System.out.println("Gegner Zug: "+zugGegner);
	return Integer.parseInt(zugGegner);
}

public static void setZugGegner(String zugGegner) {
	Spielfeld_Model.zugGegner = zugGegner;
}

public static String getGewinner() {
	return gewinner;
}

public static void setGewinner(String gewinner) {
	Spielfeld_Model.gewinner = gewinner;
}

public static String getSpielerid() {
	return spielerid;
}

public static void setSpielerid(String spielerid) {
	Spielfeld_Model.spielerid = spielerid;
}

public static int getGesamtpunkte() {
	return gesamtpunkte;
}

public static void setGesamtpunkte(int gesamtpunkte) {
	Spielfeld_Model.gesamtpunkte = gesamtpunkte;
}




	
	
}
