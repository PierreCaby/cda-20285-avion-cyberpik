package cda.actors;

import javafx.scene.image.Image;

public abstract class AbstractActors {
	private double positionX;
	private double positionY;
	private int dimensionX;
	private int dimensionY;
	private Image image;
	private double speed;
	
	public AbstractActors(double pPositionX, double pPositionY, int pDimensionX, int pDimensionY, Image pImage, double pSpeed) {
		this.positionX = pPositionX;
		this.positionY = pPositionY;
		this.dimensionX = pDimensionX;
		this.dimensionY = pDimensionY;
		this.image = pImage;
		this.speed = pSpeed;
	}
	
	
	
}
