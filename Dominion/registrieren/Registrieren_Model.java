package registrieren;

import java.sql.SQLException;

import mysql.SQLHandler;

// Eduart Bunjaku

public class Registrieren_Model {

	
	private String ausgabe="";
	public Registrieren_Model(){
		
	}
	
	public String getsqlBefehl(){
		
		return "INSERT INTO `spieler` "
				+ "(`idSpieler`, `Spielername`, `Passwort`, `SessionID`, `Spielstand_idSpielstand`)"
				+ " VALUES (NULL, 'Hans', '123456', '0', '1') ";
	}
	
	
public String setSpieler(){
		
		SQLHandler.setBefehl(getsqlBefehl());
		
		
		
		SQLHandler.dbclose();
		
		return ausgabe;
	}
	
}
