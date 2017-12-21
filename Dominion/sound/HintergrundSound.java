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
	
    /**
     * 
     * @author  Jan Mueller
     *
     */

	Media media = new Media(new File("Dominion/sound/Domini.mp3").toURI().toString());
	MediaPlayer player = new MediaPlayer(media);
	
	public void playHintergrundLoop() {
		
		if(!player.isAutoPlay()) {
		try {
			
			player.play();
			//Stack overflow
			player.setCycleCount(MediaPlayer.INDEFINITE);
		} catch (Exception e) {
			e.printStackTrace();
			
		}	
	}
	}
	
	public void stopHintergrundLoop(){
		player.stop();
	}


}
