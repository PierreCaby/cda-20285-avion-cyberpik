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
import cda.game.SchmupApp;
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
	private AnimationTimer timer;

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

		timer = new AnimationTimer() {
			private long updateShoot = 0;
			private long updateActors = 0;
			private long updateChronoShield = 0;
			private long updateChronoShoot = 0;

			@Override
			public void handle(long now) {
				if (now - updateActors >= 999999999) {
					ActorsGenerator.actorsCreate();
					updateActors = now;
				}
				ShipHandler.movehandler();
				if (ship.isShield()) {
					ShieldManager.shieldCreate();
					if (now - updateChronoShield >= 999999999) {
						ShieldManager.decreaseTimer();
						updateChronoShield = now;
					}
				}
				if (ship.isShoot() && now - updateShoot >= 333333333) {
					ShootManager.shootCreate();
					updateShoot = now;
				}
				if (ship.isShoot() && now - updateChronoShoot >= 999999999) {
					ShootManager.decreaseTimer();
					updateChronoShoot = now;
				}

				if (isGameOver()) {
					closeGame();
				}

				ColisionManager.checkBonusColision();
				ColisionManager.checkEnemyColision();
				ColisionManager.checkRocketColision();
				ScoreManager.scoreCalculator();
				dashBoard.updateStatusBar();
			}
		};
		timer.start();

	}

	private ImageView addBackground() {
		ImageView imageView = new ImageView(new Image(VisualAsset.SKY_BACKGROUND.getFilePath()));
		imageView.setFitWidth(Global.SCREEN_WIDTH);
		imageView.setFitHeight(Global.SCREEN_HEIGHT);
		return imageView;
	}

	private void closeGame() {
		timer.stop();
		stopMusic();
		playMusic(MusicAsset.STARTER_MENU);
		window.setScene(SchmupApp.getMenuScreen().getScene());
	}

	private boolean isGameOver() {
		return !ship.isAlive();
	}

	public Ship getShip() {
		return ship;
	}
}