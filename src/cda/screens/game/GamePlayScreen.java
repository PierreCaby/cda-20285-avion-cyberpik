package cda.screens.game;

import cda.actors.friendly.Ship;
import cda.actors.friendly.ShipHandler;
import cda.actors.managers.ActorsGenerator;
import cda.actors.managers.ColisionManager;
import cda.actors.managers.ScoreManager;
import cda.actors.managers.ShieldManager;
import cda.actors.managers.ShootManager;
import cda.commons.Global;
import cda.commons.libs.MusicAsset;
import cda.commons.libs.VisualAsset;
import cda.screens.AbstractScreen;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GamePlayScreen extends AbstractScreen // implements ArtefactsScene
{

	private BackgroundParallaxScrolling scrolling;
	private DashBoard dashBoard;
	private Ship ship;

	public GamePlayScreen(Stage window) {
		super(window);

		playMusic(MusicAsset.GAME);

		Pane root = new Pane(addBackground());
		setRoot(root);
		this.scene = new Scene(root, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
		window.setScene(scene);

		ship = ShipHandler.shipMove();
		ActorsGenerator.actorsCreate();
		dashBoard = new DashBoard(this);
		
		AnimationTimer time = new AnimationTimer() {
			private long update = 0;

			@Override
			public void handle(long now) {
				if (ship.isShield()) {
					ShieldManager.shieldCreate();
				}
				if (ship.isShoot() && now - update >= 300000000) {
					ShootManager.shootCreate();
					update = now;
				}
				ColisionManager.checkBonusColision();
				ColisionManager.checkEnemyColision();
				ColisionManager.checkRocketColision();
				ScoreManager.scoreCalculator();
				dashBoard.updateStatusBar();
			}
		};
		time.start();

	}

	private ImageView addBackground() {
		ImageView imageView = new ImageView(new Image(VisualAsset.SKY_BACKGROUND.getFilePath()));
		imageView.setFitWidth(Global.SCREEN_WIDTH);
		imageView.setFitHeight(Global.SCREEN_HEIGHT);
		return imageView;
	}

	public Ship getShip() {
		return ship;
	}
}
