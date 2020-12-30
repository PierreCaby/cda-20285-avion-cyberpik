package cda.actors.managers;

import cda.actors.collectables.Bonus;
import cda.actors.collectables.BonusType;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BonusManager {
	
	public static Bonus bonusCreate(Group pRoot) {
		Bonus bonus = BonusType.create();
		Bonus.addBonus(bonus);
		Node nodeBonus = bonus.getNode();
		nodeBonus.setTranslateX(bonus.getPositionX());
		nodeBonus.setTranslateY(bonus.getPositionY());

		pRoot.getChildren().add(nodeBonus);

		TranslateTransition tt = new TranslateTransition(Duration.seconds(bonus.getSpeed()), nodeBonus);
		tt.setFromY(bonus.getPositionY());
		tt.setToY(pRoot.getScene().getHeight() + 200);
		tt.play();
		return bonus;
	}
	
}
