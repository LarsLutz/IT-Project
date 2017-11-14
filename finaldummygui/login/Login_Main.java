package login;
	
// Eduart Bunjaku
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Login_Main extends Application {
	
	private Login_View v;
	private Login_Model m;
	private Login_Controller c;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setResizable(false);
		
		v = new Login_View(primaryStage);
		m = new Login_Model();
		c = new Login_Controller();		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
