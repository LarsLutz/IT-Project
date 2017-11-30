package Logik;

public final class Zaehler {

	//w�rt ufem spielfeld
	public static int aktionsZaehler = 0;
	public static int guthaben = 0;
	public static int kaufZaehler = 0;
	public static int phase;
	public static int spielerAmZug;
	public static int runde = 0; // Edu --> Runde auf 0 gesetzt.
	
	private Zaehler(int aktionsZaehler, int guthaben, int kaufZaehler, int phase, int spielerAmZug, int runde) {
		super();
		this.aktionsZaehler = aktionsZaehler;
		this.guthaben = guthaben;
		this.kaufZaehler = kaufZaehler;
		this.phase = phase;
		this.spielerAmZug = spielerAmZug;
		this.runde = runde;
	}
	//Startwert am afang vo jedem zog
		public static void beginnZug(){
			aktionsZaehler = 1;
			kaufZaehler = 1;
			guthaben = 1;
		}
		
		// Methode um d Charte effekt ch�nne azw�nde
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
		aktionsZaehler = aktionsZaehler;
	}
	public static int getGuthaben() {
		return guthaben;
	}
	public static void setGuthaben(int guthaben) {
		guthaben = guthaben;
	}
	public static int getKaufZaehler() {
		return kaufZaehler;
	}
	public static void setKaufZaehler(int kaufZaehler) {
		kaufZaehler = kaufZaehler;
	}
	public static int getPhase() {
		return phase;
	}
	public static void setPhase(int phase) {
		phase = phase;
	}
	public static int getSpielerAmZug() {
		return spielerAmZug;
	}
	public static void setSpielerAmZug(int spielerAmZug) {
		spielerAmZug = spielerAmZug;
	}
	public static int getRunde() {
		return runde;
	}
	public static void setRunde(int runde) {
		runde = runde;
	}
	
}
