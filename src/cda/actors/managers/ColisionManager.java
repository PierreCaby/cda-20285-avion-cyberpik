package cda.actors.managers;

import cda.actors.AbstractActors;
import cda.actors.collectables.Bonus;
import cda.actors.enemies.Enemy;
import cda.actors.friendly.Ship;
import cda.screens.game.GamePlayScreen;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * 
 * Check the colision between the actors/artefacts and call their effects.
 * 
 * @author Antoine
 *
 */

public class ColisionManager {

	private static boolean isColliding(Ship pShip, AbstractActors pActor) {
		while (pShip.isAlive() && pActor.isAlive()) {
			return pShip.getNode().getBoundsInParent().intersects(pActor.getNode().getBoundsInParent());
		}
		return false;
	}
	private static boolean isCollidingRocket(Enemy pEnemy, ImageView pRocket) {
		while (pEnemy.isAlive() && pEnemy.getNode().getBoundsInParent().getMaxY() >= 30) {
			return pRocket.getBoundsInParent().intersects(pEnemy.getNode().getBoundsInParent());
		}
		return false;
	}

	public static void checkBonusColision() {
		Ship ship = Ship.getShip();
		for (Bonus bonus : Bonus.getBonus()) {
			if (isColliding(ship, bonus)) {
				bonus.setAlive(false);
				if (bonus.isAttack()) { 
					ShootManager.shootManager();
				} else {
					ShieldManager.shieldManager();
				}
				bonus.destroy();
			}
		}
	}

	public static void checkEnemyColision() {
		Pane root = GamePlayScreen.getRoot();
		Ship ship = Ship.getShip();
		for (Enemy enemy : Enemy.getEnemies()) {
			if (isColliding(ship, enemy)) {
				ExplosionManager.explosionDisplay(enemy);
				if (!ship.isShield()) {					
					ship.decreaseLife(enemy.getDamage());
				}
				enemy.destroy();
			}
		}
	}
	
	public static void checkRocketColision() {
		Ship ship = Ship.getShip();
		Pane root = GamePlayScreen.getRoot();
		for (Enemy enemy : Enemy.getEnemies()) {
			for (ImageView rocket : ShootManager.getRockets())
			if (isCollidingRocket(enemy, rocket)) {
				ExplosionManager.explosionDisplay(enemy);
				ship.increasePoint(enemy.getPoints());
				enemy.destroy();
			}
		}
	}

}
