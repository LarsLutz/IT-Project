package lobby;

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
