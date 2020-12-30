package cda.actors.managers;

import java.util.ArrayList;
import java.util.Random;

import cda.actors.AbstractActors;
import cda.actors.collectables.Bonus;
import javafx.scene.Group;

public class ActorsGenerator {

private static ArrayList<AbstractActors> actors = new ArrayList<>();

	public void actorsGenerator(Group pRoot) {
		if (actors.size() < 4) {
			actors.add(actorsCreate(pRoot));
		}
	}

	public static AbstractActors actorsCreate(Group pRoot) {
		Random rand = new Random();
		if (rand.nextInt(10) == 0) {
			return BonusManager.bonusCreate(pRoot);
		} else {
			return EnemiesManager.enemiesCreate(pRoot);
		}
	}

	public static ArrayList<AbstractActors> getActors() {
		return actors;
	}

	public static void addBonus(Bonus pBonus) {
		actors.add(pBonus);
	}
	
	public static void removeBonus() {
		actors.remove(0);
	}

	
}
