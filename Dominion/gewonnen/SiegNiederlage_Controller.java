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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SiegNiederlage_Controller {
	//Jan Müller
	public SiegNiederlage_Controller(){
		
	}
	
    @FXML
    private Pane wurzel;
    
    public Pane getWurzel(){
    	return this.wurzel;
    }
	
	@FXML
	Button bOk;
	
	@FXML
	Label labNachricht;
	
	@FXML
	ImageView gameOver;
	
	public Label getLabNachricht(){
		return this.labNachricht;
	}
	public void setLabNachricht(Label labNachricht){
		this.labNachricht = labNachricht;
	}
	
	
	public void okKlick(MouseEvent e) throws IOException{
				// closes current window
				Stage currentStage = (Stage) bOk.getScene().getWindow();
			    currentStage.close();
			    
			    // opens new window 'LoginView.fxml'
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../lobby/LobbyGui.fxml"));
		        Parent root1 = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setScene(new Scene(root1));  
		        stage.show();
	}

	

}
