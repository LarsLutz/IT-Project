package chat;

import java.util.TimerTask;

import spielfeld.Spielfeld_Model;

/**
 * @author Lars Lutz
 * 
 * Ist ein Timerthread welcher das gui laufend anpasst sobald änderungen via Stream reinkommen.
 * Updatet die Textare
 */
public class getNachricht extends TimerTask{
	
	private Chat_Controller controller;
    

	public getNachricht(Chat_Controller c,Chat_Model m) {
		
		 this.controller = c;

	}
	
	@Override
	public void run() {
		String temp = Chat_Model.getUpdate();
		System.err.println("Time "+temp);
		
		if (!temp.isEmpty()&& Chat_Model.getIstneu()){
		if (temp.equals("$START")){
			System.out.println("Chat startet");
			Spielfeld_Model.setIstneu(false);
		}else{
		controller.textArea1.appendText(temp+ "\n");
		Chat_Model.setIstneu(false);
		}
		}
		
	}

}
