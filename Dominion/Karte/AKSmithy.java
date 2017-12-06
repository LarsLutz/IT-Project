package Karte;
//Robin Widmer
import Logik.Zaehler;
import Logik.Spieler;

public class AKSmithy extends AktionsKarte{
	
	final int kosten = 4;
	final String name = "Smithy";
	final int karteZiehen = 3;
	final String typ = "Aktionskarte";
	final String pfad = "smithy.jpg";
	//TODO
	final String beschreibung = "Ziehe 3 Karten";
	
	public void karteSpielen(){
//		spieler.KarteZiehen(this.karteZiehen); -- brauchts nicht.. wird direkt auf Controller gemacht...
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
	

	// karteZiehen +3
	// setKosten 4
}
