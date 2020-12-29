package cda.actors.collectables;

import cda.actors.friendly.ShipHandler;
import cda.actors.managers.BonusManager;
import cda.actors.managers.EnemiesManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		try {

			Group root = new Group();
			Scene scene = new Scene(root, 500, 700);
			stage.setScene(scene);
			
			ShipHandler.shipMove(root);
			BonusManager.bonusCreate(root);
			EnemiesManager.enemiesCreate(root);

			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
