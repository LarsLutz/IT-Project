package SammlungP;

import Karte.AktionsKarte;
import java.util.ArrayList;
import Karte.SuperKarte;
import Karte.AKBazaar;
import Karte.AKChancellor;
import Karte.AKKeller;
import Karte.AKMarkt;
import Karte.AKSmithy;
import Karte.GeldKarte;
import Karte.PunkteKarte;
import SammlungP.Spielfeldkarte;
import SammlungP.Abwerfstapel;
import SammlungP.Sammlung;

public class Deck {

	//sött Starthand erstelle
	ArrayList<SuperKarte> deckliste = new ArrayList<SuperKarte>();
	GeldKarte testobjekt = new GeldKarte(1,"Kupfer",0);
	PunkteKarte testobjekt2 = new PunkteKarte(1,"Anwesen",1);{
	
	for ( int i=0; i>5; i++){
		deckliste.add(testobjekt);
	}
	for ( int i=0; i>3; i++){
		deckliste.add(testobjekt2);
	}	
	
	
}
}
