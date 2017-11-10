package spielfeld;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Spielfeld_Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Spielfeld_Model sm = new Spielfeld_Model();
		Spielfeld_View sv = new Spielfeld_View(primaryStage);
		Spielfeld_Controller sc = new Spielfeld_Controller();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
