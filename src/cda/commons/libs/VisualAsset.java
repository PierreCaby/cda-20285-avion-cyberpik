package cda.commons.libs;

import java.io.File;

public enum VisualAsset {

	ASTEROID_CLASSIC("asteroids/asteroid-classic.png"),
	ASTEROID_FIRE("asteroids/asteroid-fire.png"),
	ASTEROID_ICE("asteroids/asteroid-ice.png"),
	ASTEROID_ZIGZAG("asteroids/asteroid-zigzag.png"),
	
	PROTECTION("bonus/protection.png"),
	ROCKET("bonus/rocket.png"),
	
	SKY_BACKGROUND("background/sky-background.png"),
	
	EXPLOSION("explosion/explosion.png"),
	
	SHIP("vessel/ship.png"),
	SHIP_NOREACTOR("vessel/ship-noreactor.png"),
	SHIP_LEFT("vessel/ship-left.png"),
	SHIP_RIGHT("vessel/ship-right.png"),
	SHIELD("vessel/shield.png"),
	SHOOT("vessel/shoot.png");


	private final String filePath;
	
	VisualAsset(String pFileName) {
		this.filePath = new File("assets/visual/" + pFileName).toURI().toString();
	}

	public String getFilePath() {
		return filePath;
	}
				
}
