package sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MP3{ //extends Application{
	
	Button b;
	

	
	public void spieleMusik(){
		//String titel = "Bitch Better Have My Money (Lyrics).mp3";
		try{
			
		Media media = new Media(new File("Dominion/sound/button-09.wav").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();

	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	



}

