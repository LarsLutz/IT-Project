package gewonnen;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//Jan Müller
public class SiegNiederlage_Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		SiegNiederlage_Model sn_m = new SiegNiederlage_Model();
		SiegNiederlage_View sn_v = new SiegNiederlage_View(primaryStage);
		SiegNiederlage_Controller sn_c = new SiegNiederlage_Controller();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
