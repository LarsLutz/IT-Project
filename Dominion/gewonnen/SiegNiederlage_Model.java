package gewonnen;

import mysql.SQLHandler;
import spielfeld.Spielfeld_Model;

/**
 * 
 * @author Eduart Bunjaku
 *
 */

public class SiegNiederlage_Model {


	//instanzdaten
	private String befehl = null;
	private int gesamtpunkte = 0;


	//Konstruktor
	public SiegNiederlage_Model(){

	}

	/** Diese Methode definiert den SQL-Befehl für das Leaderboard.
	 * 
	 * @return Gibt das SQL-Query zurück.
	 */

	public String getsqlBefehl(){

		befehl = "INSERT INTO `leaderboard` (`idLeaderboard`, `Resultat`, `Spieler_idSpieler`) "
				+ "VALUES (NULL, '"+Spielfeld_Model.getGesamtpunkte()+"', '"+Spielfeld_Model.getSpielerid()+"')";

		return befehl;
	}

	/** Übergibt der Klasse SQL-Handler den Befehl.
	 * 
	 */

	public void setLeaderboard(){

		SQLHandler.setBefehl(getsqlBefehl());
		SQLHandler.doManipulation();	
		SQLHandler.dbclose();

	}

}
