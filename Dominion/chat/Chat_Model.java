package chat;

public class Chat_Model {
	
	private static String text;
	private static String update ="";
	private static Boolean istneu;
	
	
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
	
	
	public static void verarbeiteChat(String c){
		
		Chat_Model.setIstneu(true);
		String daten=c;
		
		String[] parts = daten.split("-");
		
		String variable= parts[0];
		String wert = parts[1];
		
		System.err.println("verarbeite: "+ wert);
		
		switch (variable){
        case "text":   Chat_Model.setUpdate(wert);
        				
        break;
		}
		
		
		
		
	}
	
	


	

}
