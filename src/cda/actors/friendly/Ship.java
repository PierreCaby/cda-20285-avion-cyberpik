package cda.actors.friendly;

import cda.actors.AbstractActors;
import javafx.scene.image.Image;

/**
 * 
 * Ship builder & specific getters/setters.
 * 
 * @author Antoine
 *
 */

public class Ship extends AbstractActors {
	private boolean shield;
	private boolean shoot;
	private int lifeCount;
	private int point;
	private static Ship ship;
	

	public Ship(double pPositionX, double pPositionY, double pDimensionX, double pDimensionY, Image pImage, double pSpeed, boolean isAlive, boolean pShield, boolean pShoot,
			int pLifeCount, int pPoint) {
		super(pPositionX, pPositionY, pDimensionX, pDimensionY, pImage, pSpeed, isAlive);
		this.shield = pShield;
		this.shoot = pShoot;
		this.lifeCount = pLifeCount;
		this.point = pPoint;
	}


	public boolean isShield() {
		return shield;
	}


	public void setShield(boolean shield) {
		this.shield = shield;
	}


	public boolean isShoot() {
		return shoot;
	}


	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
	
	
	public static Ship getShip() {
		return ship;
	}


	public static void setShip(Ship pShip) {
		ship = pShip;
	}


	public int getLifeCount() {
		return lifeCount;
	}


	public void decreaseLife(int pDamage) {
		lifeCount -= pDamage;
		if(lifeCount <= 0) {
			isAlive = false;		}
	}


	public int getPoint() {
		return point;
	}


	public void increasePoint(int pPoint) {
		point += pPoint;
	}

	

}
