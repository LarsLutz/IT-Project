package chat;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//Jan Müller

public class Chat_Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Chat_Model cm = new Chat_Model();
		Chat_View cv = new Chat_View(primaryStage);
		Chat_Controller cc = new Chat_Controller();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
