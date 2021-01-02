package cda.actors.managers;

import java.util.ArrayList;
import java.util.Random;

import cda.actors.AbstractActors;
import cda.screens.game.GamePlayScreen;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class ActorsGenerator {

	private static ArrayList<AbstractActors> actors = new ArrayList<>();

	public static void actorsCreate() {
		Pane root = GamePlayScreen.getRoot();
		AnimationTimer animationTimer = new AnimationTimer() {
			private long update = 0;
			@Override
			public void handle(long now) {
				if (now - update >= 999999999) {
					Random rand = new Random();
					if (rand.nextInt(20) == 0) {
						BonusManager.bonusCreate();
					} else {
						EnemiesManager.enemiesCreate();
					}                   
					update = now ;
                }
				
			}
			
		};
	
		animationTimer.start();

	}

	public static ArrayList<AbstractActors> getActors() {
		return actors;
	}

}
