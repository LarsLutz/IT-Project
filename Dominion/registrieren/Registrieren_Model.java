package registrieren;

import java.sql.SQLException;

import mysql.SQLHandler;

// Eduart Bunjaku

public class Registrieren_Model {

	
	private String ausgabe="";
	private Boolean vorhanden=false;
	private String befehl =null;
	private String name;
	private String passwort;
	
	public Boolean getVorhanden() {
		return vorhanden;
	}


	public void setVorhanden(Boolean vorhanden) {
		this.vorhanden = vorhanden;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPasswort() {
		return passwort;
	}


	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}


	
	public Registrieren_Model(){
		
	}
	
	
	public String getsqlBefehl(){
		
	if (!getVorhanden()){
		
		
		befehl= "INSERT INTO `spieler` "
				+ "(`idSpieler`, `Spielername`, `Passwort`, `SessionID`, `Spielstand_idSpielstand`)"
				+ " VALUES (NULL, '"+getName()+"', '"+getPasswort()+"', '0', '1') ";
		
	}
	
	
	return befehl;
	}
	
	
public String setSpieler(){
		
		SQLHandler.setBefehl(getsqlBefehl());
		
		SQLHandler.doManipulation();
		
		
		
		SQLHandler.dbclose();
		
		return ausgabe;
	}
	
}
