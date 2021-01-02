package cda.actors.collectables;

import java.util.ArrayList;

import cda.actors.AbstractActors;
import javafx.scene.image.Image;

public class Bonus extends AbstractActors{
	
	private boolean attack;
	private static ArrayList<Bonus> bonus = new ArrayList<>();
	
	public Bonus(double pPositionX, double pPositionY, double pDimensionX, double pDimensionY, Image pImage, double pSpeed, boolean pIsAlive, boolean pAttack) {
		super(pPositionX, pPositionY, pDimensionX, pDimensionY, pImage, pSpeed, pIsAlive);
		this.attack = pAttack;
	}

	public boolean isAttack() {
		return attack;
	}

	public static ArrayList<Bonus> getBonus() {
		return bonus;
	}

	public static void addBonus(Bonus pBonus) {
		bonus.add(pBonus);
	}
	
	public static void removeBonus() {
		bonus.remove(0);
	}

}
