package cda.actors.managers;

import cda.actors.AbstractActors;
import cda.actors.collectables.Bonus;
import cda.actors.enemies.EnemiesType;
import cda.actors.enemies.Enemy;
import cda.actors.friendly.Ship;
import cda.commons.display.ExplosionDisplay;
import cda.commons.libs.SoundEffectAsset;
import cda.screens.game.GamePlayScreen;
import javafx.scene.layout.Pane;

public class ColisionManager {

	private static boolean isColliding(Ship pShip, AbstractActors pActor) {
		while (pActor.isAlive()) {
			return pShip.getNode().getBoundsInParent().intersects(pActor.getNode().getBoundsInParent());
		}
		return false;
	}

	public static void checkBonusColision() {
		Ship ship = Ship.getShip();
		for (Bonus bonus : Bonus.getBonus()) {
			if (isColliding(Ship.getShip(), bonus)) {
				System.out.println("oh yeaahhhh");
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
//		System.out.println(ship.isShield());
//		System.out.println(ship.isShoot());
	}

	public static void checkEnemyColision() {
		Pane root = GamePlayScreen.getRoot();
		Ship ship = Ship.getShip();
		for (Enemy enemy : Enemy.getEnemies()) {
			if (isColliding(Ship.getShip(), enemy)) {
				System.out.println("oh yeaahhhh");
				ExplosionDisplay.explosionDisplay(enemy);
				ship.decreaseLife(enemy.getDamage());
				System.out.println(ship.getLifeCount());
				enemy.destroy();
				SoundEffectAsset.play(SoundEffectAsset.LOST_LIFE);

			}
		}
	}

}
