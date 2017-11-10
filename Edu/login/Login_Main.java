package login;
	
// Eduart Bunjaku
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Login_Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setResizable(false);
		
		Login_View v = new Login_View(primaryStage);
		Login_Model m = new Login_Model();
		Login_Controller c = new Login_Controller();	
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
