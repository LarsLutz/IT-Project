package Karte;

/**
 * 
 * @author Robin Widmer
 *
 */

//Geldkarten die jeweils instanziert werden können
public class GeldKarte extends SuperKarte{
	private int wert;
	private String name;
	private int kosten;
	private String pfad;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKosten() {
		return kosten;
	}

	public void setKosten(int kosten) {
		this.kosten = kosten;
	}

	public String getPfad() {
		return pfad;
	}

	public void setPfad(String pfad) {
		this.pfad = pfad;
	}

	public int getWert() {
		return wert;
	}
	//Konstruktor
	public GeldKarte(int wert, String name, int kosten, String pfad){
		this.wert = wert;
		this.name = name;
		this.kosten = kosten;
		this.pfad = pfad;
	}

	public void setWert(int i){
		this.wert = i;	
	}


}
