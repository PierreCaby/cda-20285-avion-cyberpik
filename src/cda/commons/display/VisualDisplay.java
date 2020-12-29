package cda.commons.display;

import cda.commons.libs.VisualAsset;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class VisualDisplay extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
	
		stage.setTitle("Visual Display");

		Group root = new Group();
		Scene theScene = new Scene(root);
		stage.setScene(theScene);

		Canvas canvas = new Canvas(500, 700);
		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image background = new Image(VisualAsset.SKY_BACKGROUND.getFilePath());
		Image ship = new Image(VisualAsset.SHIP.getFilePath());
		Image shipLeft = new Image(VisualAsset.SHIP_LEFT.getFilePath());
		Image shipRight = new Image(VisualAsset.SHIP_RIGHT.getFilePath());
		Image shipNoReactor = new Image(VisualAsset.SHIP_NOREACTOR.getFilePath());
		Image protection = new Image(VisualAsset.PROTECTION.getFilePath());
		Image rocket = new Image(VisualAsset.ROCKET.getFilePath());
		Image shield = new Image(VisualAsset.SHIELD.getFilePath());
		Image shoot = new Image(VisualAsset.SHOOT.getFilePath());
		Image asteroid = new Image(VisualAsset.ASTEROID_CLASSIC.getFilePath());
		Image asteroidFire = new Image(VisualAsset.ASTEROID_FIRE.getFilePath());
		Image asteroidIce = new Image(VisualAsset.ASTEROID_ICE.getFilePath());
		Image asteroidIceberg = new Image(VisualAsset.ASTEROID_ICEBERG.getFilePath());
		Image asteroidZigZag = new Image(VisualAsset.ASTEROID_ZIGZAG.getFilePath());

	

		stage.show();
		
		
	}

}
