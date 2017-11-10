package spielfeld;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Spielfeld_View {
	
	//Jan Müller
	
	public Spielfeld_View(Stage primaryStage) {
		
		try {
			primaryStage.setResizable(false);
			Pane root = (Pane) FXMLLoader.load(getClass().getResource("SpielfeldGUI.fxml"));
			Scene scene = new Scene(root,900,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Spielfeld");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
