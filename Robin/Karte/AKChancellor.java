package Karte;

public class AKChancellor extends AktionsKarte{

	final int kosten = 3;
	final String name = "Chancellor";
	final int guthaben = 2;
	private boolean deckDiscard;
	
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
	

	
		// guthaben +2
		// setKosten 3
		// deckDiscard ja/nein
}
