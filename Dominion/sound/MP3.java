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

/**
 * 
 * @author  Eduart Bunjaku
 *
 */

public final class MP3{ 
	
	Button b;
	

	
	public static void spieleMusik(){
		//Stack overflow
		try{
			
		Media media = new Media(new File("Dominion/sound/Button.mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();

	
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	



}

