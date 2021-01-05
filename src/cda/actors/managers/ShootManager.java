package cda.actors.managers;

import java.util.ArrayList;

import cda.actors.friendly.Ship;
import cda.commons.libs.VisualAsset;
import cda.screens.game.GamePlayScreen;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * 
 * Handle the shoot display and effect.
 * 
 * @author Antoine
 *
 */

public class ShootManager {
	
	private static ArrayList<ImageView> rockets = new ArrayList<>();
	private static float timer;
	
	public static void shootManager() {
		Pane root = GamePlayScreen.getRoot();
		Ship ship = Ship.getShip();
		timer = 10;
		ship.setShoot(true);
	}
	
	
	
	public static void shootCreate() {
		Pane root = GamePlayScreen.getRoot();
		Ship ship = Ship.getShip();
		ImageView nodeShoot1 = new ImageView();
		ImageView nodeShoot2 = new ImageView();

		if(nodeShoot1 != null) {
			root.getChildren().remove(nodeShoot1);
		}
		if(nodeShoot2 != null) {
			root.getChildren().remove(nodeShoot2);
		}
		
		
		nodeShoot1.setImage(new Image(VisualAsset.SHOOT.getFilePath()));
		nodeShoot2.setImage(new Image(VisualAsset.SHOOT.getFilePath()));
		rockets.add(nodeShoot1);
		rockets.add(nodeShoot2);

		nodeShoot1.setX(ship.getNode().getBoundsInParent().getMinX() + 5);
		nodeShoot1.setY(ship.getNode().getBoundsInParent().getMinY());
		nodeShoot2.setX(ship.getNode().getBoundsInParent().getMaxX() - 20);
		nodeShoot2.setY(ship.getNode().getBoundsInParent().getMinY());
		
		Timeline timeline1 = new Timeline(
			new KeyFrame(Duration.millis(10), (evt) -> nodeShoot1.setY(nodeShoot1.getY() - 5))
		);
		Timeline timeline2 = new Timeline(
			new KeyFrame(Duration.millis(10), (evt) -> nodeShoot2.setY(nodeShoot2.getY() - 5))
		);
		
		timeline1.setCycleCount(Animation.INDEFINITE);
		timeline1.play();
		timeline2.setCycleCount(Animation.INDEFINITE);
		timeline2.play();
		
//		AbstractScreen.playSoundEffect(SoundEffectAsset.SHOT);

		root.getChildren().add(nodeShoot1);
		root.getChildren().add(nodeShoot2);
	}


	public static ArrayList<ImageView> getRockets() {
		return rockets;
	}


	public static void setRockets(ArrayList<ImageView> rockets) {
		ShootManager.rockets = rockets;
	}

	public static float getTimer() {
		return timer*10;
	}

	public static void decreaseTimer() {
		timer--;
		if (timer == 0) {
			Ship.getShip().setShoot(false);
		}
	}
	
	
	
}
