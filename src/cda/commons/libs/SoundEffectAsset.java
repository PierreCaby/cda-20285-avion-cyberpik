package cda.commons.libs;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public enum SoundEffectAsset {

	EXPLOSION("explosion.wav"),
	LOST_GAME("lost-game.wav"),
	LOST_LIFE("lost-life.wav"),
	NEW_HIGHSCORE("new-highscore.wav"),
	SHIELD("shield.wav"),
	SHOT("shot.wav");

	private final String filePath;

	SoundEffectAsset(String pFileName) {
		this.filePath = new File("assets/audio/sound-effect/" + pFileName).toURI().toString();
	}

	public String getFilePath() {
		return filePath;
	}
	
	public static void play(SoundEffectAsset pSoundEffect) {
		Media soundEffectMedia =  new Media(pSoundEffect.filePath);
		MediaPlayer soundEffectMediaPlayer = new MediaPlayer(soundEffectMedia);
		if(pSoundEffect == SHOT) {
			soundEffectMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		}
		soundEffectMediaPlayer.setAutoPlay(true);
	}
}
