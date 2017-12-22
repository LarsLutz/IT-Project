package sound;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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

