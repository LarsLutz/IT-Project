package server;

import java.io.IOException;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ServerController {
	
	private static ServerModelneu model;
	private ServerView view;
	private static int wert;
	
	public ServerController(){
		
		model = new ServerModelneu();
	}
	
	
	
	@FXML
	private Button start;
	
	@FXML
	private Button bclose;
	
	@FXML
	private TextField ip;
	@FXML
	private TextField port;
	@FXML
	public TextArea text;
	
	
@FXML

public void startsrv(ActionEvent event){
	
	  this.wert=1;
		
		Server.setWert(this.wert);
			
}
	
@FXML

public void endsrv(ActionEvent event){
	
	this.wert=0;
	
	Server.setWert(this.wert);
		
				
	
}

}
