package spielfeld;

import java.io.IOException;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class getLabel extends TimerTask{

	private Spielfeld_Controller controller;
	private Spielfeld_Model model;
	private int i =0;
	private int c=0;

	public getLabel(Spielfeld_Controller c,Spielfeld_Model m) {
		// TODO Auto-generated constructor stub

		this.controller = c;
		this.model = m;

	}

	@Override
	public void run() {

		String temp = Spielfeld_Model.getUpdate();
		String player=Spielfeld_Model.getPlayername();
		String chat = Spielfeld_Model.getChat();
		String ende = Spielfeld_Model.getEnde();
		String finale = Spielfeld_Model.getGewinner();
		//System.out.println("Getlabel: "+chat);
		//System.err.println("Labeltime "+temp);
		
		if (!chat.isEmpty()){
			controller.tVerlauf.appendText(chat+"\n");
			Spielfeld_Model.setChat("");
			}
		
		if(ende.equals("$Ende") && player.equals("player1")){
			Platform.runLater(() -> {
				
				if (i==0){
					controller.setResultat();
					i=1;
				
				}
			});
			
	}
		
		if (!finale.isEmpty() && player.equals("player2")){
			Platform.runLater(() -> {
				
				if (c==0){
					try {
						controller.neuesFenster();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					c=1;
				}
			});
		}

		if (!temp.isEmpty()&& Spielfeld_Model.getIstneu()){
			if (temp.equals("$START")){
				System.out.println("Spiel startet");
				if (player.equals("player2")){
					
					
					
					
					//controller.grundbp.setDisable(true);
					controller.bP1.setDisable(true);
					controller.bP2.setDisable(true);
					controller.bP3.setDisable(true);
					controller.bZugBeenden.setDisable(true);
					controller.pMeinDeck.setDisable(true);
					
					
					
					
					Platform.runLater(() -> {
						controller.opLogger.setText("Gegner am Zug");
					});
				}
				Spielfeld_Model.setIstneu(false);
			}else{
				Platform.runLater(() -> {
					controller.opLogger.setText(temp);
					System.out.println("In Label geschrieben");
					//controller.tEingabe.appendText(temp+"\n");;
					
				});
				Spielfeld_Model.setIstneu(false);
			}
			
			
			if(Spielfeld_Model.getZug().equals("1")){
				controller.spielerEnabeln();
				Spielfeld_Model.setZug(0+"");
			}
			
			
			
			
		}

	}


}
