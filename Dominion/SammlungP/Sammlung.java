package SammlungP;

import Karte.AktionsKarte;
import SammlungP.Spielfeldkarte;
import java.util.ArrayList;
import java.util.Collections;
import Karte.AKBazaar;
import Karte.AKChancellor;
import Karte.AKKeller;
import Karte.AKMarkt;
import Karte.AKSmithy;
import Karte.GeldKarte;
import Karte.PunkteKarte;
import Karte.SuperKarte;

public class Sammlung {

	public static ArrayList<Spielfeldkarte> feldkarten;
	
	
	public ArrayList<Spielfeldkarte> getFeldkarten() {
		return feldkarten;
	}

		// Arrays mit dem Kartenobjekt
		public static final GeldKarte[] geldKarten = {new GeldKarte(1,"Kupfer",0, "copper.jpg"), new GeldKarte(2,"Silber", 3, "silver.jpg"), new GeldKarte(3,"Gold",6, "gold.jpg")};
		public static final PunkteKarte[] punkteKarten = {new PunkteKarte(1,"Anwesen",2, "estate.jpg"), new PunkteKarte(3,"Provinz",5, "province.jpg"), new PunkteKarte(6,"Herzogtum",8, "duchy.jpg")};
		public static final AktionsKarte[] aktionsKarten = {new AKBazaar(), new AKChancellor(true),new AKKeller(0,0),new AKMarkt(),new AKSmithy()};
		
		// Methode um alle karten auf dem spielfeld zu initalisieren
		public void kartenErstellen(){
			feldkarten = new ArrayList<Spielfeldkarte>(11);
			for(int i = 0; i<geldKarten.length; i++){
			feldkarten.add(new Spielfeldkarte(geldKarten[i], 20));}
			for(int i = 0; i<punkteKarten.length; i++){
			feldkarten.add(new Spielfeldkarte(punkteKarten[i], 20));}
			for(int i = 0; i<aktionsKarten.length; i++){
			feldkarten.add(new Spielfeldkarte(aktionsKarten[i], 10));}
			
		}
	
}
	