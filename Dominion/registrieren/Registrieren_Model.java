package registrieren;

import java.sql.SQLException;

import mysql.SQLHandler;

// Eduart Bunjaku

public class Registrieren_Model {

	
	private String ausgabe="";
	private Boolean vorhanden=false;
	private String befehl =null;
	public Registrieren_Model(){
		
	}
	
	
	public Boolean vorhanden(){
		
		return vorhanden;
	}
	public String getsqlBefehl(){
		
	if (!vorhanden()){
		
		befehl= "INSERT INTO `spieler` "
				+ "(`idSpieler`, `Spielername`, `Passwort`, `SessionID`, `Spielstand_idSpielstand`)"
				+ " VALUES (NULL, 'Hans', '123456', '0', '1') ";
		
	}
	
	
	return befehl;
	}
	
	
public String setSpieler(){
		
		SQLHandler.setBefehl(getsqlBefehl());
		
		
		
		SQLHandler.dbclose();
		
		return ausgabe;
	}
	
}
