package cda.commons.libs;

import java.io.File;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public enum MusicAsset {

	GAME("game.mp3"),
	STARTER_MENU("starter-menu.mp3");

	private final String fileName;

	MusicAsset(String pFileName) {
		this.fileName = "assets/audio/game-music/" + pFileName;
	}

	public String getFileName() {
		return fileName;
	}
	
	public static void play(MusicAsset pMusic) {
		Media musicMedia =  new Media(new File(pMusic.getFileName()).toURI().toString());
		MediaPlayer musicMediaPlayer = new MediaPlayer(musicMedia);
		musicMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		musicMediaPlayer.setAutoPlay(true);
	}

}
