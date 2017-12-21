package SammlungP;

import Karte.AktionsKarte;
import java.util.ArrayList;
import Karte.SuperKarte;
import Karte.AKBazaar;
import Karte.AKChancellor;
import Karte.AKVillage;
import Karte.AKMarkt;
import Karte.AKSmithy;
import Karte.GeldKarte;
import Karte.PunkteKarte;
import SammlungP.Spielfeldkarte;
import SammlungP.Sammlung;

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