package cda.actors.managers;

import cda.actors.enemies.EnemiesType;
import cda.actors.enemies.Enemy;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class EnemiesManager {

	public static Enemy enemiesCreate(Group pRoot) {
		Enemy enemy = EnemiesType.create();
		Node nodeEnemy =  enemy.getNode();
        nodeEnemy.setTranslateX(enemy.getPositionX());
		nodeEnemy.setTranslateY(enemy.getPositionY());

		
		pRoot.getChildren().add(nodeEnemy);

		if (enemy.isDirection()) {
			Path path = new Path();
			path.getElements().addAll(new MoveTo(enemy.getPositionX(), enemy.getPositionY()),
					new LineTo(enemy.getPositionX() + 100, enemy.getPositionY() + 100),
					new LineTo(enemy.getPositionX() - 100, enemy.getPositionY() + 300),
					new LineTo(enemy.getPositionX() + 100, enemy.getPositionY() + 500),
					new LineTo(enemy.getPositionX() - 100, enemy.getPositionY() + 700),
					new LineTo(enemy.getPositionX() + 100, enemy.getPositionY() + 900));

			PathTransition pt = new PathTransition(Duration.seconds(enemy.getSpeed()), path, nodeEnemy);
			pt.play();
			
		} else {
			TranslateTransition tt = new TranslateTransition(Duration.seconds(enemy.getSpeed()), nodeEnemy);
			tt.setFromY(enemy.getPositionY());
			tt.setToY(pRoot.getScene().getHeight() + 200);
			tt.play();
		}
		return enemy;
	}
}
