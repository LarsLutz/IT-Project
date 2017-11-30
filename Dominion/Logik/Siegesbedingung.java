package Logik;



public class Siegesbedingung implements Comparable{
	
	private final int LETZTERZUG = 10;
	
	Spieler spieler1 = new Spieler(LETZTERZUG);
	Spieler spieler2 = new Spieler(LETZTERZUG);

	

	@Override
	public int compareTo(Object o) {
		return 0;
	}

}
