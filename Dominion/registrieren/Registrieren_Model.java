package registrieren;

import mysql.SQLHandler;

/**
 * @author Lars Lutz
 */

public class Registrieren_Model {



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

	/**
	 * Fügt den neuen User in die Datenbank ein. Unschön und Sicherheitsrisiko: Passwort wir momentan noch im Klartext gespeichert
	 * @return SQL Befehl für den Handler
	 */

	public String getsqlBefehl(){

		if (!getVorhanden()){


			befehl= "INSERT INTO `spieler` "
					+ "(`idSpieler`, `Spielername`, `Passwort`, `SessionID`, `Spielstand_idSpielstand`)"
					+ " VALUES (NULL, '"+getName()+"', '"+getPasswort()+"', '0', '1') ";

		}


		return befehl;
	}


	public void setSpieler(){

		SQLHandler.setBefehl(getsqlBefehl());

		SQLHandler.doManipulation();



		SQLHandler.dbclose();

	}

}
