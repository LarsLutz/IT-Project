package Logik;

public class Zaehler {

	//wärt ufem spielfeld
	private int aktionsZaehler = 0;
	private int guthaben = 0;
	private int kaufZaehler = 0;
	private int phase;
	private int spielerAmZug;
	private int runde;
	
	public Zaehler(int aktionsZaehler, int guthaben, int kaufZaehler, int phase, int spielerAmZug, int runde) {
		super();
		this.aktionsZaehler = aktionsZaehler;
		this.guthaben = guthaben;
		this.kaufZaehler = kaufZaehler;
		this.phase = phase;
		this.spielerAmZug = spielerAmZug;
		this.runde = runde;
	}
	//Startwert am afang vo jedem zog
		public void beginnZug(){
			aktionsZaehler = 1;
			kaufZaehler = 1;
			guthaben = 1;
		}
		
		// Methode um d Charte effekt chönne azwände
		public void addKauf(int i){
			kaufZaehler+=i;
		}
		public void addAktion(int i){
			aktionsZaehler+=i;
		}
		public void addGuthaben(int i){
			guthaben+=i;
		}
	
	public int getAktionsZaehler() {
		return aktionsZaehler;
	}
	public void setAktionsZaehler(int aktionsZaehler) {
		this.aktionsZaehler = aktionsZaehler;
	}
	public int getGuthaben() {
		return guthaben;
	}
	public void setGuthaben(int guthaben) {
		this.guthaben = guthaben;
	}
	public int getKaufZaehler() {
		return kaufZaehler;
	}
	public void setKaufZaehler(int kaufZaehler) {
		this.kaufZaehler = kaufZaehler;
	}
	public int getPhase() {
		return phase;
	}
	public void setPhase(int phase) {
		this.phase = phase;
	}
	public int getSpielerAmZug() {
		return spielerAmZug;
	}
	public void setSpielerAmZug(int spielerAmZug) {
		this.spielerAmZug = spielerAmZug;
	}
	public int getRunde() {
		return runde;
	}
	public void setRunde(int runde) {
		this.runde = runde;
	}
	
}
