package Logik;

import java.util.Stack;

import Karte.GeldKarte;
import Karte.PunkteKarte;
import Karte.SuperKarte;

public class testMainMethode {

	public static void main(String[] args) {
		
		//dDeckliste müessti ja bim instanziere vom spieler automatisch ufgsetzt werde.. Sie blibt aber leer
		Spieler s = new Spieler(1);
		System.out.println(s.deckliste);
		System.out.println(s.handliste);
		System.out.println(s.deckliste.peek().getPfad());
		
	}

}
