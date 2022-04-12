package application;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
	private MediaPlayer mediaPlayer;

	private MediaPlayer createSound(String musicFile, double volume) {
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setVolume(volume);
		return mediaPlayer;

	}
	
	public MediaPlayer openingMusic() {
		return createSound("./src/intro.mp3", 0.5);
	}
	
	public MediaPlayer battleMusic() {
		return createSound("./src/battle.mp3", 0.5);
	}

}
