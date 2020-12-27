package cda.actors.friendly;

import cda.actors.AbstractActors;
import javafx.scene.image.Image;

public class Ship extends AbstractActors {
	private boolean shield;
	private boolean shoot;
	private int lifeCount;
	
	
	public Ship(double pPositionX, double pPositionY, int pDimensionX, int pDimensionY, Image pImage, double pSpeed, boolean pShield, boolean pShoot,
			int pLifeCount) {
		super(pPositionX, pPositionY, pDimensionX, pDimensionY, pImage, pSpeed);
		this.shield = pShield;
		this.shoot = pShoot;
		this.lifeCount = pLifeCount;
	}

}
