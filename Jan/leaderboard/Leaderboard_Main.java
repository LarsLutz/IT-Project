package leaderboard;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//Jan Müller
public class Leaderboard_Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Leaderboard_Model lm = new Leaderboard_Model();
		Leaderboard_View lv = new Leaderboard_View(primaryStage);
		Leaderboard_Controller lc = new Leaderboard_Controller();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
