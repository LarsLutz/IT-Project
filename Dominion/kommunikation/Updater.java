package kommunikation;

import java.io.IOException;

import chat.Chat_Controller;
import chat.Chat_Model;
/**
 * @author Lars Lutz
 * Startet Thread. Ruft den Decoder auf wen neue Nachricht läuft
 * Pausiert jede Sekunde um Leistung zu sparen
 */
public class Updater implements Runnable{


	private Decoder decoder;
	private String up;
	private volatile boolean running = true;




	public String getUp() {
		return up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public Updater(Decoder decoder){
		this.decoder = decoder;



	}

	public void schliessen(){
		running=false;
	}

	@Override
	public void run() {


		while(running){
			System.out.println("Decoder liesst");
			this.decoder.lesen(); 


			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				running =false;
			}
		}
	}




}


