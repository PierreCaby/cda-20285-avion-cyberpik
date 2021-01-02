package cda.actors.friendly;

import cda.actors.AbstractActors;
import cda.commons.display.ExplosionDisplay;
import cda.game.SchmupApp;
import cda.screens.game.GamePlayScreen;
import javafx.scene.image.Image;

public class Ship extends AbstractActors {
	private boolean shield;
	private boolean shoot;
	private static int lifeCount;
	private static int point;
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


	public static void decreaseLife(int pDamage) {
		lifeCount -= pDamage;
		if(lifeCount<=0) {
			//TODO close game
		}
	}


	public int getPoint() {
		return point;
	}


	public static void increasePoint(int pPoint) {
		point += pPoint;
	}

	

}
