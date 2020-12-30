package cda.actors.managers;

import cda.actors.AbstractActors;
import cda.actors.collectables.Bonus;
import cda.actors.friendly.Ship;

public class ColisionManager {

	private static boolean isColliding(Ship pShip, AbstractActors pActor) {
		return pShip.getNode().getBoundsInParent().intersects(pActor.getNode().getBoundsInParent());
	}


	public static void checkBonusColision() {
		Ship ship = Ship.getShip();
		for (Bonus bonus : Bonus.getBonus()) {
		if (isColliding(Ship.getShip(), bonus)) {
				System.out.println("oh yeaahhhh");
				bonus.setAlive(false);
				if (bonus.isAttack()) {
					Ship.getShip().setShoot(true);
				} else {
					Ship.getShip().setShoot(true);
				}
			}
		}
		System.out.println(ship.isShield());
		System.out.println(ship.isShoot());
	}

}
