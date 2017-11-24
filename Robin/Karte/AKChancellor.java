package Karte;

public class AKChancellor extends AktionsKarte{

	final int kosten = 3;
	final String name = "Chancellor";
	final int guthaben = 2;
	private boolean deckDiscard;
	final String typ = "Aktionskarte";
	final String pfad = "chancellor.jpg";
	//TODO
	final String beschreibung = "asdf";
	
	public AKChancellor(boolean deckDiscard){
		this.deckDiscard = deckDiscard;
	}
	
	
	public String getTyp() {
		return typ;
	}
	public boolean isDeckDiscard() {
		return deckDiscard;
	}
	public void setDeckDiscard(boolean deckDiscard) {
		this.deckDiscard = deckDiscard;
	}
	public int getKosten() {
		return kosten;
	}
	public String getName() {
		return name;
	}
	public int getGuthaben() {
		return guthaben;
	}
	
	public String getPfad(){
		return pfad;
	}
	
	public String getBeschreibung(){
		return this.beschreibung;
	}
	

	
		// guthaben +2
		// setKosten 3
		// deckDiscard ja/nein
}
