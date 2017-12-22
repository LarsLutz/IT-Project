package login;

import java.net.URL;

// Eduart Bunjaku - Jan Müller
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * 
 * @author  Eduart Bunjaku / Jan Mueller (Code um neues Fenster aufzurufen)
 * @author  Lars Lutz (Treiber laden)
 */

public class MainUndStart extends Application{





	@Override
	public void start(Stage primaryStage) {

		primaryStage.setResizable(false);



		try {

			URL fxmlUrl = getClass().getResource("LoginGUI.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl); 
			Parent wurzel = fxmlLoader.load(); 
			Scene scene = new Scene(wurzel);

			primaryStage.setTitle("Dominion");
			primaryStage.setScene(scene);
			primaryStage.show();
			// SQL Treiber wird geladen (Zur kommunikation mit Datenbank
			try {
				//newInstance ladet einen neuen Abschnitt um Fehler zu vermeiden

				Class.forName("com.mysql.jdbc.Driver").newInstance();
				System.out.println("Treiber laden erfolgreich");


			} catch (Exception ex) {
				System.out.println("Treiber laden  fehlgeschlagen");
				ex.printStackTrace();
			}



		} catch(Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);
	}
}
