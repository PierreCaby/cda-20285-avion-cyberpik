package cda.commons.libs;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public enum MusicAsset {

	GAME("game.mp3"),
	STARTER_MENU("starter-menu.mp3");

	private final String filePath;

	MusicAsset(String pFileName) {
		this.filePath = new File("assets/audio/game-music/" + pFileName).toURI().toString();
	}

	public String getFilePath() {
		return filePath;
	}
	
	public static void play(MusicAsset pMusic) {
		Media musicMedia =  new Media(pMusic.filePath);
		MediaPlayer musicMediaPlayer = new MediaPlayer(musicMedia);
		musicMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		musicMediaPlayer.setAutoPlay(true);
	}

}
