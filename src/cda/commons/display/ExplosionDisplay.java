package cda.commons.display;

import cda.actors.AbstractActors;
import cda.commons.libs.VisualAsset;
import cda.screens.game.GamePlayScreen;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ExplosionDisplay {


	public static void explosionDisplay(AbstractActors pAbstractActor) {
		Pane root = GamePlayScreen.getRoot();
		Image image;
		if (pAbstractActor.getDimensionX() >= 90) {
			image = new Image(VisualAsset.EXPLOSION_BIG.getFilePath());
		} else {
			image = new Image(VisualAsset.EXPLOSION_SMALL.getFilePath());
		}

		final int numberOfFrames = 14; // in image
		double frameWidth = image.getWidth() / numberOfFrames;
		final ImageView view = new ImageView(image);
		

		Rectangle mask = new Rectangle(frameWidth, image.getHeight());
		view.setClip(mask);

		Timeline timeline = new Timeline();

		for (int i = 0; i <= numberOfFrames; i++) {
			KeyFrame vKF = new KeyFrame(Duration.millis(i * 150),
					new KeyValue(view.xProperty(), -frameWidth * i, Interpolator.DISCRETE));
			timeline.getKeyFrames().add(vKF);
		}
//		SoundEffectAsset.play(SoundEffectAsset.EXPLOSION);
		timeline.play();

		root.getChildren().add(view);
//		root.relocate(pAbstractActor.getPositionX(), pAbstractActor.getPositionY());
	}

}
