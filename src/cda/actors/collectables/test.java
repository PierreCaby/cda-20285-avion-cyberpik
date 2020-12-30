package cda.actors.collectables;

import cda.actors.enemies.Enemy;
import cda.actors.friendly.Ship;
import cda.actors.friendly.ShipHandler;
import cda.actors.managers.ActorsGenerator;
import cda.actors.managers.BonusManager;
import cda.actors.managers.ColisionManager;
import cda.actors.managers.EnemiesManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class test extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		try {

			Pane root = new Pane();
			Scene scene = new Scene(root, 500, 700);
			stage.setScene(scene);
			
			
			Ship ship = ShipHandler.shipMove(root);
			Bonus bonus = BonusManager.bonusCreate(root);
			Enemy enemy = EnemiesManager.enemiesCreate(root);
			
			AnimationTimer time = new AnimationTimer() {
				
				@Override
				public void handle(long now) {
					ColisionManager.checkBonusColision();
					ColisionManager.checkEnemyColision();
					
				}
			};
			time.start();
			
			


			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
