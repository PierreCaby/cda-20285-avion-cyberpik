package cda.commons.display;

import java.io.File;

import cda.commons.libs.SoundEffectAsset;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SoundEffectDisplay extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Instantiating Media class
		Media explosion = new Media(new File(SoundEffectAsset.EXPLOSION.getFileName()).toURI().toString());
		Media lostGame = new Media(new File(SoundEffectAsset.LOST_GAME.getFileName()).toURI().toString());
		Media lostLife = new Media(new File(SoundEffectAsset.LOST_LIFE.getFileName()).toURI().toString());
		Media newHighscore = new Media(new File(SoundEffectAsset.NEW_HIGHSCORE.getFileName()).toURI().toString());
		Media shield = new Media(new File(SoundEffectAsset.SHIELD.getFileName()).toURI().toString());
		Media shot = new Media(new File(SoundEffectAsset.SHOT.getFileName()).toURI().toString());

		// Instantiating MediaPlayer class
		MediaPlayer explosionPlayer = new MediaPlayer(explosion);
		MediaPlayer lostGamePlayer = new MediaPlayer(lostGame);
		MediaPlayer lostLifePlayer = new MediaPlayer(lostLife);
		MediaPlayer newHighScorePlayer = new MediaPlayer(newHighscore);
		MediaPlayer shieldPlayer = new MediaPlayer(shield);
		MediaPlayer shotPlayer = new MediaPlayer(shot);

		// by setting this property to true, the audio will be played
		explosionPlayer.setAutoPlay(true);	
//		lostGamePlayer.setAutoPlay(true);	
//		lostLifePlayer.setAutoPlay(true);	
//		newHighScorePlayer.setAutoPlay(true);	
//		shieldPlayer.setAutoPlay(true);	
//		shotPlayer.setAutoPlay(true);	
	}
	
}
