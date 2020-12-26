package cda.commons.display;

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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ExplosionVisualDisplay extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Visual Display");
		Group root = new Group();
		Image image = new Image(VisualAsset.EXPLOSION.getFilePath());

		final int numberOfFrames = 14; // in image
		double frameWidth = image.getWidth() / numberOfFrames;
		Scene scene = new Scene(root, frameWidth, image.getHeight());
		final ImageView view = new ImageView(image);

		Rectangle mask = new Rectangle(frameWidth, image.getHeight());
		view.setClip(mask);

		Timeline timeline = new Timeline();

		for (int i = 0; i <= numberOfFrames; i++) {
			KeyFrame kf = new KeyFrame(Duration.millis(i * 50),
					new KeyValue(view.xProperty(), -frameWidth * i, Interpolator.DISCRETE));
			timeline.getKeyFrames().add(kf);
		}
	    timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

		root.getChildren().add(view);
		stage.setScene(scene);
		stage.show();

	}

}
