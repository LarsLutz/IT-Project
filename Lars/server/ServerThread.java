package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	
	
	private String line=null;
	private BufferedReader breader = null;
	private PrintWriter pwriter=null;
	private Socket sockel=null;
	private int client_id;
	private Kommunikation kom = new Kommunikation();
	//private Kommunikation kom2 = new Kommunikation();
	private String threadnr;
	
	public ServerThread (int id, Socket sck){
		sockel=sck;
		client_id=id;
		threadnr= this.getName();
	}
	
	public void run() {
	  try{
	      breader= new BufferedReader(new InputStreamReader(sockel.getInputStream()));
	      pwriter=new PrintWriter(sockel.getOutputStream());
	      
	
	  }catch(IOException e){
	      System.out.println("IO error in server thread");
	  }
	  try {
	      while(true){
	    	  
	    	 
	    	  kom.setText1(breader.readLine());
	    	  System.out.println(kom.getText1());
	    	  pwriter.println(kom.getText1());
	          pwriter.flush();
	    	  
	    	  System.out.println("Thread ID: " + this.threadnr);
	    	  
	    	  
	    	
	            
	          
	      }  
	    	  
	      
	  } catch (IOException e) {
	
	      line=this.getName(); //reused String line for getting thread name
	      System.out.println("IO Error/ Client "+line+" terminated abruptly");
	  }
	  catch(NullPointerException e){
	      line=this.getName(); //reused String line for getting thread name
	      System.out.println("Client "+line+" Closed");
	  }finally {
	  try{
	      System.out.println("Connection Closing..");
	      if (breader!=null){
	          breader.close(); 
	          System.out.println(" Socket Input Stream Closed");
	      }
	
	      if(pwriter!=null){
	          pwriter.close();
	          System.out.println("Socket Out Closed");
	      }
	      if (sockel!=null){
	      sockel.close();
	      System.out.println("Socket Closed");
	      }
	
	      }
	  catch(IOException ie){
	      System.out.println("Socket Close Error");
	  }
	  }//end finally
	
	  
}    
		  

}
