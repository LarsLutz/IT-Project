package login;

// Eduart Bunjaku
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Login_View {
	

	final private Stage stage;
	
	public Login_View(Stage stage){
		
		this.stage = stage;
		
		stage.setTitle("Login");
		

		try {
			AnchorPane root =  (AnchorPane) FXMLLoader.load(getClass().getResource("LoginGUI.fxml"));
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	

	

}
