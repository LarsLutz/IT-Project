package lobby;

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
