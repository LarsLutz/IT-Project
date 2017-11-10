package registrieren;

// Eduart Bunjaku
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Registrieren_View {
	
	public Registrieren_View(Stage registrierenStage){
	
		

		registrierenStage.setTitle("Registrieren");
		//registrierenStage.setResizable(false);
		

		try {
			AnchorPane root =  (AnchorPane) FXMLLoader.load(getClass().getResource("RegistrierenGUI.fxml"));
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			registrierenStage.setScene(scene);
			registrierenStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	
		
		
	}
	}


