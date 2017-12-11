package sound;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WAV{

	public static void main(String[] args) {

		File musik = new File("Dominion/sound/Saysz.wav");
		PlaySound(musik);
	
		
	}
	
	
	static void PlaySound(File Sound){
		
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength() / 1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}




}
