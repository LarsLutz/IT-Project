package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.stage.Stage;
import servertest.ServerModelneu;

public class Server {
	
	
	
	

		
	


		public static void main(String[] args) {
			
			
			ServerSocket srvsockel=null;
			Socket sockel=null;
			int client_id=0;
			
			    System.out.println("Server Listening......");
			    try{
			        srvsockel = new ServerSocket(8080); // Port für die Kommunikaion
			
			    }
			    catch(IOException e){
			    e.printStackTrace();
			    System.out.println("Server error");
			    
			
			    }
			
			    
			    while(true){
			    	client_id++;
			        try{
			            sockel= srvsockel.accept();
			            System.out.println("connection Established at Client"+client_id);
			            ServerThread st=new ServerThread(client_id,sockel);
			            st.start();
			            
			
			        }
			
			    catch(Exception e){
			        e.printStackTrace();
			        System.out.println("Connection Error");
			
			    }
			    }
			
			
		}
			
		
}
