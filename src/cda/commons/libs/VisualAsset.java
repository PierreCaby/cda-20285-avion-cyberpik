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
	EXPLOSION_SMALL_1("explosion/explosion-small-1.png"),
	EXPLOSION_SMALL_2("explosion/explosion-small-2.png"),
	EXPLOSION_SMALL_3("explosion/explosion-small-3.png"),
	EXPLOSION_SMALL_4("explosion/explosion-small-4.png"),
	EXPLOSION_SMALL_5("explosion/explosion-small-5.png"),
	EXPLOSION_SMALL_6("explosion/explosion-small-6.png"),
	EXPLOSION_SMALL_7("explosion/explosion-small-7.png"),
	EXPLOSION_SMALL_8("explosion/explosion-small-8.png"),
	EXPLOSION_SMALL_9("explosion/explosion-small-9.png"),
	EXPLOSION_BIG("explosion/explosion-big.png"),
	EXPLOSION_BIG_1("explosion/explosion-big-1.png"),
	EXPLOSION_BIG_2("explosion/explosion-big-2.png"),
	EXPLOSION_BIG_3("explosion/explosion-big-3.png"),
	EXPLOSION_BIG_4("explosion/explosion-big-4.png"),
	EXPLOSION_BIG_5("explosion/explosion-big-5.png"),
	EXPLOSION_BIG_6("explosion/explosion-big-6.png"),
	EXPLOSION_BIG_7("explosion/explosion-big-7.png"),
	EXPLOSION_BIG_8("explosion/explosion-big-8.png"),
	EXPLOSION_BIG_9("explosion/explosion-big-9.png"),
	
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
