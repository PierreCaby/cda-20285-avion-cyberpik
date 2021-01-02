package cda.screens;

import cda.commons.libs.MusicAsset;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public abstract class AbstractScreen {
	protected Stage window;
	protected static Pane root;
	protected Scene scene;
	protected static MediaPlayer musicMediaPlayer;

	// private static final ControllerAdapter<GameControls> userInput = new
	// ControllerAdapter<>(ControllerFactory.buildMultiController());

	// private final SpriteBatch batch;

	public AbstractScreen(Stage window) {
		this.window = window;
	}

	protected void playMusic(MusicAsset pMusic) {
		Media musicMedia = new Media(pMusic.getFilePath());
		musicMediaPlayer = new MediaPlayer(musicMedia);
		musicMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		musicMediaPlayer.setAutoPlay(true);
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
