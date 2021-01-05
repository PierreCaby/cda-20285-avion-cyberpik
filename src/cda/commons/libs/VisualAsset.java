package cda.commons.libs;

import java.net.URISyntaxException;

/**
 * 
 * Get the visuals from the assets.
 * 
 * @author Antoine
 *
 */

public enum VisualAsset {

	ASTEROID_CLASSIC("asteroids/asteroid-classic.png"),
	ASTEROID_FIRE("asteroids/asteroid-fire.png"),
	ASTEROID_ICE("asteroids/asteroid-ice.png"),
	ASTEROID_ICEBERG("asteroids/asteroid-iceberg.png"),
	ASTEROID_ZIGZAG("asteroids/asteroid-zigzag.png"),
	
	PROTECTION("bonus/protection.png"),
	ROCKET("bonus/rocket.png"),
	
	SKY_BACKGROUND("background/sky-background.png"),
	
	EXPLOSION_SMALL_1("explosion/explosion-small-1.png"),
	EXPLOSION_SMALL_2("explosion/explosion-small-2.png"),
	EXPLOSION_SMALL_3("explosion/explosion-small-3.png"),
	EXPLOSION_SMALL_4("explosion/explosion-small-4.png"),
	EXPLOSION_BIG_1("explosion/explosion-big-1.png"),
	EXPLOSION_BIG_2("explosion/explosion-big-2.png"),
	EXPLOSION_BIG_3("explosion/explosion-big-3.png"),
	EXPLOSION_BIG_4("explosion/explosion-big-4.png"),

	SHIP("ship/ship.png"),
	SHIP_NOREACTOR("ship/ship-noreactor.png"),
	SHIP_LEFT("ship/ship-left.png"),
	SHIP_RIGHT("ship/ship-right.png"),
	SHIELD("ship/shield.png"),
	SHOOT("ship/shoot.png");


	private final String filePath;
	
	VisualAsset(String pFileName) {
		try {
			this.filePath = VisualAsset.class.getResource("/visual/" + pFileName).toURI().toString();
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e.getCause());
		}
	}


	public String getFilePath() {
		return filePath;
	}
				
}
