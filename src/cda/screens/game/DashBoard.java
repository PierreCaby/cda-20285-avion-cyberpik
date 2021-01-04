package cda.screens.game;

import cda.actors.friendly.Ship;

/**
 * classe responsable des affichages "tableau" de bord : le score et la status
 * bar.
 * 
 *
 */

public class DashBoard {
	private static final String MSG_STATUS_BAR = "SchmupGame // Score : %d // lifeCount : %d // Shield : %02.2f %% // Weapon : %02.2f %%";
	private static final int PADDING = 10;
	private int hauteurBarre;

	private GamePlayScreen gamePlayScreen;

	public DashBoard(GamePlayScreen gamePlayScreen) {
		this.gamePlayScreen = gamePlayScreen;
		this.addStatusBar();
		
		// this.footer = TextureAsset.FOOTER.get();
		// this.hauteurBarre = (Global.SCREEN_HEIGHT - footer.getHeight() - (PADDING * 2)
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
		// TO DO ajouter notion shield
		String titleBar = String.format(MSG_STATUS_BAR, ship.getPoint(), ship.getLifeCount(), 95.55f, 50f);
		System.out.println(titleBar);
	}
}
