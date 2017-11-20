package Karte;

public class AKSmithy extends AktionsKarte{
	
	final int kosten = 4;
	final String name = "Smithy";
	final int karteZiehen = 3;
	final String typ = "Aktionskarte";
	
	public String getTyp() {
		return typ;
	}
	public int getKosten() {
		return kosten;
	}
	public String getName() {
		return name;
	}
	public int getKarteZiehen() {
		return karteZiehen;
	}
	

	// karteZiehen +3
	// setKosten 4
}
