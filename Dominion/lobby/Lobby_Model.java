package lobby;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Lobby_Model {

	/**
	 * 
	 * @author Jan Mueller
	 * 
	 *handelt das Chat nicht geoeffnet werden kann wenn er bereits offen ist
	 */

	private boolean chatIstOffen = false;
	private double hoheSpielfeld;



	public Lobby_Model(){

	}

	public void setChatIstOffen(boolean chatIstOffen){
		this.chatIstOffen = chatIstOffen;
	}

	public boolean getChatIstOffen(){
		return this.chatIstOffen;
	}

	public double getHoheSpielfeld() {
		return hoheSpielfeld;
	}

	public void setHoheSpielfeld(double hoheSpielfeld) {
		this.hoheSpielfeld = hoheSpielfeld;
	}





}
