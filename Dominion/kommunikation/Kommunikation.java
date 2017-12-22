package kommunikation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
/**
 * @author Lars Lutz
 * Enthält die Methoden welche für die Kommunikation gebraucht werden
 */
public class Kommunikation {

	private static  Socket sockel;
	private static  BufferedReader input;
	private  static PrintWriter output;
	private final static  String schliessen="$CLOSE$";
	private static String ipadresse="";

	public Kommunikation() {

	}



	public static String getIpadresse() {
		return ipadresse;
	}

	public static void setIpadresse(String ipadresse) {
		Kommunikation.ipadresse = ipadresse;
	}

	/**
	 * 
	 * @throws IOException wen Input oder Output Fehler beim Sockel
	 * 
	 * Verbindet sich mit dem Server auf Port 550663
	 */
	// Stellt Verbindung zum Server her
	synchronized public static void clientcon() throws IOException{

		InetAddress.getLocalHost();


		try {

			sockel = new Socket(Kommunikation.getIpadresse(),50663); //Sucht den Server Socket
			input = new BufferedReader(new InputStreamReader(sockel.getInputStream())); //Instansiert den Input Reader (Empfängt Daten)
			output = new PrintWriter(sockel.getOutputStream()); //Instansiert den Writter welcher die Daten versendet

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("IO Exception");
		}

	}

	/**
	 * 
	 * @param c Den zusendenden String an den Server
	 * @throws IOException  wen Input oder Output Fehler beim Sockel
	 */
	synchronized public static  void sendenClient(String c) throws IOException{
		String c1=c;
		output.println(c1); //Sendet den Text im Textfeld
		output.flush();	// Leert den Cache des Readers

	}


	/**
	 * 
	 * @return gibt den Empfangenen Wert vom Server zurück
	 * @throws IOException  wen Input oder Output Fehler beim Sockel
	 */
	synchronized public static String readClient() throws IOException{
		String textin = "";
		if (input.ready()){
			textin = input.readLine();
		}
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
