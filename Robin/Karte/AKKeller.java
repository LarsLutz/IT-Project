package Karte;

public class AKKeller extends AktionsKarte{
	
	final int kosten = 2;
	final String name = "Keller";
	private int karteZiehen;
	final int aktionsKarteSpielen = 1;
	private int kartenAbwerfen;
	
	public int getKarteZiehen() {
		return karteZiehen;
	}
	public void setKarteZiehen(int karteZiehen) {
		this.karteZiehen = karteZiehen;
	}
	public int getKartenAbwerfen() {
		return kartenAbwerfen;
	}
	public void setKartenAbwerfen(int kartenAbwerfen) {
		this.kartenAbwerfen = kartenAbwerfen;
	}
	public int getKosten() {
		return kosten;
	}
	public String getName() {
		return name;
	}
	public int getAktionsKarteSpielen() {
		return aktionsKarteSpielen;
	}


	// aktionskarteSpielen ++
	// kartenAbwerfen ??
	// karteZiehen = anzahl Karte abgeworfen
	// setKosten 2
}
