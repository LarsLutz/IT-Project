package montageAnleitung;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MontageAnleitung_View {
	
	public MontageAnleitung_View(Stage primaryStage) {
		
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("MontageAnleitungGUI.fxml"));
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
