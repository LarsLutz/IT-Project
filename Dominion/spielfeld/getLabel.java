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
		//System.out.println("Getlabel: "+chat);
		//System.err.println("Labeltime "+temp);
		
		if (!chat.isEmpty()){
			controller.tVerlauf.appendText(chat+"\n");
			Spielfeld_Model.setChat("");
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
			
			
			if(ende.equals("$Ende") && player.equals("player1")){
					Platform.runLater(() -> {
						try {
							controller.neuesFenster();
							Spielfeld_Model.setEnde("john");
						} catch (IOException e) {
							e.printStackTrace();
							
						}
					});
					
			}
			
		}

	}


}
