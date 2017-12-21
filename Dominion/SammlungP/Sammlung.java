package SammlungP;

import Karte.AktionsKarte;
import SammlungP.Spielfeldkarte;
import java.util.ArrayList;
import java.util.Collections;
import Karte.AKBazaar;
import Karte.AKChancellor;
import Karte.AKVillage;
import Karte.AKMarkt;
import Karte.AKSmithy;
import Karte.GeldKarte;
import Karte.PunkteKarte;
import Karte.SuperKarte;

/**
 * 
 * @author  Robin Widmer
 * Klasse die die Kartenobjekte von den vorhandenen Karten im Spiel enthält
 */


public class Sammlung {

	public static ArrayList<Spielfeldkarte> feldkarten;
	
	
	public ArrayList<Spielfeldkarte> getFeldkarten() {
		return feldkarten;
	}
	
		public static final GeldKarte[] geldKarten = {new GeldKarte(1,"Kupfer",0, "copper.jpg"), new GeldKarte(2,"Silber", 3, "silver.jpg"), new GeldKarte(3,"Gold",6, "gold.jpg")};
		public static final PunkteKarte[] punkteKarten = {new PunkteKarte(1,"Anwesen",2, "estate.jpg"), new PunkteKarte(3,"Provinz",5, "duchy.jpg"), new PunkteKarte(6,"Herzogtum",8, "province.jpg")};
		public static final AktionsKarte[] aktionsKarten = {new AKBazaar(), new AKChancellor(true), new AKVillage(), new AKMarkt(),new AKSmithy()};
		
		/**
		 * 
		 * @author  Robin Widmer
		 * Inizialisiert alle Kartenobjekte in die jeweiligen Behaelter
		 */
		
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
	