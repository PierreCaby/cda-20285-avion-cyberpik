package cda.actors.managers;

import java.util.Random;

import javafx.animation.AnimationTimer;

/**
 * 
 * Create bonus and enemies in a random way.
 * 
 * @author Antoine
 *
 */

public class ActorsGenerator {

	public static void actorsCreate() {
		Random rand = new Random();
		if (rand.nextInt(20) == 0) {
			BonusManager.bonusCreate();
		} else {
			EnemiesManager.enemiesCreate();
		}
	}
}