package anleitung;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Anleitung_View {
	
//Jan Müller
	
	public Anleitung_View(Stage primaryStage) {
		
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("AnleitungGUI.fxml"));
			Scene scene = new Scene(root,615,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Anleitung");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
