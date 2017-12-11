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
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


//Eduart Bunjaku - Jan Müller

public class MainUndStart extends Application{
	
	//private Login_View v;
	//private Login_Model m;
	//private Login_Controller c;

	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setResizable(false);
		//v = new Login_View(primaryStage);
		//m = new Login_Model();
		//c = new Login_Controller();
		
		Media media = new Media(new File("Dominion/login/Domini.mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();

		
		
		try {
			
			URL fxmlUrl = getClass().getResource("LoginGUI.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl); 
			//fxmlLoader.setController(sn_c); - dieser Code teil wirft eine komische Exception.. habe ausserdem nicht verstanden was der Code macht...
			Parent root = fxmlLoader.load(); 
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Dominion");
			primaryStage.setScene(scene);
			primaryStage.show();
			// SQL Treiber wird geladen (Zur kommunikation mit Datenbank
			try {
				//newInstance ladet einen neuen Abschnitt um fehler zu vermeiden

		        Class.forName("com.mysql.jdbc.Driver").newInstance();
		        System.out.println("Treiber laden erfolgreich");
		        	
		        
		    } catch (Exception ex) {
		        System.out.println("Treiber laden  fehlgeschlagen");
		        ex.printStackTrace();
		    }
			
			//SQLInjection sqln = new SQLInjection(); - evt später für larsiboy?
			//sqln.connectDatabase();
			
			//Loading LobbyView into Class
			//FXMLLoader.load(getClass().getResource("LobbyView.fxml"));
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
