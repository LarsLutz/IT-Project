package leaderboard;

import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.SQLHandler;

/**
 * 
 * @author Edu
 *
 */

public class Leaderboard_Model {

	//Instanzdaten
	private String ausgabe="";
	private ResultSet queri=null;

	//Konstruktor
	public Leaderboard_Model(){

	}

	/**Fragt den Namen und das Resultat des Spielers ab.
	 * 
	 * @return Gibt das Resultat zurück.
	 */
	public String getsqlBefehl(){

		return "SELECT `spieler`.`Spielername` AS `Name`, `leaderboard`.`Resultat` AS `Resultat` "
				+ "FROM `spieler` "
				+ "LEFT JOIN `leaderboard` "
				+ "ON `leaderboard`.`Spieler_idSpieler` = `spieler`.`idSpieler`"
				+ "WHERE `leaderboard`.`Resultat` is not null "
				+ "ORDER BY `leaderboard`.`Resultat` DESC "
				+ "LIMIT 10";
	}


	/**Diese Methode schickt den Befehl an den SQL-Handler und setzt den String für die Textarea.
	 * 
	 * @return Gibt Namen des Spielers und die Punkte zurück.
	 */
	public String getLeader(){

		SQLHandler.setBefehl(getsqlBefehl());

		try {
			queri = SQLHandler.doAbfrage();
			int i = 0;
			while (queri.next()) {
				i++;
				ausgabe = ausgabe + i +":\t\t\t\t"+ queri.getString(1)+"\t\t\t\t"+queri.getString(2)+"\n";
			}
		} catch (SQLException e) {
			ausgabe = null;
			System.out.println("SQL Fail");
			e.printStackTrace();
		}
		SQLHandler.dbclose();

		return ausgabe;
	}

}
