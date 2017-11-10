package lobby;

// Eduart Bunjaku
import javafx.application.Application;
import javafx.stage.Stage;
import login.Login_Controller;
import login.Login_Model;
import login.Login_View;

public class Lobby_Main extends Application {

	@Override
	public void start(Stage lobbyStage) throws Exception {
		Lobby_View v = new Lobby_View(lobbyStage);
		Lobby_Model m = new Lobby_Model();
		Lobby_Controller c = new Lobby_Controller();
		
		
	}
	
	
	public static void main (String []args){
		launch(args);
	}

}
