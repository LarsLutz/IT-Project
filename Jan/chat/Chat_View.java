package chat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Chat_View {
	
	//Jan Müller
	
	public Chat_View(Stage primaryStage) {
		
		try {
			primaryStage.setResizable(false);
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("ChatGUI.fxml"));
			Scene scene = new Scene(root,615,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Chat");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
