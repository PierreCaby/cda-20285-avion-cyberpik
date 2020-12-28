package cda.actors.managers;

import cda.actors.collectables.Bonus;
import cda.actors.collectables.BonusType;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BonusManager {
	
	public static void bonusCreate(Group pRoot) {
		Bonus bonus = BonusType.create();
		Circle cc = new Circle(bonus.getPositionX(), bonus.getPositionY(), bonus.getDimensionX() / 2, Color.BLUE);

		pRoot.getChildren().add(cc);

		TranslateTransition tt = new TranslateTransition(Duration.seconds(bonus.getSpeed()), cc);
		tt.setFromY(bonus.getPositionY());
		tt.setToY(pRoot.getScene().getHeight() + 200);
		tt.play();
	}
}
