package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientModel {
	
	private Socket sockel;
	private String linie;
	private BufferedReader input;
	private PrintWriter output;
	private final String schliessen="$CLOSE$";
	
	public ClientModel(){
	}
	
	// Stellt Verbindung zum Server her

	public void clientcon() throws IOException{

		InetAddress address=InetAddress.getLocalHost(); //Client Adresse auslesen

		System.out.println("Client buffer");

		try {
			sockel = new Socket(address,8080); //Sucht den Server Socket
			input = new BufferedReader(new InputStreamReader(sockel.getInputStream())); //Instansiert den Input Reader (Empfängt Daten)
			output = new PrintWriter(sockel.getOutputStream()); //Instansiert den Writter welcher die Daten versendet

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("IO Exception");
		}
		System.out.println("Client Addresse : "+address);

	}
// Methode für den Update Button (nur zum Test). Sendet die Daten
	public void sendenClient(String c) throws IOException{
		System.out.println("Senden...");
		String antwort=null;
		String c1=c;
		output.println(c1); //Sendet den Text im Textfeld
		output.flush();	// Leert den Cache des Readers

	}

	
	//Methode für den Update Button (nur zum Test). Empfängt die Daten. Kommt schluessedlich in eine Endlosschleife
	public String readClient() throws IOException{
		System.out.println("lesen");
		String textin = "";
		if (input.ready()){
			textin = input.readLine();
		}
		System.out.println("lesen"+textin);
		return textin;
	}
 
//	String string = "004-034556";
//	String[] parts = string.split("-");

	
	// Schliesst die Verbindung
	public void conclose() throws IOException{
		sendenClient(schliessen);
		input.close();
		output.close();
		sockel.close();
		System.out.println("Verbindung geschlossen");
	}

	
}
