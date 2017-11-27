package Karte;

public class AKSmithy extends AktionsKarte{
	
	final int kosten = 4;
	final String name = "Smithy";
	final int karteZiehen = 3;
	final String typ = "Aktionskarte";
	final String pfad = "smithy.jpg";
	//TODO
	final String beschreibung = "sdf";
	
	
	public AKSmithy(){
		
	}
	
	
	
	
	
	
	
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
	
	public String getPfad(){
		return pfad;
	}
	

	// karteZiehen +3
	// setKosten 4
}
