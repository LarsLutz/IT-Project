package chat;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.omg.CORBA.Initializer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import kommunikation.Decoder;
import kommunikation.Kommunikation;
import kommunikation.Updater;
import lobby.Lobby_Model;

public class Chat_Controller  {
	
	private Chat_Model model;
	//private Kommunikation kom;
	private Decoder dec;
	private Thread thread;
	private Boolean leuft =true;
	
	//Jan Müller
	
	public Chat_Controller(){
		dec= new Decoder();
		model= new Chat_Model();
		//kom =new Kommunikation();
		//this.thread=new Thread(new Updater(dec));
		//this.thread.start();
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new getNachricht(this, model), 0,1000);
		
	}
	
	
	
//@FXML

//public void initialize(){
//	
//	textArea1.textProperty().addListener(new ChangeListener<String>() {
//	    @Override
//	    public void changed(ObservableValue<? extends String> observable,
//	            String oldValue, String newValue) {
//
//	        textArea1.appendText(Chat_Model.getUpdate()+"\n");
//	    }
//	});
//	
//}
	
	@FXML
	
	TextArea textArea1;




	@FXML
	TextArea textArea2;
	
	
	
	
	@FXML
	Button bSenden;
	
	//hehehehe
	@FXML
	public void sendenKlick() throws InterruptedException{

		
		String c1;
		c1="chat-text-"+ textArea2.getText();
		if (c1 != null && !c1.isEmpty()) { //Checkt ob �berhaupt etwas gesendet werden kann
			try {
				Kommunikation.sendenClient(c1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			textArea2.clear();
			
			if (leuft){
				
				this.thread=new Thread(new Updater(dec));
				this.thread.start();
				leuft =false;
				
			}
			
			
			
		}	
		
		
		
	}

	
	
	
	
	

	
}
