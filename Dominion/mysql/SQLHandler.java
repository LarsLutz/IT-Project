package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kommunikation.Kommunikation;
/**
 * F�hrt die ganze Kommunikation mit der Datenbank durch
 * @author Lars Lutz
 */
public class SQLHandler {
	private static Connection conn = null;
	private static Statement state = null;
	private static ResultSet query = null;
	private static String befehl=null;



	public SQLHandler (){

	}

	public static void setBefehl(String befehle){

		befehl =befehle;

	}


	public static String getBefehl() {
		return befehl;
	}

	/**
	 * F�hrt die einkommenden SQL Abfragen durch
	 * @return Gibt das ResultSet query zur�ck welech die SQL Abfage Daten enth�lt
	 */
	public static ResultSet doAbfrage(){

		try {
			String ipadress= Kommunikation.getIpadresse();
			System.out.println(ipadress);

			conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+ipadress+"/dominion?" +"user=admin&password=1234567");




			try {
				state = conn.createStatement();
				query = state.executeQuery(getBefehl());


				if (state.execute(getBefehl())) {

					query = state.getResultSet();


				}else{
					System.out.println("Keine Daten");
					query =null;
				}


			}
			catch (SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}


		} catch (SQLException ex) {

			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}


		return query;



	}
	/**
	 * F�hrt die Manipulationen (Update,Insert) Befehle durch
	 */

	public static  void doManipulation(){



		try {
			String ipadress= Kommunikation.getIpadresse();

			conn = (Connection) DriverManager.getConnection("jdbc:mysql://"+ipadress+"/dominion?" +"user=admin&password=1234567");
			System.out.println("Login erfolgreich");


			try {
				state = conn.createStatement();


				if (!state.execute(getBefehl())) {



				}else{
					System.out.println("Login Fail");

				}


			}
			catch (SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}


		} catch (SQLException ex) {

			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}






	}


	public static void dbclose(){

		if (query != null) {
			try {
				query.close();
				System.out.println("query close");
			} catch (SQLException sqlEx) { 
				
			}

			query = null;
		}

		if (state != null) {
			try {
				state.close();
			} catch (SQLException sqlEx) { 
				
			}

			state = null;
		}
	}



}


