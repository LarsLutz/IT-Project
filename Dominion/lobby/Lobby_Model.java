package lobby;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Lobby_Model {
	
	//Jan Müller 
	private boolean chatIstOffen = false;
	
	
	public Lobby_Model(){
		
	}
	
	public void setChatIstOffen(boolean chatIstOffen){
		this.chatIstOffen = chatIstOffen;
	}
	
	public boolean getChatIstOffen(){
		return this.chatIstOffen;
	}
	
	
	
	
	
}
