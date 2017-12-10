package spielfeld;

import java.util.TimerTask;

import chat.Chat_Controller;
import chat.Chat_Model;
import javafx.application.Platform;

public class getLabel extends TimerTask{
	
	private Spielfeld_Controller controller;
    private Spielfeld_Model model;

	public getLabel(Spielfeld_Controller c,Spielfeld_Model m) {
		// TODO Auto-generated constructor stub
		
		 this.controller = c;
	        this.model = m;

	}
	
	@Override
	public void run() {

		String temp = Spielfeld_Model.getUpdate();
		String player=Spielfeld_Model.getPlayername();
		System.out.println("Getlabel: "+player);
		System.err.println("Labeltime "+temp);
		
		if (!temp.isEmpty()&& Chat_Model.getIstneu()){
		if (temp.equals("$START")){
			System.out.println("Spiel startet");
			if (player.equals("player2")){
				controller.grundbp.setDisable(true);
			}
			Spielfeld_Model.setIstneu(false);
		}else{
			Platform.runLater(() -> {

		controller.opLogger.setText(temp);
			System.out.println("In Label geschrieben");
		//controller.tEingabe.appendText(temp+"\n");;
		Spielfeld_Model.setIstneu(false);
			 });
		}
		if(Spielfeld_Model.getZug().equals("1")){
			controller.spielerEnabeln();
		}
		}
		
	}


}
