package Karte;


/**
 * 
 * @author Robin Widmer
 *
 */





//Aktionskarte Schmied: kostet 4 Geld und zieht 3 Karten
public class AKSmithy extends AktionsKarte{

	final int kosten = 4;
	final String name = "Smithy";
	final int karteZiehen = 3;
	final String typ = "Aktionskarte";
	final String pfad = "smithy.jpg";
	final String beschreibung = "Ziehe 3 Karten";

	//Methode um den Effekt der Aktionskarte im Spiel auszuloesen wird vom Spielfeld_Controller aufgerufen
	public void karteSpielen(){
	}

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

	public String getBeschreibung(){
		return beschreibung;
	}

	public String getPfad(){
		return pfad;
	}

}
