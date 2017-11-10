package lobby;

// Eduart Bunjaku
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Lobby_View {
	
	public Lobby_View(Stage lobbyStage){
		lobbyStage.setTitle("Lobby");
		lobbyStage.setResizable(false);
		

		try {
			AnchorPane root =  (AnchorPane) FXMLLoader.load(getClass().getResource("LobbyGUI.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			lobbyStage.setScene(scene);
			lobbyStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	
		
	}

}
