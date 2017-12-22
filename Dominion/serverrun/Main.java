package serverrun;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	/** Main Methode um den Server zu starten
	 * @author Lars Lutz
	 */
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setResizable(false);
		
		
		try {
			
			URL fxmlUrl = getClass().getResource("ServerGui.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl); 
			Parent root = fxmlLoader.load(); 
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Server");
			primaryStage.setScene(scene);
			primaryStage.show();
			
					
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
