package cda.actors.managers;

import cda.actors.friendly.Ship;
import cda.commons.libs.VisualAsset;
import cda.screens.game.GamePlayScreen;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * 
 * Handle the shield display and effect.
 * 
 * @author Antoine
 *
 */

public class ShieldManager {
	
	private static float timer;

	public static void shieldManager() {
		Pane root = GamePlayScreen.getRoot();
		Ship ship = Ship.getShip();
		timer = 10;
		ship.setShield(true);
		
//		AbstractScreen.playSoundEffect(SoundEffectAsset.BONUS);		
	}
	
	public static void shieldCreate() {
		Pane root = GamePlayScreen.getRoot();
		Ship ship = Ship.getShip();
		ImageView nodeShield = new ImageView();
		
		if(nodeShield != null) {
			root.getChildren().remove(nodeShield);
		}
		
		nodeShield.setImage(new Image(VisualAsset.SHIELD.getFilePath()));
		nodeShield.setX(ship.getNode().getBoundsInParent().getMinX() - 10);
		nodeShield.setY(ship.getNode().getBoundsInParent().getMinY() - 10);
		
		FadeTransition vFT = new FadeTransition();
		vFT.setNode(nodeShield);
		vFT.setDuration(Duration.millis(1));
		vFT.setFromValue(0.000001);
		vFT.setToValue(0);
		vFT.play();
		
		root.getChildren().add(nodeShield);
	}

	public static float getTimer() {
		return timer*10;
	}

	public static void decreaseTimer() {
		timer--;
		if (timer == 0) {
			Ship.getShip().setShield(false);
		}
	}
	

}
