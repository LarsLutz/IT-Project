package Karte;

public class AKKeller extends AktionsKarte{
	
	final int kosten = 2;
	final String name = "Keller";
	private int karteZiehen;
	final int aktionsKarteSpielen = 1;
	private int kartenAbwerfen;
	final String typ = "Aktionskarte";
	final String pfad = "cellar.jpg";
	//TODO
	final String beschreibung = "asdfd";
	
	public AKKeller(int karteZiehen, int kartenAbwerfen){
		this.karteZiehen = karteZiehen;
		this.kartenAbwerfen = kartenAbwerfen;
	}
	
	
	public String getTyp() {
		return typ;
	}
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
	
	public String getPfad(){
		return pfad;
	}
	
	public String getBeschreibung(){
		return this.beschreibung;
	}


	// aktionskarteSpielen ++
	// kartenAbwerfen ??
	// karteZiehen = anzahl Karte abgeworfen
	// setKosten 2
}
