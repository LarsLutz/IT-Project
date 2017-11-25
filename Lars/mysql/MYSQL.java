package mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MYSQL {
	
	private static Connection conn = null;
	private static Statement state = null;
    private static ResultSet query = null;
	
	
	
	public MYSQL (){
		
	}
	
	
	public static  void doStuff(){
		
		try {
		    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dominion?" +"user=root&password=");
		    System.out.println("Login erfolgreich");
		    
		    //jdbc:mysql://localhost/test?" +"user=minty&password=greatsqldb

		    

		    try {
		        state = conn.createStatement();
		        query = state.executeQuery("SELECT * FROM leaderboard");

		        // or alternatively, if you don't know ahead of time that
		        // the query will be a SELECT...

		        if (state.execute("SELECT * FROM leaderboard")) {
		            query = state.getResultSet();
		            while (query.next()) {
		                System.out.println(query.getString(2)); //gets the first column's rows.
		            }
		        }else{
		        	System.out.println("Keine Daten");
		        }

		        
		    }
		    catch (SQLException ex){
		        // handle any errors
		        System.out.println("SQLException: " + ex.getMessage());
		        System.out.println("SQLState: " + ex.getSQLState());
		        System.out.println("VendorError: " + ex.getErrorCode());
		    }
		    finally {
		        // it is a good idea to release
		        // resources in a finally{} block
		        // in reverse-order of their creation
		        // if they are no-longer needed

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

		  
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public static void main(String[] args){
		
		try {
	        
			
			//newInstance ladet einen neuen Abschnitt um fehler zu vermeiden

	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        System.out.println("Treiber laden erfolgreich");
	        
	        	doStuff();	
	        
	    } catch (Exception ex) {
	        System.out.println("Treiber laden  fehlgeschlagen");
	        ex.printStackTrace();
	    }
		
		
		
		
		}


	
	
	
}
