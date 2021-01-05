package cda.actors.enemies;

import java.util.ArrayList;

import cda.actors.AbstractActors;
import javafx.scene.image.Image;

/**
 * 
 * Enemy builder, list & specific getters/setters.
 * 
 * @author Antoine
 *
 */

public class Enemy extends AbstractActors {
	private int damage;
	private int points;
	private boolean direction;
	private static ArrayList<Enemy> enemies = new ArrayList<>();

	
	public static ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public static void addEnemy(Enemy pEnemy) {
		enemies.add(pEnemy);
	}
	
	public static void removeEnemy(Enemy pEnemy) {
		enemies.remove(pEnemy);
	}

	public int getDamage() {
		return damage;
	}

	public int getPoints() {
		return points;
	}

	public Enemy(double pPositionX, double pPositionY, double pDimensionX, double pDimensionY, Image pImage, double pSpeed, boolean isAlive, int pDamage, int pPoints, boolean pDirection) {
		super(pPositionX, pPositionY, pDimensionX, pDimensionY, pImage, pSpeed, isAlive);
		this.damage = pDamage;
		this.points = pPoints;
		this.direction = pDirection;
	}

	public boolean isDirection() {
		return direction;
	}

	
}
