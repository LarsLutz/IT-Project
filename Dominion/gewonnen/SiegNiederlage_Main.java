package gewonnen;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//Jan Müller
public class SiegNiederlage_Main extends Application {
	
	
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		SiegNiederlage_Model sn_m = new SiegNiederlage_Model();
		SiegNiederlage_View sn_v = new SiegNiederlage_View(primaryStage);
		SiegNiederlage_Controller sn_c = new SiegNiederlage_Controller();
try {
			
			URL fxmlUrl = getClass().getResource("SiegNiederlageGUI.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl); 
			//fxmlLoader.setController(sn_c);
			/* Utils Auskommentiert weil es einen NullPointerException wirft
			Utils.loadFxml(fxmlUrl);
			 */
			Parent root = fxmlLoader.load(); 
			Scene scene = new Scene(root); 
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//SQLInjection sqln = new SQLInjection();
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
