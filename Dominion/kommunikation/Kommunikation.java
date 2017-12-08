package kommunikation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Kommunikation {
	
	private static  Socket sockel;
	private String linie;
	private static  BufferedReader input;
	private  static PrintWriter output;
	private final static  String schliessen="$CLOSE$";
	
	public Kommunikation() {
		
	}
	
	// Stellt Verbindung zum Server her

	synchronized public static void clientcon() throws IOException{

		InetAddress address=InetAddress.getLocalHost(); //Client Adresse auslesen

		System.out.println("Client buffer");

		try {
			sockel = new Socket(address,50663); //Sucht den Server Socket
			input = new BufferedReader(new InputStreamReader(sockel.getInputStream())); //Instansiert den Input Reader (Empfängt Daten)
			output = new PrintWriter(sockel.getOutputStream()); //Instansiert den Writter welcher die Daten versendet

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("IO Exception");
		}
		System.out.println("Client Addresse : "+address);

	}
// Methode für den Update Button (nur zum Test). Sendet die Daten
	synchronized public static  void sendenClient(String c) throws IOException{
		System.out.println("Senden...");
		String c1=c;
		output.println(c1); //Sendet den Text im Textfeld
		output.flush();	// Leert den Cache des Readers

	}

	
	//Methode für den Update Button (nur zum Test). Empfängt die Daten. Kommt schluessedlich in eine Endlosschleife
	synchronized public static String readClient() throws IOException{
		System.out.println("read");
		String textin = "";
		if (input.ready()){
			textin = input.readLine();
		}
		System.out.println("lesen "+textin);
		return textin;
	}
	
	
	
	
	
	
 


	
	// Schliesst die Verbindung
	public static void conclose() throws IOException{
		sendenClient(schliessen);
		input.close();
		output.close();
		sockel.close();
		System.out.println("Verbindung geschlossen");
	}

	

}
