package cda.actors.enemies;

import java.util.Random;

import cda.commons.libs.VisualAsset;
import javafx.scene.image.Image;

public enum EnemiesType {
	

	ASTEROID(Math.random()*450, -100, 50, 50, new Image(VisualAsset.ASTEROID_CLASSIC.getFilePath()), 4, 1, 1, false),
	ASTEROID_FIRE(Math.random()*430, -100, 70, 70, new Image(VisualAsset.ASTEROID_FIRE.getFilePath()), 4.5, 2, 2, false),
	ASTEROID_ICE(Math.random()*440, -100, 60, 60, new Image(VisualAsset.ASTEROID_ICE.getFilePath()), 4, 2, 3, false),
	ASTEROID_ICEBERG(Math.random()*380, -120, 100, 100, new Image(VisualAsset.ASTEROID_ICEBERG.getFilePath()), 4, 4, 5, false),
	ASTEROID_ZIGZAG(100 + Math.random()*350, -120, 50, 50, new Image(VisualAsset.ASTEROID_ZIGZAG.getFilePath()), 5, 2, 2, true);
	
	private double positionX;
	private double positionY;
	private int dimensionX;
	private int dimensionY;
	private Image image;
	private double speed;
	private int damage;
	private int points;
	private boolean direction;
	
	EnemiesType(double pPositionX, double pPositionY, int pDimensionX, int pDimensionY, Image pImage, double pSpeed, int pDamage, int pPoints, boolean pDirection) {
		this.positionX = pPositionX;
		this.positionY = pPositionY;
		this.dimensionX = pDimensionX;
		this.dimensionY = pDimensionY;
		this.image = pImage;
		this.speed = pSpeed;
		this.damage = pDamage;
		this.points = pPoints;
		this.direction = pDirection;
	}

	private static EnemiesType randomize() {
		Random rand = new Random();
		switch (rand.nextInt(5)) {
		case 0:
			return ASTEROID;
		
		case 1:
			return ASTEROID_FIRE;
			
		case 2:
			return ASTEROID_ICE;
			
		case 3:
			return ASTEROID_ICEBERG;
			
		default:
			return ASTEROID_ZIGZAG;
		}
	}
	
	public static Enemy create() {
		EnemiesType enemiesType = randomize();
		return new Enemy(enemiesType.positionX, enemiesType.positionY, enemiesType.dimensionX, enemiesType.dimensionY,
				enemiesType.image, enemiesType.speed, enemiesType.damage, enemiesType.points, enemiesType.direction);
	}
	
}
