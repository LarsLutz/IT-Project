package server;

import java.io.IOException;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ServerController {
	
	private ServerModel model;
	private ServerView view;
	
	@FXML
	private Button start;
	
	@FXML
	private TextField ip;
	@FXML
	private TextField port;
	@FXML
	public TextArea text;
	
	
@FXML

public void startsrv(ActionEvent event){
		
	//try {	
		model.serverstart();
		
	//} catch (IOException e) {
		
		//e.printStackTrace();
		//text.appendText("Fehler");
	//}
}


public void setText(TextArea text) {
	this.text = text;
}



	

}
