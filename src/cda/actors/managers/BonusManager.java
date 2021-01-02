package cda.actors.managers;

import cda.actors.collectables.Bonus;
import cda.actors.collectables.BonusType;
import cda.screens.game.GamePlayScreen;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BonusManager {
	
	public static Bonus bonusCreate() {
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
		return bonus;
	}
	
}
