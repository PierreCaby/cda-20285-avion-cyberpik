package cda.actors.friendly;

import cda.commons.libs.VisualAsset;
import javafx.scene.image.Image;

public enum ShipView {
	SHIP(new Image(VisualAsset.SHIP.getFilePath())),
	SHIP_NOREACTOR(new Image(VisualAsset.SHIP_NOREACTOR.getFilePath())),
	SHIP_LEFT(new Image(VisualAsset.SHIP_LEFT.getFilePath())),
	SHIP_RIGHT(new Image(VisualAsset.SHIP_RIGHT.getFilePath()));

	private final Image image;

	ShipView(Image pImage) {
		this.image = pImage;
	}
	
	public Image getImage() {
	return this.image;
	}

}
