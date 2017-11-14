package leaderboard;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Leaderboard_View {
	
	
	//Jan Müller
	public Leaderboard_View(Stage primaryStage) {
		
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("LeaderboardGUI.fxml"));
			Scene scene = new Scene(root,615,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Leaderboard");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
