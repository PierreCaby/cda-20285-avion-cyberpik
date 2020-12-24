package cda.commons.display;

import java.io.File;

import cda.commons.libs.MusicAsset;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MusicDisplay extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Instantiating Media class
		Media game = new Media(new File(MusicAsset.GAME.getFileName()).toURI().toString());
//		Media starterMenu = new Media(new File(MusicAsset.STARTER_MENU.getFileName()).toURI().toString());
		
		// Instantiating MediaPlayer class
		MediaPlayer gamePlayer = new MediaPlayer(game);
//		MediaPlayer starterMenuPlayer = new MediaPlayer(starterMenu);

		// by setting this property to true, the audio will be played
		gamePlayer.setAutoPlay(true);		
//		starterMenuPlayer.setAutoPlay(true);		
        primaryStage.setTitle("Playing Audio");  
        primaryStage.show();  
	}
}
