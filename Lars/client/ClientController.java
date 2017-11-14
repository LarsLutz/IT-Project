package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import server.ServerModel;
import server.ServerView;

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
	private TextField ipc;
	@FXML
	private TextField portc;
	@FXML
	private TextArea textc;
	@FXML
	private Rectangle qua1;
	@FXML
	private Rectangle qua2;
	@FXML
	private ColorPicker color1;
	@FXML
	private ColorPicker color2;



@FXML

public void startclient(ActionEvent event){
	
		model.clientcon();
		
	
}

}

