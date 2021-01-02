package cda.actors.managers;

import cda.actors.AbstractActors;
import cda.actors.collectables.Bonus;
import cda.actors.enemies.Enemy;
import cda.actors.friendly.Ship;
import cda.commons.display.ExplosionDisplay;
import cda.commons.libs.SoundEffectAsset;
import cda.screens.game.GamePlayScreen;
import javafx.scene.layout.Pane;

public class ColisionManager {

	private static boolean isColliding(Ship pShip, AbstractActors pActor) {
		while (pShip.isAlive() && pActor.isAlive()) {
//			System.out.println(pShip.getNode().getBoundsInParent().getMinY());
			return pShip.getNode().getBoundsInParent().intersects(pActor.getNode().getBoundsInParent());
		}
		return false;
	}

	public static void checkBonusColision() {
		Ship ship = Ship.getShip();
		for (Bonus bonus : Bonus.getBonus()) {
			if (isColliding(Ship.getShip(), bonus)) {
				bonus.setAlive(false);
				if (bonus.isAttack()) {
					Ship.getShip().setShoot(true);
					SoundEffectAsset.play(SoundEffectAsset.BONUS);
				} else {
					Ship.getShip().setShield(true);
					SoundEffectAsset.play(SoundEffectAsset.BONUS);
				}
				bonus.destroy();
			}
		}

	}

	public static void checkEnemyColision() {
		Pane root = GamePlayScreen.getRoot();
		Ship ship = Ship.getShip();
		for (Enemy enemy : Enemy.getEnemies()) {
			if (isColliding(Ship.getShip(), enemy)) {
				ExplosionDisplay.explosionDisplay(enemy);
				ship.decreaseLife(enemy.getDamage());
				System.out.println(ship.getLifeCount());
				enemy.destroy();
				SoundEffectAsset.play(SoundEffectAsset.LOST_LIFE);

			}
		}
	}

}
