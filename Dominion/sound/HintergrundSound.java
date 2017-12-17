package sound;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;


public final class HintergrundSound {
	

// ohne wiederholung	
//	public static void playHintergrund(){
//		Media media = new Media(new File("Dominion/sound/Domini.mp3").toURI().toString());
//		MediaPlayer mp = new MediaPlayer(media);
//		mp.play();
//	}
	
//	public static void sound(){
//		//String titel = "Bitch Better Have My Money (Lyrics).mp3";
//		try{
//			
//		Media media = new Media(new File("Dominion/sound/Domini.mp3").toURI().toString());
//		MediaPlayer mediaPlayer = new MediaPlayer(media);
//		mediaPlayer.play();
//
//	
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	
	
	public static void playHintergrundLoop() {
		//Stack overflow...
		try {
			Media media = new Media(new File("Dominion/sound/Domini.mp3").toURI().toString());
			MediaPlayer player = new MediaPlayer(media);
			//player.setAutoPlay(true);
			player.play();
			player.setCycleCount(MediaPlayer.INDEFINITE);
		} catch (Exception e) {
			e.printStackTrace();
			
		}	
	}
	


}
