package chat;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.omg.CORBA.Initializer;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import kommunikation.Decoder;
import kommunikation.Kommunikation;
import kommunikation.Updater;
import lobby.Lobby_Model;

/**
 * @author Lars Lutz
 * Gui @author Eduart Bunjaku
 */
public class Chat_Controller  {
	
	private Chat_Model model;
	private Decoder dec;
	private Thread thread;
	private Boolean leuft =true;
	private Timer timer;
	private Updater updater;
	
	
	/**
	 * timer starte ein neues Timer Objekt welches jede Sekunde ausgeführt wird.
	 */
	
	public Chat_Controller(){
		dec= new Decoder();
		model= new Chat_Model();
		
		timer = new Timer();
		
		timer.scheduleAtFixedRate(new getNachricht(this, model), 0,1000);

		
	}
	
	
	
	/**
	 * Beim starten des Guis wird eine Nachricht gesendet damit die Kommunikation
	 * initialisiert wird.
	 * 
	 * Der Thread wird gestartet welcher die eingehenden Nachrichten verarbeitet.
	 */
	
@FXML

public void initialize(){
	
	String c2= "halter-chat-ini-$START";
	try {
		Kommunikation.sendenClient(c2);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	updater=new Updater(dec);
	this.thread=new Thread(updater);
	this.thread.start();
	
}



public void stopStage(){
	timer.cancel();
	timer.purge();
	updater.schliessen();

    System.err.println("Stage is closing");
    // Save file
}
	
	@FXML
	
	TextArea textArea1;




	@FXML
	TextField textArea2;
	
	
	
	
	@FXML
	Button bSenden;
	
/**
 * Sendet die Nachricht welche im Textfeld eingegeben wurde
 * @throws InterruptedException falls der Thread fehler aufweist
 */
	
	@FXML
	public void sendenKlick() throws InterruptedException{

		
		String c1;
		c1= Chat_Model.getSpielername()+"-chat-text-"+ textArea2.getText().replaceAll("-", "_");
		if (c1 != null && !c1.isEmpty()) { //Checkt ob überhaupt etwas gesendet werden kann
			try {
				Kommunikation.sendenClient(c1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			textArea2.clear();
			
			
			
		}
		
		
		
	}
	
	/**
	 * 
	 * @param keyevent Nihmt einen Tastendruck entgegen.
	 * @throws InterruptedException falls der Thread fehler aufweist
	 */
	
	
	@FXML
	public void sendenEnter(KeyEvent keyevent) throws InterruptedException{

		if (keyevent.getCode() == KeyCode.ENTER)  {

		String c1;
		c1= Chat_Model.getSpielername()+"-chat-text-"+ textArea2.getText().replaceAll("-", "_");
		if (c1 != null && !c1.isEmpty()) { //Checkt ob ï¿½berhaupt etwas gesendet werden kann
			try {
				Kommunikation.sendenClient(c1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			textArea2.clear();
			
			
		}
		
		}
		
		
	}
	

	
	@FXML
	public void exitApplication(ActionEvent event) {
	   Platform.exit();
	}

	
}
