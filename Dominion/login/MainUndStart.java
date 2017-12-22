package login;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// Eduart Bunjaku - Jan Müller
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import sound.HintergrundSound;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
