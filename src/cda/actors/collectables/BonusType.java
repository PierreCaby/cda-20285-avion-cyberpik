package cda.actors.collectables;

import java.util.Random;


import cda.commons.libs.VisualAsset;
import javafx.scene.image.Image;

public enum BonusType {

	PROTECTION(Math.random() * 460, -100, 40, 40, new Image(VisualAsset.PROTECTION.getFilePath()), 4.5),
	ROCKET(Math.random() * 460, -100, 40, 40, new Image(VisualAsset.ROCKET.getFilePath()), 4.5);

	private double positionX;
	private double positionY;
	private int dimensionX;
	private int dimensionY;
	private Image image;
	private double speed;

	BonusType(double pPositionX, double pPositionY, int pDimensionX, int pDimensionY, Image pImage, double pSpeed) {
		this.positionX = pPositionX;
		this.positionY = pPositionY;
		this.dimensionX = pDimensionX;
		this.dimensionY = pDimensionY;
		this.image = pImage;
		this.speed = pSpeed; 
	}

	private static BonusType randomize() {
		Random rand = new Random();
		if (rand.nextBoolean()) {
			return BonusType.PROTECTION;
		} else {
			return BonusType.ROCKET;
		}
	}

	public static Bonus create() {
		BonusType bonusType = randomize();
		return new Bonus(bonusType.positionX, bonusType.positionY, bonusType.dimensionX, bonusType.dimensionY,
				bonusType.image, bonusType.speed);
	}

	public Image getImage() {
		return image;
	}
	

}
