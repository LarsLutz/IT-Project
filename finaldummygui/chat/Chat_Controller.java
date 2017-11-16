package chat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class Chat_Controller {
	
	//Jan Müller
	
	public Chat_Controller(){
		
	}
	
	@FXML
	TextArea textArea1, textArea2;
	
	@FXML
	Button bSenden;
	
	//hehehehe
	@FXML
	public void sendenKlick(){
		textArea1.setText(textArea2.getText());
		textArea1.setDisable(true);
		
	}
	
}
