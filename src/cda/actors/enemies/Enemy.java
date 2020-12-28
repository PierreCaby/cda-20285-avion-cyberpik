package cda.actors.enemies;

import cda.actors.AbstractActors;
import javafx.scene.image.Image;

public class Enemy extends AbstractActors {
	private int damage;
	private int points;
	private boolean direction;
	
	public Enemy(double pPositionX, double pPositionY, int pDimensionX, int pDimensionY, Image pImage, double pSpeed, int pDamage, int pPoints, boolean pDirection) {
		super(pPositionX, pPositionY, pDimensionX, pDimensionY, pImage, pSpeed);
		this.damage = pDamage;
		this.points = pPoints;
		this.direction = pDirection;
	}

	public boolean isDirection() {
		return direction;
	}


	
}
