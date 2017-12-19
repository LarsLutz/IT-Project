package kommunikation;

import java.io.IOException;

import chat.Chat_Model;
import spielfeld.Spielfeld_Model;

/**
 * @author Lars Lutz
 */
public class Decoder {
	
	private  String eingang;
	//private Kommunikation kom;
	public Decoder(){
		//kom =new Kommunikation();
		
	}
	
	
	synchronized public  void lesen(){
		
		try {
			System.out.println("In Methode lesen");
			eingang= Kommunikation.readClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (eingang != null && !eingang.isEmpty()){ //Checkt ob etwas empfangen werden kann
		
		String[] parts = eingang.split("-");
		
		String player =parts[0];
		String spieler= parts[1];
		String kopf= parts[2];
		String variable =parts[3];
		String wert = parts[4];
		
		if(spieler.equals(Spielfeld_Model.getPlayername())|| spieler.equals("johndoe")){
			if (spieler.equals("johndoe")){
			Spielfeld_Model.setPlayername(player);
			Spielfeld_Model.verarbeiteString(variable+"-"+wert+"-"+spieler+"-"+player);
			System.err.println("Decoder "+player);
		}else{
			
			System.err.println("Nicht für mich");
		}
		}else{
		
		System.out.println(wert+"  "+kopf);
		
		switch (kopf){
        case "chat":   Chat_Model.verarbeiteChat(variable+"-"+wert+"-"+spieler);
        break;
        case "spielf": Spielfeld_Model.verarbeiteString(variable+"-"+wert+"-"+spieler+"-"+player);
        break;
        case "spieler": Spielfeld_Model.verarbeiteString(variable+"-"+wert+"-"+spieler+"-"+player);
        break;
		}
		
		}
		}
		
	}

}
