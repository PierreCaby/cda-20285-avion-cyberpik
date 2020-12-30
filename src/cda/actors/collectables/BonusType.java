package cda.actors.collectables;

import java.util.Random;


import cda.commons.libs.VisualAsset;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public enum BonusType {

	PROTECTION(Math.random() * 460, -100, 40, 40, new Image(VisualAsset.PROTECTION.getFilePath()), 4.5, true, false),
	ROCKET(Math.random() * 460, -100, 40, 40, new Image(VisualAsset.ROCKET.getFilePath()), 4.5, true, true);

	private double positionX;
	private double positionY;
	private int dimensionX;
	private int dimensionY;
	private Image image;
	private double speed;
	private boolean isAlive;
	private boolean attack;

	BonusType(double pPositionX, double pPositionY, int pDimensionX, int pDimensionY, Image pImage, double pSpeed, boolean pIsAlive, boolean pAttack) {
		this.positionX = pPositionX;
		this.positionY = pPositionY;
		this.dimensionX = pDimensionX;
		this.dimensionY = pDimensionY;
		this.image = pImage;
		this.speed = pSpeed; 
		this.isAlive = pIsAlive;
		this.attack = pAttack;
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
				bonusType.image, bonusType.speed, bonusType.isAlive, bonusType.attack);
	}

}
