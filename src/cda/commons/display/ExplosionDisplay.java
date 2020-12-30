package cda.commons.display;

import cda.actors.enemies.Enemy;
import cda.actors.managers.EnemiesManager;
import cda.commons.libs.SoundEffectAsset;
import cda.commons.libs.VisualAsset;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ExplosionDisplay extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Explosion Display");
		Pane root = new Pane();
		Scene scene = new Scene(root, 500, 700);
		stage.setScene(scene);

		explosionDisplay(root);

		stage.show();

	}

	public void explosionDisplay(Pane root) {
		Image image;
//		if (pEnemy.getPoints() == 5) {
//			image = new Image(VisualAsset.EXPLOSION_BIG.getFilePath());
//		} else {
			image = new Image(VisualAsset.EXPLOSION_SMALL.getFilePath());
//		}

		final int numberOfFrames = 14; // in image
		double frameWidth = image.getWidth() / numberOfFrames;
		final ImageView view = new ImageView(image);
//		view.setX(300);
//		view.setY(200);

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
	}

}
