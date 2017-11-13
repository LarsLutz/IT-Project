package lobby;

import javafx.application.Application;
import javafx.stage.Stage;

public class Lobby_Main extends Application {
	


	@Override
	public void start(Stage lobbyStage) throws Exception {
		Lobby_View v = new Lobby_View(lobbyStage);
		Lobby_Model m = new Lobby_Model();
		Lobby_Controller c = new Lobby_Controller();	
	}
	
	public static void main (String[] args){
		launch(args);
	}
	


}
