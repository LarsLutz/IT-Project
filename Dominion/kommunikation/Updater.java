package kommunikation;

import java.io.IOException;

import chat.Chat_Controller;
import chat.Chat_Model;

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
		//changelistener stringproperty



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


