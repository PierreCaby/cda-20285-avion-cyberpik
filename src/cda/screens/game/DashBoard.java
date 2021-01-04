package cda.screens.game;

import cda.actors.friendly.Ship;
import cda.commons.Global;
import cda.commons.libs.FontAsset;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * classe responsable des affichages "tableau" de bord : le score et la status
 * bar.
 * 
 *
 */

public class DashBoard {
	private static final String MSG_STATUS_BAR = "SchmupGame // Score : %d // lifeCount : %d //\n"
			+ "   Shield : %02.2f %% // Weapon : %02.2f %%";
	private static final int PADDING = 10;
	private int hauteurBarre;

	private GamePlayScreen gamePlayScreen;

	public DashBoard(GamePlayScreen gamePlayScreen) {
		this.gamePlayScreen = gamePlayScreen;
		this.addStatusBar();

		// this.footer = TextureAsset.FOOTER.get();
		// this.hauteurBarre = (Global.SCREEN_HEIGHT - footer.getHeight() - (PADDING *
		// 2)
		// - 60);
	}

	private void addLifeCount() {
	}

	private void addShieldBar() {
	}

	private void addScore() {
	}

	private void addStatusBar() {
		Ship ship = gamePlayScreen.getShip();
		// TO DO ajouter notion shield et arme
		String textBar = String.format(MSG_STATUS_BAR, ship.getPoint(), ship.getLifeCount(), 95.55f, 50f);
		System.out.println(textBar);

		Text text = new Text(textBar);

		text.setFont(Font.loadFont(FontAsset.FIVE_BY_FIVE.getFilePath(), 16));
		text.setFill(Color.WHITE);

		Pane pane = new Pane();
		pane.setTranslateX(Global.SCREEN_WIDTH / 2 - text.getLayoutBounds().getWidth() / 2);
		pane.setTranslateY(Global.SCREEN_HEIGHT / 20 - text.getLayoutBounds().getHeight() / 20);

		pane.getChildren().addAll(text);
		gamePlayScreen.getRoot().getChildren().add(pane);
	}
}
