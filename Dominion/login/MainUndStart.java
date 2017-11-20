package login;
	
import java.net.URL;

// Eduart Bunjaku - Jan Müller
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//Eduart Bunjaku - Jan Müller

public class MainUndStart extends Application {
	
	//private Login_View v;
	//private Login_Model m;
	//private Login_Controller c;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setResizable(false);
		//v = new Login_View(primaryStage);
		//m = new Login_Model();
		//c = new Login_Controller();

		try {
			
			URL fxmlUrl = getClass().getResource("LoginGUI.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl); 
			//fxmlLoader.setController(sn_c); - dieser Code teil wirft eine komische Exception.. habe ausserdem nicht verstanden was der Code macht...
			Parent root = fxmlLoader.load(); 
			Scene scene = new Scene(root); 
			primaryStage.setScene(scene);
			primaryStage.show();
			//SQLInjection sqln = new SQLInjection(); - evt später für larsiboy?
			//sqln.connectDatabase();
			
			//Loading LobbyView into Class
			//FXMLLoader.load(getClass().getResource("LobbyView.fxml"));
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
