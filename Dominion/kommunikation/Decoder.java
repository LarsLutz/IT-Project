package kommunikation;

import java.io.IOException;

import chat.Chat_Model;
import spielfeld.Spielfeld_Model;

public class Decoder {
	
	private  String eingang;
	//private Kommunikation kom;
	public Decoder(){
		//kom =new Kommunikation();
		
	}
	
	
	public  void lesen(){
		
		try {
			System.out.println("In Methode lesen");
			eingang= Kommunikation.readClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (eingang != null && !eingang.isEmpty()){ //Checkt ob etwas empfangen werden kann
		
		String[] parts = eingang.split("-");
		
		String kopf= parts[1];
		String variable =parts[2];
		String wert = parts[3];
		
		System.out.println(wert+"  "+kopf);
		
		switch (kopf){
        case "chat":   Chat_Model.verarbeiteChat(variable+"-"+wert);
        break;
        case "spiel": 
        break;
		}
		
		
		}
		
	}

}
