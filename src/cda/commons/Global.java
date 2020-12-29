package cda.commons;

/**
 * classes of constants and application settings. the class is
 * named "Global" even if it does not only contain constants.
 * 
 * @author Valentin
 *
 */

public final class Global
{	
	/**
	 * fade-in/fade-out duration.
	 */
	public static final float FADE_SECONDS = 1.5f;

	/**
	 * width of the playing surface in pixels.
	 */
	public static final int SCREEN_WIDTH = 1024;

	/**
	 * height of the playing surface in pixels.
	 */
	public static final int SCREEN_HEIGHT = 768;

	/**
	 * maximum speed of movement of the ship.
	 */
	public static final float SHIP_SPEED = 400f;

	/**
	 * acceleration of the ship.
	 */
	public static final float SHIP_ACCELLERATION = 20f;
	
	/**
	 * points de vie max du vaisseau.
	 */
	public static final int SHIP_LIFE_POINTS = 20;

	/**
	 * force d'impact du vaisseau (quand il percute qqch).
	 */
	public static final int SHIP_IMPACT_FORCE = 20;

	/**
	 * shield : maximum 100%
	 */
	public static final float SHIELD_MAX_ENERGY = 100f;

	/**
	 * shield: speed of shield loading. (5f = 5 seconds)
	 */
	public static final float SHIELD_CHARGING_SPEED = 5f;

	/**
	 * shield: shield discharging speed (10f = 10 secondes)
	 */
	public static final float SHIELD_DISCHARGING_SPEED = 20f;

	/**
	 * shield: potential activation threshold of the shield. (90%)
	 */
	public static final float SHIELD_ACTIVATION_THRESHOLD = 90f;
	
	/**
	 * secondary weapon: loading speed of the secondary weapon. (20f = 5 secondes)
	 */
	public static final float WEAPON_CHARGING_SPEED = 30f;
	
	/**
	 * to display the collision detection circles.
	 */
	private static boolean displayBoundingCircles = false;

	/**
	 * size of the actors' red debugging circle.
	 */
	public static final int BOUNDING_CIRCLE_WIDTH = 3;

	/**
	 * number of enemies generated per squadron.
	 */
	public static final int ENEMY_NUMBER_BY_SQUADRONS = 3;

	/**
	 * number of seconds of waiting between each generation of a wave of enemies.
	 */
	public static final float GENERATION_INTERVAL = 4f;

	private Global()
	{
		/* protection, prevents instantiation from outside */
	}
	
	public static void switchDiplayBoundingCircles() 
	{
		displayBoundingCircles = !displayBoundingCircles;
	}
	
	public static boolean isDisplayBoundingCircles() 
	{
		return displayBoundingCircles;
	}
	
}
