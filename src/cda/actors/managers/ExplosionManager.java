package cda.actors.managers;

import cda.actors.AbstractActors;
import cda.commons.libs.SoundEffectAsset;
import cda.commons.libs.VisualAsset;
import cda.screens.game.GamePlayScreen;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * 
 * Set the explosion display.
 * 
 * @author Antoine
 *
 */

public class ExplosionManager {

	private static ImageView image1;
	private static ImageView image2;
	private static ImageView image3;
	private static ImageView image4;

	public static void explosionDisplay(AbstractActors pAbstractActor) {
		Pane root = GamePlayScreen.getRoot();

		if (pAbstractActor.getDimensionX() >= 90) {
			bigImage();
		} else {
			smallImage();
		}

		createExplosion(pAbstractActor);

		SoundEffectAsset.play(SoundEffectAsset.EXPLOSION);

	}

	public static void createExplosion(AbstractActors pAbstractActor) {
		Pane root = GamePlayScreen.getRoot();

		SequentialTransition slideshow = new SequentialTransition();

		image1.setX(pAbstractActor.getNode().getBoundsInParent().getMinX());
		image1.setY(pAbstractActor.getNode().getBoundsInParent().getMinY());
		image2.setX(pAbstractActor.getNode().getBoundsInParent().getMinX());
		image2.setY(pAbstractActor.getNode().getBoundsInParent().getMinY());
		image3.setX(pAbstractActor.getNode().getBoundsInParent().getMinX());
		image3.setY(pAbstractActor.getNode().getBoundsInParent().getMinY());
		image4.setX(pAbstractActor.getNode().getBoundsInParent().getMinX());
		image4.setY(pAbstractActor.getNode().getBoundsInParent().getMinY());

		FadeTransition fadeImage1 = getFadeTransition(image1, 1, 0, 200);
		FadeTransition fadeImage2 = getFadeTransition(image2, 1, 0, 100);
		FadeTransition fadeImage3 = getFadeTransition(image3, 1, 0, 200);
		FadeTransition fadeImage4 = getFadeTransition(image4, 1, 0, 100);

		slideshow.getChildren().add(fadeImage1);
		slideshow.getChildren().add(fadeImage2);
		slideshow.getChildren().add(fadeImage3);
		slideshow.getChildren().add(fadeImage4);
		
		root.getChildren().add(image1);
		root.getChildren().add(image2);
		root.getChildren().add(image3);
		root.getChildren().add(image4);

		slideshow.play();
	}

	public static FadeTransition getFadeTransition(ImageView imageView, double fromValue, double toValue, int durationInMilliseconds) {

		FadeTransition ft = new FadeTransition(Duration.millis(durationInMilliseconds), imageView);
		ft.setFromValue(fromValue);
		ft.setToValue(toValue);
		
		return ft;
	}

	private static void smallImage() {
		image1 = new ImageView(new Image(VisualAsset.EXPLOSION_SMALL_1.getFilePath()));
		image2 = new ImageView(new Image(VisualAsset.EXPLOSION_SMALL_2.getFilePath()));
		image3 = new ImageView(new Image(VisualAsset.EXPLOSION_SMALL_3.getFilePath()));
		image4 = new ImageView(new Image(VisualAsset.EXPLOSION_SMALL_4.getFilePath()));
	}

	private static void bigImage() {
		image1 = new ImageView(new Image(VisualAsset.EXPLOSION_BIG_1.getFilePath()));
		image2 = new ImageView(new Image(VisualAsset.EXPLOSION_BIG_2.getFilePath()));
		image3 = new ImageView(new Image(VisualAsset.EXPLOSION_BIG_3.getFilePath()));
		image4 = new ImageView(new Image(VisualAsset.EXPLOSION_BIG_4.getFilePath()));
	}
}
