package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

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
	
	String c1;
	c1= textout.getText();
	if (c1 != null && !c1.isEmpty()) {
		model.sendenClient(c1);
	}
	
	
	c1 = model.readClient();
	if (c1 != null && !c1.isEmpty()){
		textin.appendText(c1+"\n");
	}
	textout.clear();
}

@FXML

public void closeclient(ActionEvent event) throws IOException{
	
	model.conclose();
	System.exit(0);
	

}

}

