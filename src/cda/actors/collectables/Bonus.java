package cda.actors.collectables;

import java.util.Random;

import cda.actors.AbstractActors;
import javafx.scene.image.Image;

public class Bonus extends AbstractActors{
	
	
	public Bonus(double pPositionX, double pPositionY, int pDimensionX, int pDimensionY, Image pImage, double pSpeed) {
		super(pPositionX, pPositionY, pDimensionX, pDimensionY, pImage, pSpeed);
	}



	private BonusType bonus = randomize();
	
	
	
	private BonusType randomize() {
		Random rand = new Random();
		if (rand.nextBoolean()) {
			return BonusType.PROTECTION;
		} else {
			return BonusType.ROCKET;
		}
	}
}
