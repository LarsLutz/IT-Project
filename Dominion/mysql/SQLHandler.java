package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public static ResultSet doAbfrage(){
		
		try {
		    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dominion?" +"user=root&password=");
		    System.out.println("Login erfolgreich");
		    

		    

		    try {
		        state = conn.createStatement();
		        query = state.executeQuery(getBefehl());


		        if (state.execute(getBefehl())) {
		           
		        	query = state.getResultSet();
		        
		        	
//		            while (query.next()) {
//		               System.out.println(query.getString(2)); //gets the first column's rows.
//		            }
		        }else{
		        	System.out.println("Keine Daten");
		        	query =null;
		        }

		        
		    }
		    catch (SQLException ex){
		        // Für Fehler
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
	
	
	public static void dbclose(){

	        if (query != null) {
	            try {
	                query.close();
	                System.out.println("query close");
	            } catch (SQLException sqlEx) { } // ignore

	            query = null;
	        }

	        if (state != null) {
	            try {
	    		    state.close();
	            } catch (SQLException sqlEx) { } // ignore

	            state = null;
	        }
	    }
	
		
	
}


