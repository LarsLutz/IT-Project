package Logik;

public final class Zaehler {

    /**
     * 
     * @author  Robin Widmer
     * Statische Klasse die Zaehler enth�lt wieviele Kaeufe, AKtionen, Guthaben jeder Spieler zur verfuegung hat
     *
     */
	
	public static int aktionsZaehler = 0;
	public static int guthaben = 0;
	public static int kaufZaehler = 0;
	public static int phase;
	public static int spielerAmZug;
	public static int runde = 0;
	
	/**
     * 
     * @author  Robin Widmer
     * privater Konstruktor, da kein Zaehler Objekt instanziert werden muss
     *
     */
	
	private Zaehler(int aktionsZaehler, int guthaben, int kaufZaehler, int phase, int spielerAmZug, int runde) {
		Zaehler.aktionsZaehler = aktionsZaehler;
		Zaehler.guthaben = guthaben;
		Zaehler.kaufZaehler = kaufZaehler;
		Zaehler.phase = phase;
		Zaehler.spielerAmZug = spielerAmZug;
		Zaehler.runde = runde;
	}
	/**
     * 
     * @author  Robin Widmer
     * setzt am Anfang des Zuges die Werte wieder auf die Grundwerte
     *
     */
		public static void beginnZug(){
			aktionsZaehler = 1;
			kaufZaehler = 1;
			guthaben = 0;
		}
	/**
	  * 
	  * @author  Robin Widmer
	  * Methode um mit den Karten die Zaehler Variabeln einfacher anzupassen
	  *
	  */
		public static void addKauf(int i){
			kaufZaehler+=i;
		}
		public static void addAktion(int i){
			aktionsZaehler+=i;
		}
		public static void addGuthaben(int i){
			guthaben+=i;
		}
	
	public static int getAktionsZaehler() {
		return aktionsZaehler;
	}
	public static void setAktionsZaehler(int aktionsZaehler) {
		Zaehler.aktionsZaehler = aktionsZaehler;
	}
	public static int getGuthaben() {
		return guthaben;
	}
	public static void setGuthaben(int guthaben) {
		Zaehler.guthaben = guthaben;
	}
	public static int getKaufZaehler() {
		return kaufZaehler;
	}
	public static void setKaufZaehler(int kaufZaehler) {
		Zaehler.kaufZaehler = kaufZaehler;
	}
	public static int getPhase() {
		return phase;
	}
	public static void setPhase(int phase) {
		Zaehler.phase = phase;
	}
	public static int getSpielerAmZug() {
		return spielerAmZug;
	}
	public static void setSpielerAmZug(int spielerAmZug) {
		Zaehler.spielerAmZug = spielerAmZug;
	}
	public static int getRunde() {
		return runde;
	}
	public static void setRunde(int runde) {
		Zaehler.runde = runde;
	}
	
}
