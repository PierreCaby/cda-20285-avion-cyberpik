package cda.actors.enemies;

import java.util.Random;

import cda.commons.libs.VisualAsset;
import javafx.scene.image.Image;

public enum EnemiesType {
	

	ASTEROID(Math.random()*460, 0, 40, 40, new Image(VisualAsset.ASTEROID_CLASSIC.getFilePath()), 0.01, 1, 1, false),
	ASTEROID_FIRE(Math.random()*440, 0, 60, 60, new Image(VisualAsset.ASTEROID_FIRE.getFilePath()), 0.008, 2, 2, false),
	ASTEROID_ICE(Math.random()*450, 0, 50, 50, new Image(VisualAsset.ASTEROID_ICE.getFilePath()), 0.01, 2, 3, false),
	ASTEROID_ICEBERG(Math.random()*400, 0, 100, 100, new Image(VisualAsset.ASTEROID_ICE.getFilePath()), 0.01, 4, 5, false),
	ASTEROID_ZIGZAG(Math.random()*460, 0, 40, 40, new Image(VisualAsset.ASTEROID_ZIGZAG.getFilePath()), 0.08, 2, 2, true);
	
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
	
	public Enemy create() {
		EnemiesType enemiesType = randomize();
		return new Enemy(enemiesType.positionX, enemiesType.positionY, enemiesType.dimensionX, enemiesType.dimensionY,
				enemiesType.image, enemiesType.speed, enemiesType.damage, enemiesType.points, enemiesType.direction);
	}
	
}
