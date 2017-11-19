package client;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ClientController {
	
	
	private ClientModel model;
	private ClientView view;
	
	public ClientController(){
		
		model = new ClientModel();
	
	}
	
	
	
	@FXML
	private Button connect;
	@FXML
	private Button update;
	@FXML
	private Button close;
	@FXML
	private TextField textout;
	@FXML
	private TextArea textc;
	@FXML
	private TextArea textin;



@FXML

public void startclient(ActionEvent event) throws IOException{
	
	
		model.clientcon();
		
	
}

@FXML

public void sendclient(ActionEvent event) throws IOException{
	
	String c1=null;	
	c1= textout.getText();
	model.sendenClient(c1);
	textin.appendText(model.readClient()+"\n");
	textout.clear();
		
	
}

@FXML

public void closeclient(ActionEvent event) throws IOException{
	
	model.conclose();
	System.exit(0);
	

}

}

