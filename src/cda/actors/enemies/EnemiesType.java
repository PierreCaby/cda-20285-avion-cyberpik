package cda.actors.enemies;

import java.util.Random;

import cda.commons.Global;
import cda.commons.libs.VisualAsset;
import javafx.scene.image.Image;

/**
 * 
 * Enemy types & creation of random enemies. 
 * 
 * @author Antoine
 *
 */

public enum EnemiesType {
	

	ASTEROID(Global.SCREEN_WIDTH -50, -120, 50, 50, new Image(VisualAsset.ASTEROID_CLASSIC.getFilePath()), 4, true, 1, 1, false),
	ASTEROID_FIRE(Global.SCREEN_WIDTH - 70, -120, 70, 70, new Image(VisualAsset.ASTEROID_FIRE.getFilePath()), 4.5, true, 2, 2, false),
	ASTEROID_ICE(Global.SCREEN_WIDTH - 60, -120, 60, 60, new Image(VisualAsset.ASTEROID_ICE.getFilePath()), 4, true, 2, 3, false),
	ASTEROID_ICEBERG(Global.SCREEN_WIDTH - 120, -120, 120, 120, new Image(VisualAsset.ASTEROID_ICEBERG.getFilePath()), 4, true, 4, 5, false),
	ASTEROID_ZIGZAG(Global.SCREEN_WIDTH - 250, -120, 50, 50, new Image(VisualAsset.ASTEROID_ZIGZAG.getFilePath()), 5, true, 2, 2, true);
	
	private double positionX;
	private double positionY;
	private double dimensionX;
	private double dimensionY;
	private Image image;
	private double speed;
	private boolean isAlive;
	private int damage;
	private int points;
	private boolean direction;
	
	EnemiesType(double pPositionX, double pPositionY, double pDimensionX, double pDimensionY, Image pImage, double pSpeed, boolean pIsAlive, int pDamage, int pPoints, boolean pDirection) {
		this.positionX = pPositionX;
		this.positionY = pPositionY;
		this.dimensionX = pDimensionX;
		this.dimensionY = pDimensionY;
		this.image = pImage;
		this.speed = pSpeed;
		this.isAlive = pIsAlive;
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
		return new Enemy(Math.random()*enemiesType.positionX, enemiesType.positionY, enemiesType.dimensionX, enemiesType.dimensionY,
				enemiesType.image, enemiesType.speed, enemiesType.isAlive, enemiesType.damage, enemiesType.points, enemiesType.direction);
	}
	
}
