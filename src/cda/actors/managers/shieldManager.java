package cda.actors.managers;

import cda.actors.friendly.Ship;
import cda.commons.libs.SoundEffectAsset;
import cda.commons.libs.VisualAsset;
import cda.screens.game.GamePlayScreen;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class shieldManager {

	public void shieldManager() {
		Pane root = GamePlayScreen.getRoot();
		Ship ship = Ship.getShip();
		ship.setShield(true);
		SoundEffectAsset.play(SoundEffectAsset.BONUS);
		Node nodeShield = new ImageView(new Image(VisualAsset.SHIELD.getFilePath()));

		
		//TODO display shield visual
		//TODO chrono
		//TODO stop visual
//		Ship.getShip().setShield(false);
	}
}
