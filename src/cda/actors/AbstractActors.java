package cda.actors;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * Abstract Class for every actors on the screen.
 * 
 * @author Antoine
 *
 */

public abstract class AbstractActors {
	private double positionX;
	private double positionY;
	private double dimensionX;
	private double dimensionY;
	private Image image;
	private double speed;
	private ImageView node;
	protected boolean isAlive;
	
	public AbstractActors(double pPositionX, double pPositionY, double pDimensionX, double pDimensionY, Image pImage, double pSpeed, boolean isAlive) {
		this.positionX = pPositionX;
		this.positionY = pPositionY;
		this.dimensionX = pDimensionX;
		this.dimensionY = pDimensionY;
		this.image = pImage;
		this.speed = pSpeed;
		this.node = new ImageView(this.image);
		this.isAlive = isAlive;
	}

	public double getPositionX() {
		return positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public double getDimensionX() {
		return dimensionX;
	}

	public double getDimensionY() {
		return dimensionY;
	}

	public Image getImage() {
		return image;
	}

	public double getSpeed() {
		return speed;
	}

	public ImageView getNode() {
		return node;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
	public void destroy() {
		this.setAlive(false);
		this.getNode().setVisible(false);
	}

	public void setNode(ImageView pNode) {
		this.node = pNode;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
