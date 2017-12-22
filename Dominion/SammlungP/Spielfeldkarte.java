package SammlungP;

import Karte.SuperKarte;
import SammlungP.Spielfeldkarte;

public class Spielfeldkarte {

	public SuperKarte art;
	public int anzahlVorhanden;

	/**
	 * 
	 * @author  Robin Widmer
	 * Spielfeldkarten Objekt um die Karten auf dem Spielfeld zu instanzieren
	 */

	public Spielfeldkarte(SuperKarte art, int anzahlVorhanden) {
		this.art = art;
		this.anzahlVorhanden = anzahlVorhanden;
	}


}