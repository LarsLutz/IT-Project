package servertest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.stage.Stage;

public class Server extends Application {
	
	private static ServerModelneu model;
	private ServerView view;
	private ServerController controller;
	private static ServerSocket srvsocket=null;
	private static Socket sockel=null;
	public static int wert;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		
		view = new ServerView(primaryStage);
		controller= new ServerController();
		model = new ServerModelneu() ;
		
		
		
		
		
	}
	
public static void  serverstart() {
		int i = getWert();
	if (i==1){
	    System.out.println("Server Listening......");
	    try{
	        srvsocket = new ServerSocket(8080); // can also use static final PORT_NUM , when defined
	
	    }
	    catch(IOException e){
	    e.printStackTrace();
	    System.out.println("Server error");
	    
	
	    }
	}
	    
	    while(i==1){
	        try{
	            sockel= srvsocket.accept();
	            System.out.println("connection Established");
	            ServerModelneu st=new ServerModelneu(sockel);
	            st.start();
	            System.out.println(i);
	
	        }
	
	    catch(Exception e){
	        e.printStackTrace();
	        System.out.println("Connection Error");
	
	    }
	    }
	    

	    

		
		
	} 

	
	
	    public static int getWert() {
	return wert;
}

public static void setWert(int wert) {
	Server.wert = wert;
	
	if (wert== 1){
		serverstart();
	}
	if (wert ==0){
		model.sclose();
	}
}

		public static void main(String[] args) {
			launch(args);
		}
			
		
}
