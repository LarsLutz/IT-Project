package server;

import java.io.IOException;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ServerController {
	
	private ServerModelneu model;
	private ServerView view;
	
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
		
		model.serverstart();
		
		text.appendText(model.getText());
		
	
}
	
@FXML

public void endsrv(ActionEvent event){
	
	model.sclose();
		
				
	
}

}
