package lobby;

import java.io.IOException;

import chat.Chat_Controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kommunikation.Decoder;
import kommunikation.Kommunikation;
import kommunikation.Updater;
import sound.HintergrundSound;
import sound.MP3;
import spielfeld.Spielfeld_Controller;

/**
 * 
 * GUI @author Eduart Bunjaku
 * GUI @author Jan Mueller	
 *
 */

public class Lobby_Controller {
	
	private Lobby_Model lm;
	private Updater update;
	private HintergrundSound hs;
	//private Kommunikation kom;
	
	public Lobby_Controller(){
		lm = new Lobby_Model();
		hs = new HintergrundSound();
		//kom =new Kommunikation();
		
	}
	
	/**
	 * 
	 * @author Eduart Bunjaku
	 * @author Jan Mueller
	 *
	 */
	@FXML
    private ImageView lobbyFoto;

    @FXML
    private Button chatButton;

    @FXML
    private Button soundButton, soundAn;

    @FXML
    private Button neuesSpielButton;

    @FXML
    private Button anleitungButton;

    @FXML
    private Button beendenButton;

    @FXML
    private Button leaderBoardButton;
    
    
    /**
     * 
     * @author Lars Lutz
     *
     */
    
    @FXML
	public void initialize(){
    	hs.playHintergrundLoop();
		try {
			Kommunikation.clientcon();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    

    
    
    /**
     * 
     * Lambdas @author Lars Lutz
     * rest @author Eduart Bunjaku / Jan Mueller		
     *
     */
    @FXML
    public void neuesSpiel(ActionEvent event) throws IOException {
    	MP3.spieleMusik();
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
        stage.setOnCloseRequest(event1 -> {
            fxmlLoader.<Spielfeld_Controller>getController().stopStage();
            try {
    			Kommunikation.conclose();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        });
        stage.setOnHiding(event2 -> {
        	 fxmlLoader.<Spielfeld_Controller>getController().stopStage();
        	
        	
        });
        
    }
   
    /**
     * 
     * @author Eduart Bunjaku / Jan Mueller
     *
     */
    
    @FXML
    public void soundAbspielen(MouseEvent event) {
    	MP3.spieleMusik();
    	hs.playHintergrundLoop();
    	
    }
    
    /**
     * 
     * @author Eduart Bunjaku / Jan Mueller
     *
     */
    
    @FXML
    public void soundAus(){
    	MP3.spieleMusik();
    	hs.stopHintergrundLoop();
    }

    /**
     * 
     * @author Lars Lutz / Jan Mueller
     *
     */
    @FXML
    public void chatOeffnen(ActionEvent event) throws IOException {
    	MP3.spieleMusik();
    	// oeffnet neues fenster wenn noch keins offen ist
    		
    		if(lm.getChatIstOffen() == false){
	    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../chat/ChatGUI.fxml"));
	    		Parent root1 = (Parent) fxmlLoader.load();
	    		Stage stage = new Stage();
	    		stage.setTitle("Chat");
	    		stage.setScene(new Scene(root1)); 
	    		stage.show();
	    		stage.setResizable(false);
	    		
	    		stage.setOnCloseRequest(event1 -> {
                    fxmlLoader.<Chat_Controller>getController().stopStage();
                });
    		}
    		lm.setChatIstOffen(true);
    }

    /**
     * 
     * @author Eduart Bunjaku
     *
     */

    
    @FXML
    public void leaderboardAnzeigen(ActionEvent event) throws IOException {
    	MP3.spieleMusik();
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


    
    /**
     * 
     * @author Jan Mueller
     *
     */
    
    @FXML
    public void anleitungAnzeigen(ActionEvent event)throws IOException {
    	MP3.spieleMusik();
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


    /**
     * 
     * @author Eduart Bunjaku
     *
     */
    
    @FXML
    public void beenden(ActionEvent event) {
    	MP3.spieleMusik();
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
