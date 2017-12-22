package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import mysql.SQLHandler;

/** Führt die SQL Querys für das Login aus
 * @author Lars Lutz
 */
public class Login_Model {

	private String ausgabe="";
	private ResultSet queri=null;
	private String name;
	private String passwort;
	private int id;
	private String sessionid;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSessionid() {
		Random rand =new Random();

		int zufall =rand.nextInt(999);

		sessionid= Integer.toString(zufall);


		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public Login_Model(){

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

	/**
	 * Führt das Select Statment aus
	 * @return  Gibt Abfrage zurück
	 */
	public String getsqlBefehlpull(){

		return "SELECT `spieler`.`idSpieler`, `spieler`.`Spielername`,"
				+ " `spieler`.`Passwort`, `spieler`.`SessionID`  "
				+ "FROM `spieler` "
				+ "WHERE (`spieler`.`Spielername`='"+ getName()+"')";
	}

	/**
	 * Führt den Updatebefehl aus
	 * @return gibt den Update Befehl zurück
	 */

	public String getsqlBefehlpush(){

		return "UPDATE `spieler` SET `SessionID` = '"+ getSessionid()+"' "
				+ "WHERE `spieler`.`idSpieler` = "+ getId()+" ";
	}

	public void setSessionID(){

		SQLHandler.setBefehl(getsqlBefehlpush());

		SQLHandler.doManipulation();



		SQLHandler.dbclose();

	}

	/**
	 *  Gibt die die abgefragten Login Daten zurück
	 * @return Gibt den ausgabe String zurück
	 */
	public String getLogin(){

		SQLHandler.setBefehl(getsqlBefehlpull());


		try {
			queri= SQLHandler.doAbfrage();
			while (queri.next()) {

				ausgabe = ausgabe + queri.getString(1)+"-"+queri.getString(2)+"-"+queri.getString(3)+"-"+queri.getString(4);
				setId(queri.getInt(1));
			}
			System.out.println("Abfrage erfolgt");

		} catch (SQLException e) {
			ausgabe=null;
			System.out.println("SQL Fail");
			e.printStackTrace();
		}
		SQLHandler.dbclose();
		if (ausgabe.isEmpty()){
			ausgabe = "leer$";
		}
		return ausgabe;
	}



}
