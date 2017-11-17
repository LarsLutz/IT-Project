package servertest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerModel {
	
	private  static ServerSocket srvsocket;
	private static Socket sockel;
	private static int client_id = 0;
	private BufferedReader in;
	private PrintWriter out;
	private int id;
	private String gettext= "Verbindungslog \n";
	
	public ServerModel() {
		
	}
	
	
		
		
	
	
		public ServerModel(int id, Socket socket) throws IOException {
			this.sockel = socket;
			this.id = id;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			System.out.println("Servermodel");
		}

		public void start() {
			try {
				listen();
				System.out.println("Servermodel");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

		public void listen() throws IOException {

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
				System.out.println("listen");
			}
		}
		
		
public void  serverstart() {
			
			
			try {
				srvsocket = new ServerSocket(8080);
				System.out.println("Läuft \n");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			while (true) {
			try {
				sockel = srvsocket.accept();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			client_id++;
			System.out.println("Neuer Client mit ID: " + client_id);
			try {
				new ServerModel(client_id, sockel).start();
				System.out.println("Neuer Sockel");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} 
			
			
			

		}

		
public String getText(){
	
	return gettext;
	
	
}
		

		
		
		
	}
	



