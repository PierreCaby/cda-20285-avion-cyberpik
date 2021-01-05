package cda.screens.game;

import cda.actors.friendly.Ship;
import cda.actors.managers.ShieldManager;
import cda.actors.managers.ShootManager;
import cda.commons.Global;
import cda.commons.libs.FontAsset;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * 
 * class responsible for the player dashboard : score, lifeCount,
 * weapon, shield...
 * 
 * @author Valentin
 *
 */

public class DashBoard {
	private static final String MSG_STATUS_BAR = "Score : %d // lifeCount : %d\n"
			+ "Shield : %02.2f %% // Weapon : %02.2f %%";
	private Text statusBarText;
	private GamePlayScreen gamePlayScreen;
	private Pane pane;

	public DashBoard(GamePlayScreen gamePlayScreen) {
		this.gamePlayScreen = gamePlayScreen;
		this.pane = new Pane();
		gamePlayScreen.getRoot().getChildren().add(pane);
	}

	private void addLifeCount() {
		// TODO : display pretty lifeCount
	}

	private void addShieldBar() {
		// TODO : display pretty ShieldBar
	}

	private void addScore() {
		// TODO : display pretty Score
	}

	public void updateStatusBar() {
		if(statusBarText != null) {
			pane.getChildren().remove(statusBarText);
		}
		
		Ship ship = gamePlayScreen.getShip();
		
		String textBar = String.format(MSG_STATUS_BAR, ship.getPoint(), ship.getLifeCount(), ShieldManager.getTimer(), ShootManager.getTimer());

		statusBarText = new Text(textBar);
		statusBarText.setTextAlignment(TextAlignment.CENTER);
		statusBarText.setFont(Font.loadFont(FontAsset.FIVE_BY_FIVE.getFilePath(), 16));
		statusBarText.setFill(Color.WHITE);

		pane.setTranslateX(Global.SCREEN_WIDTH / 2 - statusBarText.getLayoutBounds().getWidth() / 2);
		pane.setTranslateY(Global.SCREEN_HEIGHT / 20 - statusBarText.getLayoutBounds().getHeight() / 20);
	
		pane.getChildren().addAll(statusBarText);
		pane.toFront();
	}
}
