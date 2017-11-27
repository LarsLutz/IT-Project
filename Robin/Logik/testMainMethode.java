package Logik;

public class testMainMethode {

	public static void main(String[] args) {
		
		//dDeckliste müessti ja bim instanziere vom spieler automatisch ufgsetzt werde.. Sie blibt aber leer
		Spieler s = new Spieler(1);
		s.setupStartdeck();
		s.setupStarthand();
		System.out.println(s.deckliste.pop().getName());
		
		
	}

}
