package chat;

/**
 * @author Lars Lutz
 */
public class Chat_Model {

	private static String text;
	private static String update ="";
	private static Boolean istneu;
	private static String spielername;


	public static Boolean getIstneu() {
		return istneu;
	}


	public static void setIstneu(Boolean istneu) {
		Chat_Model.istneu = istneu;
	}


	public static String getUpdate() {
		return update;
	}


	public static void setUpdate(String update) {
		Chat_Model.update = update;
	}


	public String getText() {
		return text;
	}


	public static void setText(String t) {
		text = t;
	}


	public Chat_Model(){


	}

	/**
	 * 
	 * @param c Nimmt den Wert des Decoders entgegen und verarbeitet diesen weiter.
	 */
	public static void verarbeiteChat(String c){

		Chat_Model.setIstneu(true);
		String daten=c;

		String[] parts = daten.split("-");

		String variable= parts[0];
		String wert = parts[1];
		String name = parts[2];


		switch (variable){
		case "text":   Chat_Model.setUpdate(name+":     "+wert);
		break;
		case "ini":		Chat_Model.setUpdate(wert);
		}


	}


	public static String getSpielername() {
		return spielername;
	}


	public static void setSpielername(String spielername) {
		Chat_Model.spielername = spielername;
	}



}
