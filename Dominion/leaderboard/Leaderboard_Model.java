package leaderboard;

import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.SQLHandler;

public class Leaderboard_Model {
	
	
	private String ausgabe="";
	private ResultSet queri=null;
	
	public Leaderboard_Model(){
		
	}
	
	
	public String getsqlBefehl(){
	
		return "SELECT `spieler`.`Spielername` AS `Name`, `leaderboard`.`Resultat` AS `Resultat` "
				+ "FROM `spieler` "
				+ "LEFT JOIN `leaderboard` "
				+ "ON `leaderboard`.`Spieler_idSpieler` = `spieler`.`idSpieler`"
				+ "WHERE `leaderboard`.`Resultat` is not null "
				+ "ORDER BY `leaderboard`.`Resultat` DESC";
	}
	
	
	
	public String getLeader(){
		
		SQLHandler.setBefehl(getsqlBefehl());
		
		
		try {
			queri= SQLHandler.doAbfrage();
			int i=0;
			while (queri.next()) {
			i++;
			  ausgabe = ausgabe + i+":\t\t\t\t"+ queri.getString(1)+"\t\t\t\t"+queri.getString(2)+"\n";
     }
		} catch (SQLException e) {
			ausgabe=null;
			System.out.println("SQL Fail");
			e.printStackTrace();
		}
		SQLHandler.dbclose();
		
		return ausgabe;
	}

}
