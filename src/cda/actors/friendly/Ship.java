package cda.actors.friendly;

import cda.actors.AbstractActors;
import javafx.scene.image.Image;

public class Ship extends AbstractActors {
	private boolean shield;
	private boolean shoot;
	private int lifeCount;
	private static Ship ship;
	

	public Ship(double pPositionX, double pPositionY, double pDimensionX, double pDimensionY, Image pImage, double pSpeed, boolean isAlive, boolean pShield, boolean pShoot,
			int pLifeCount) {
		super(pPositionX, pPositionY, pDimensionX, pDimensionY, pImage, pSpeed, isAlive);
		this.shield = pShield;
		this.shoot = pShoot;
		this.lifeCount = pLifeCount;
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

	

}
