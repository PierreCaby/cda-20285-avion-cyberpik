package cda.actors.managers;

import cda.actors.enemies.Enemy;
import cda.actors.friendly.Ship;
import cda.commons.Global;

public class ScoreManager {

	public static void scoreCalculator() {
		for (Enemy enemy : Enemy.getEnemies()) {
			if (enemy.getNode().getBoundsInParent().getMinY() >= Global.SCREEN_HEIGHT && enemy.isAlive()) {
				Ship.increasePoint(enemy.getPoints());
				System.out.println(Ship.getShip().getPoint());
				enemy.setAlive(false);
			}
		}
	}
}
