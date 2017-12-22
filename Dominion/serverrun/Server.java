package serverrun;

import java.io.IOException;
import java.net.ServerSocket;

/** Startet den Thread welcher den Socket startet 
 * Bricht ab sobald beide Spieler das Spiel beenden
 * @author Lars Lutz
 */
public class Server implements Runnable {



	static boolean running = true;
	private String close="";

	public String getClose() {
		return close;
	}




	public void setClose(String close) {
		this.close = close;
	}





	@Override   
	public void run() {

		try {
			System.out.println("Sever startet");

			@SuppressWarnings("resource") // Gesetzt damit Warning verschwindet
			ServerSocket serverSocket = new ServerSocket(50663); // Generiert Serversocket
			Player player1 = new Player(serverSocket.accept(), 1); //Instansiert die Klasse Player
			Player player2 = new Player(serverSocket.accept(), 2);
			while (player1.isRunning()&player2.isRunning()){ //Soblad beide Verbunden sind
				//Daten zuerst verarbeiten bevor weitergeleitet wird

				if(player1.isDataInAvailable()){
					String data = player1.getDataIn();
					System.out.println("1 - 2");
					player2.setDataOut(data);
					System.out.println("echo");
					player1.setDataOut(data);
				}
				if(player2.isDataInAvailable()){
					String data = player2.getDataIn();
					System.out.println("2 - 1");
					player1.setDataOut(data);
					System.out.println("echo");
					player2.setDataOut(data);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}







}




