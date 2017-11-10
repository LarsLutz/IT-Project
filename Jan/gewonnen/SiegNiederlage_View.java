package gewonnen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SiegNiederlage_View {
	
	public SiegNiederlage_View(Stage primaryStage){
	
	//Jan Müller
		
		try {
			//primaryStage.setResizable(false);
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("SiegNiederlageGUI.fxml"));
			Scene scene = new Scene(root,442,313);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("gewonnen oder verloren");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
