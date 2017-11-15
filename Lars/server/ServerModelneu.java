package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerModelneu extends Thread {
	
	private String line=null;
	private BufferedReader  breader = null;
	private PrintWriter pwriter=null;
	private Socket sockel=null;
	private String gettext= "Verbindungslog \n";
	//private Socket sockel1=null;
	private ServerSocket srvsocket=null;
	
	public ServerModelneu (){

	}
	
	
	public ServerModelneu (Socket s){
		this.sockel=s;
	}
	
	public void run() {
	  try{
	      breader= new BufferedReader(new InputStreamReader(sockel.getInputStream()));
	      pwriter=new PrintWriter(sockel.getOutputStream());
	
	  }catch(IOException e){
	      System.out.println("IO error in server thread");
	  }
	  try {
	      line=breader.readLine();
	      while(line.compareTo("QUIT")!=0){
	
	          pwriter.println(line);
	          pwriter.flush();
	          System.out.println("Response to Client  :  "+line);
	          line=breader.readLine();
	      }   
	  } catch (IOException e) {
	
	      line=this.getName(); //reused String line for getting thread name
	      System.out.println("IO Error/ Client "+line+" terminated abruptly");
	  }
	  catch(NullPointerException e){
	      line=this.getName(); //reused String line for getting thread name
	      System.out.println("Client "+line+" Closed");
	  }
	
	  finally{    
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
	
	
	public void  serverstart() {
		
	    System.out.println("Server Listening......");
	    this.gettext= gettext+"Server Listening......";
	    try{
	        srvsocket = new ServerSocket(8080); // can also use static final PORT_NUM , when defined
	
	    }
	    catch(IOException e){
	    e.printStackTrace();
	    System.out.println("Server error");
	    
	
	    }
	    
	    while(true){
	        try{
	            sockel= srvsocket.accept();
	            System.out.println("connection Established");
	            ServerModelneu st=new ServerModelneu(sockel);
	            st.start();
	
	        }
	
	    catch(Exception e){
	        e.printStackTrace();
	        System.out.println("Connection Error");
	
	    }
	    }

		
		
	} 
	
	public String getText(){
		
		return this.gettext;
	}

	
	
}

