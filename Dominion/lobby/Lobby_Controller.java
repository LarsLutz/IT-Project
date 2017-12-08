package lobby;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import kommunikation.Decoder;
import kommunikation.Kommunikation;
import kommunikation.Updater;

// Eduart Bunjaku - Jan Mueller

public class Lobby_Controller {
	
	private Lobby_Model lm;
	private Updater update;
	//private Kommunikation kom;
	
	public Lobby_Controller(){
		lm = new Lobby_Model();
		//kom =new Kommunikation();
		
	}
	
	//Eduart Bunjaku
	@FXML
    private ImageView lobbyFoto;

    @FXML
    private Button chatButton;

    @FXML
    private Button spielLadenButton;

    @FXML
    private Button neuesSpielButton;

    @FXML
    private Button anleitungButton;

    @FXML
    private Button beendenButton;

    @FXML
    private Button leaderBoardButton;
    
    @FXML
	public void initialize(){
		try {
			Kommunikation.clientcon();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    

    
    
    //Jan Müller
    @FXML
    public void neuesSpiel(ActionEvent event) throws IOException {
    	// schliesst aktuelles Fenster
    	Stage currentStage = (Stage) neuesSpielButton.getScene().getWindow();
    	currentStage.close();
    		    
   	    //oeffnet neues fenster
   		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../spielfeld/SpielfeldGUI.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Dominion");
        stage.setScene(new Scene(root1));
        stage.show();
        stage.setResizable(false);
        stage.setFullScreen(true);
    }
   
    @FXML
    public void spielLaden(ActionEvent event) {
    	System.out.println("TODO... SpielLaden");
    }

    //Jan Mueller
    @FXML
    public void chatOeffnen(ActionEvent event) throws IOException {
    	// oeffnet neues fenster wenn noch keins offen ist
    		
    		if(lm.getChatIstOffen() == false){
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../chat/ChatGUI.fxml"));
	    		Parent root1 = (Parent) fxmlLoader.load();
	    		Stage stage = new Stage();
	    		stage.setTitle("Chat");
	    		stage.setScene(new Scene(root1)); 
	    		stage.show();
	    		stage.setResizable(false);
    		}
    		lm.setChatIstOffen(true);
    }

    //Jan Mueller
    @FXML
    public void leaderboardAnzeigen(ActionEvent event) throws IOException {
    	// schliesst aktuelles Fenster
    	Stage currentStage = (Stage) leaderBoardButton.getScene().getWindow();
    	currentStage.close();
    		    
    	// oeffnet neues fenster
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../leaderboard/LeaderboardGUI.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();
    	stage.setResizable(false);
    }


    //Jan Mueller
    @FXML
    public void anleitungAnzeigen(ActionEvent event)throws IOException {
    	// schliesst aktuelles Fenster
    	Stage currentStage = (Stage) anleitungButton.getScene().getWindow();
    	currentStage.close();
    		    
    	// oeffnet neues fenster
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../montageAnleitung/MontageAnleitungGUI.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();
    	stage.setResizable(false);
    }


    //Edu Bunjaku
    @FXML
    public void beenden(ActionEvent event) {
    	Stage currentStage = (Stage) leaderBoardButton.getScene().getWindow();
    	currentStage.close();
    	try {
			Kommunikation.conclose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Platform.exit();
    }



}
