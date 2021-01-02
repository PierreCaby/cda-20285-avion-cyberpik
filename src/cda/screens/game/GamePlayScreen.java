package cda.screens.game;

import cda.actors.collectables.Bonus;
import cda.actors.enemies.Enemy;
import cda.actors.friendly.Ship;
import cda.actors.friendly.ShipHandler;
import cda.actors.managers.BonusManager;
import cda.actors.managers.ColisionManager;
import cda.actors.managers.EnemiesManager;
import cda.commons.libs.MusicAsset;
import cda.screens.AbstractScreen;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GamePlayScreen extends AbstractScreen // implements ArtefactsScene
{

	private BackgroundParallaxScrolling scrolling;
	private DashBoard dashBoard;

	public GamePlayScreen(Stage window) {
		super(window);
//		scrolling = BackgroundParallaxScrolling.getInstance();
//		scrolling.init(batch);
		dashBoard = new DashBoard(this);
        playMusic(MusicAsset.GAME);

		
		Pane root = new Pane();
		setRoot(root);
		this.scene = new Scene(root, 500, 700);
		window.setScene(scene);
		
		Ship ship = ShipHandler.shipMove();
		Bonus bonus = BonusManager.bonusCreate();
		Enemy enemy = EnemiesManager.enemiesCreate();
		
		AnimationTimer time = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				ColisionManager.checkBonusColision();
				ColisionManager.checkEnemyColision();
				
			}
		};
		time.start();
		
	
	}
}
