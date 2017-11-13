package anleitung;

import java.io.IOException;

import application.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


//Jan Müller
public class Anleitung_Controller {	
	
	public Anleitung_Controller(){
		
	}
	
	
	
	@FXML
	TextArea AnleitungsText;
	
	@FXML
	Button zurueck;
	
	@FXML
	public void zurueckKlick(MouseEvent event){
		
		//try{
    		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("..//Chat//ChatGUI.fxml"));
    		//Parent root1 = (Parent) fxmlLoader.load();
    		//Stage stage = new Stage();
    		//stage.setTitle("Chat");
    		//stage.setScene(new Scene(root1));
    		//stage.show();
    		
  
    	//}catch (Exception e){
    	//	System.out.println("kein neues Fenster");
    	
		
		
        //try {
        //	zurueck.getScene().setRoot(FXMLLoader.load(getClass().getResource("../Chat/ChatGUI.fxml")));
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
	}
	
	
	
	
	

}
