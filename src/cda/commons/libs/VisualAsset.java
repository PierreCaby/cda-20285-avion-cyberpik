package cda.commons.libs;

import java.io.File;

public enum VisualAsset {

	ASTEROID_CLASSIC("asteroids/asteroid-classic.png"),
	ASTEROID_FIRE("asteroids/asteroid-fire.png"),
	ASTEROID_ICE("asteroids/asteroid-ice.png"),
	ASTEROID_ICEBERG("asteroids/asteroid-iceberg.png"),
	ASTEROID_ZIGZAG("asteroids/asteroid-zigzag.png"),
	
	PROTECTION("bonus/protection.png"),
	ROCKET("bonus/rocket.png"),
	
	SKY_BACKGROUND("background/sky-background.png"),
	
	EXPLOSION_SMALL("explosion/explosion-small.png"),
	EXPLOSION_BIG("explosion/explosion-big.png"),
	
	SHIP("ship/ship.png"),
	SHIP_NOREACTOR("ship/ship-noreactor.png"),
	SHIP_LEFT("ship/ship-left.png"),
	SHIP_RIGHT("ship/ship-right.png"),
	SHIELD("ship/shield.png"),
	SHOOT("ship/shoot.png");


	private final String filePath;
	
	VisualAsset(String pFileName) {
		this.filePath = new File("assets/visual/" + pFileName).toURI().toString();
	}

	public String getFilePath() {
		return filePath;
	}
				
}
