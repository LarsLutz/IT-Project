package gewonnen;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SiegNiederlage_Controller {
	//Jan Müller
	public SiegNiederlage_Controller(){
		
	}
	
	@FXML
	Button bOk;
	
	@FXML
	Label labNachricht;
	
	@FXML
	ImageView gameOver;
	
	
	public void okKlick(MouseEvent e) throws IOException{
				// closes current window
				Stage currentStage = (Stage) bOk.getScene().getWindow();
			    currentStage.close();
			    
			    // opens new window 'LoginView.fxml'
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../chat/ChatGUI.fxml"));
		        Parent root1 = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setScene(new Scene(root1));  
		        stage.show();
	}
	

}
