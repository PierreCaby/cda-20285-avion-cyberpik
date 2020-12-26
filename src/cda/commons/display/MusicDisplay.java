package cda.commons.display;

import cda.commons.libs.MusicAsset;
import javafx.application.Application;
import javafx.stage.Stage;

public class MusicDisplay extends Application {

	public static void main(String[] args) {
		MusicAsset.play(MusicAsset.GAME);
//		MusicAsset.play(MusicAsset.STARTER_MENU);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
