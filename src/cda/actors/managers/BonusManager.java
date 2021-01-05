package cda.actors.managers;

import cda.actors.collectables.Bonus;
import cda.actors.collectables.BonusType;
import cda.screens.game.GamePlayScreen;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * 
 * Set the bonus behaviour.
 * 
 * @author Antoine
 *
 */

public class BonusManager {
	
	public static void bonusCreate() {
		Pane root = GamePlayScreen.getRoot();
		Bonus bonus = BonusType.create();
		Bonus.addBonus(bonus);
		Node nodeBonus = bonus.getNode();
		nodeBonus.setTranslateX(bonus.getPositionX());
		nodeBonus.setTranslateY(bonus.getPositionY());

		root.getChildren().add(nodeBonus);

		TranslateTransition tt = new TranslateTransition(Duration.seconds(bonus.getSpeed()), nodeBonus);
		tt.setFromY(bonus.getPositionY());
		tt.setToY(root.getScene().getHeight() + 200);
		tt.play();
	}
	
}
