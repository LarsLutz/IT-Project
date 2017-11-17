package servertest;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerView {
	
		
		public ServerView(Stage primaryStage){
			
			try {
				BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("server.fxml"));
				Scene scene = new Scene(root,600,400);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}



