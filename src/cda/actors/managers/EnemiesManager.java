package cda.actors.managers;

import cda.actors.enemies.EnemiesType;
import cda.actors.enemies.Enemy;
import cda.screens.game.GamePlayScreen;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class EnemiesManager {

	public static void enemiesCreate() {
		Pane root = GamePlayScreen.getRoot();
		Enemy enemy = EnemiesType.create();
		Enemy.addEnemy(enemy);
		Node nodeEnemy =  enemy.getNode();
        nodeEnemy.setTranslateX(enemy.getPositionX());
		nodeEnemy.setTranslateY(enemy.getPositionY());

		
		root.getChildren().add(nodeEnemy);

		if (enemy.isDirection()) {
			Path path = new Path();
			path.getElements().addAll(new MoveTo(enemy.getPositionX(), enemy.getPositionY()),
					new LineTo(enemy.getPositionX() + 200, enemy.getPositionY() + 100),
					new LineTo(enemy.getPositionX(), enemy.getPositionY() + 300),
					new LineTo(enemy.getPositionX() + 200, enemy.getPositionY() + 500),
					new LineTo(enemy.getPositionX(), enemy.getPositionY() + 700),
					new LineTo(enemy.getPositionX() + 200, enemy.getPositionY() + 900),
					new LineTo(enemy.getPositionX(), enemy.getPositionY() + 1100));

			PathTransition pt = new PathTransition(Duration.seconds(enemy.getSpeed()), path, nodeEnemy);
			pt.play();
			
		} else {
			TranslateTransition tt = new TranslateTransition(Duration.seconds(enemy.getSpeed()), nodeEnemy);
			tt.setFromY(enemy.getPositionY());
			tt.setToY(root.getScene().getHeight() + 200);
			tt.play();
		}
	}
}
