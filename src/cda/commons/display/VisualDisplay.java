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

		Canvas canvas = new Canvas(500, 500);
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
		Image asteroidZigZag = new Image(VisualAsset.ASTEROID_ZIGZAG.getFilePath());

		gc.drawImage(background, 0, 0, canvas.getWidth(), canvas.getHeight());
		gc.drawImage(shipLeft, canvas.getWidth() / 2 - 140, canvas.getHeight() * 3 / 4, 40, 40);
		gc.drawImage(ship, canvas.getWidth() / 2 - 60, canvas.getHeight() * 3 / 4, 40, 40);
		gc.drawImage(shipNoReactor, canvas.getWidth() / 2 + 20, canvas.getHeight() * 3 / 4, 40, 40);
		gc.drawImage(shipRight, canvas.getWidth() / 2 + 100, canvas.getHeight() * 3 / 4, 40, 40);
		gc.drawImage(protection, canvas.getWidth() / 2 - 140, canvas.getHeight() /2, 40, 40);
		gc.drawImage(rocket, canvas.getWidth() / 2 - 60, canvas.getHeight() /2, 40, 40);
		gc.drawImage(shield, canvas.getWidth() / 2 + 20, canvas.getHeight() /2, 40, 40);
		gc.drawImage(shoot, canvas.getWidth() / 2 + 100, canvas.getHeight() /2, 10, 20);
		gc.drawImage(shoot, canvas.getWidth() / 2 + 115, canvas.getHeight() /2, 10, 20);
		gc.drawImage(asteroid, canvas.getWidth() / 2 - 200, canvas.getHeight() / 4, 40, 40);
		gc.drawImage(asteroidFire, canvas.getWidth() / 2 - 100, canvas.getHeight() / 4, 60, 60);
		gc.drawImage(asteroidIce, canvas.getWidth() / 2, canvas.getHeight() / 4, 50, 50);
		gc.drawImage(asteroidIce, canvas.getWidth() / 2 + 80, canvas.getHeight() / 4, 100, 100);
		gc.drawImage(asteroidZigZag, canvas.getWidth() / 2 + 200, canvas.getHeight() / 4, 40, 40);

		stage.show();
		
		
	}

}
