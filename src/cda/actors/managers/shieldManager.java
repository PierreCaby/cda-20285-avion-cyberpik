package cda.actors.managers;

import cda.actors.friendly.Ship;
import cda.commons.libs.SoundEffectAsset;
import cda.commons.libs.VisualAsset;
import cda.screens.game.GamePlayScreen;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class shieldManager {

	public static void shieldManager() {
		Pane root = GamePlayScreen.getRoot();
		Ship ship = Ship.getShip();
		ship.setShield(true);
		SoundEffectAsset.play(SoundEffectAsset.BONUS);
		

//		nodeShield.setVisible(true);
		// TODO display shield visual
		// TODO chrono
		// TODO stop visual
//		nodeShield.setVisible(false);
//		Ship.getShip().setShield(false);
		System.out.println("2 " + Ship.getShip().isShield());
		System.out.println("2 " + Ship.getShip().isShoot());
	}
	
	public static void shieldCreate() {
		Pane root = GamePlayScreen.getRoot();
		Ship ship = Ship.getShip();
		ImageView nodeShield = new ImageView(new Image(VisualAsset.SHIELD.getFilePath()));
		nodeShield.setX(ship.getNode().getBoundsInParent().getMinX() - 10);
		nodeShield.setY(ship.getNode().getBoundsInParent().getMinY() - 10);
		FadeTransition vFT = new FadeTransition();
		vFT.setNode(nodeShield);
		vFT.setDuration(Duration.millis(50));
		vFT.setFromValue(0.000001);
		vFT.setToValue(0);
		vFT.play();
		root.getChildren().add(nodeShield);
	}

}
