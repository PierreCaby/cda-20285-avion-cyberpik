package cda.screens;

import cda.commons.libs.MusicAsset;
import cda.commons.libs.SoundEffectAsset;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * 
 * Parent class of all the screens of the game. Each Screen is constructed
 * around a scene and a pane.
 * 
 * @author Valentin
 *
 */
public abstract class AbstractScreen {
	protected Stage window;
	protected static Pane root;
	protected Scene scene;
	protected static MediaPlayer musicMediaPlayer;

	public AbstractScreen(Stage window) {
		this.window = window;
	}

	protected static void playMusic(MusicAsset pMusic) {
		Media musicMedia = new Media(pMusic.getFilePath());
		musicMediaPlayer = new MediaPlayer(musicMedia);
		musicMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		musicMediaPlayer.setAutoPlay(true);
	}
	
	public static void playSoundEffect(SoundEffectAsset pMusic) {
		AudioClip audio = new AudioClip(pMusic.getFilePath());
		audio.setVolume(0.5f);
        audio.play();
	}

	protected static void stopMusic() {
		musicMediaPlayer.stop();
	}

	public Scene getScene() {
		return scene;
	}

	public static Pane getRoot() {
		return root;
	}

	public static void setRoot(Pane pRoot) {
		root = pRoot;
	}
}
