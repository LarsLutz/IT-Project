package spielfeld;

import java.io.IOException;
import java.util.TimerTask;

import javafx.application.Platform;

/**
 * Akktualisiert die Gui Elemente mittles eines Timerthreads
 * @author  Lars Lutz
 *
 */

public class getLabel extends TimerTask{

	private Spielfeld_Controller controller;
	private int i =0;
	private int c=0;

	public getLabel(Spielfeld_Controller c,Spielfeld_Model m) {

		this.controller = c;

	}

	/**
	 * Führt jegliche änderungen auf dem Gui durch.
	 * Bekommt die werte von Model welche durch die Server kommunikation laufend ändern
	 */
	@Override
	public void run() {

		String temp = Spielfeld_Model.getUpdate();
		String player=Spielfeld_Model.getPlayername();
		String chat = Spielfeld_Model.getChat();
		String ende = Spielfeld_Model.getEnde();
		String finale = Spielfeld_Model.getGewinner();

		//Fügt Daten in die Textarea
		if (!chat.isEmpty()){
			controller.tVerlauf.appendText(chat+"\n");
			Spielfeld_Model.setChat("");
		}
		// Deaktiviert Player 1 beim letzten Zug
		if (player.equals("player1")&& controller.rundenZaehler==21){
			Platform.runLater(() -> {

				controller.bP1.setDisable(true);
				controller.bP2.setDisable(true);
				controller.bP3.setDisable(true);
				controller.bZugBeenden.setDisable(true);
				controller.pMeinDeck.setDisable(true);

			});

		}
		// Setzt das Resultat beim letzten Zug damit das Game Over Fenster geöffnet wird.
		if(ende.equals("$Ende") && player.equals("player1")){
			Platform.runLater(() -> {

				if (i==0){
					controller.setResultat();
					i=1;

				}
			});

		}
		// Öffnet das Game Over Fenster bei Player 2
		if (!finale.isEmpty() && player.equals("player2")){
			Platform.runLater(() -> {

				if (c==0){
					try {
						controller.neuesFenster();
					} catch (IOException e) {
						e.printStackTrace();
					}
					c=1;
				}
			});
		}
		// Startet die Kommunikation. Setzt die label Nachrichten und sperrt die Gui wen der Zug vorbei ist
		if (!temp.isEmpty()&& Spielfeld_Model.getIstneu()){
			if (temp.equals("$START")){
				System.out.println("Spiel startet");
				if (player.equals("player2")){


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


				});
				Spielfeld_Model.setIstneu(false);
			}


			if(Spielfeld_Model.getZug().equals("1")){
				if (Spielfeld_Model.getPlayername().equals("player1")){
					Platform.runLater(() -> {
						int zaehler= controller.rundenZaehler;
						zaehler++;
						controller.rundenZaehler++;

						controller.lAktRunCount.setText(zaehler+""+" / 20");
					});
				}

				controller.spielerEnabeln();
				Spielfeld_Model.setZug(0+"");
			}




		}

	}


}
