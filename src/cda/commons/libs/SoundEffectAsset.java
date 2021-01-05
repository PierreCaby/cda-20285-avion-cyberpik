package cda.commons.libs;

import java.net.URISyntaxException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * 
 * Get the sound effects from the assets.
 * 
 * @author Antoine
 *
 */

public enum SoundEffectAsset {

	EXPLOSION("explosion.wav"),
	LOST_GAME("lost-game.wav"),
	LOST_LIFE("lost-life.wav"),
	NEW_HIGHSCORE("new-highscore.wav"),
	BONUS("shield.wav"),
	SHOT("shot.wav");

	private final String filePath;

	SoundEffectAsset(String pFileName) {
		try {
			this.filePath = SoundEffectAsset.class.getResource("/audio/sound-effect/" + pFileName).toURI().toString();
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e.getCause());
		}
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
