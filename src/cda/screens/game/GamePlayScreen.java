package cda.screens.game;

import cda.actors.friendly.Ship;
import cda.actors.friendly.ShipHandler;
import cda.actors.managers.ActorsGenerator;
import cda.actors.managers.ColisionManager;
import cda.actors.managers.ScoreManager;
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

	public GamePlayScreen(Stage window) {
		super(window);
		dashBoard = new DashBoard(this);
		
        playMusic(MusicAsset.GAME);

		
		Pane root = new Pane(addBackground());
		setRoot(root);
		this.scene = new Scene(root, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
		window.setScene(scene);
		
		Ship ship = ShipHandler.shipMove();
		ActorsGenerator.actorsCreate();
		
		AnimationTimer time = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				ColisionManager.checkBonusColision();
				ColisionManager.checkEnemyColision();
				ScoreManager.scoreCalculator();
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
}
