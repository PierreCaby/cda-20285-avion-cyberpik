package cda.commons.display;

import cda.commons.libs.SoundEffectAsset;
import javafx.application.Application;
import javafx.stage.Stage;

public class SoundEffectDisplay extends Application{

	public static void main(String[] args) {
		SoundEffectAsset.play(SoundEffectAsset.EXPLOSION);
//		SoundEffectAsset.play(SoundEffectAsset.LOST_GAME);
//		SoundEffectAsset.play(SoundEffectAsset.LOST_LIFE);
//		SoundEffectAsset.play(SoundEffectAsset.NEW_HIGHSCORE);
//		SoundEffectAsset.play(SoundEffectAsset.SHIELD);
//		SoundEffectAsset.play(SoundEffectAsset.SHOT);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
