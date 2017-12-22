package sound;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


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
