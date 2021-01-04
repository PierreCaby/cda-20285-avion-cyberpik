package cda.screens.game;

import cda.actors.friendly.Ship;

/**
 * classe responsable des affichages "tableau" de bord : le score et la status
 * bar.
 * 
 *
 */

public class DashBoard {
	private static final String FMT_MSG_BAR = "SchmupGame // FPS : %d // lifePoints : %d // Shield : %02.2f %% // lifeCount : %d";
	private static final int PADDING = 10;
	private static final int MARGE = 10;
	private int hauteurBarre;

	private GamePlayScreen gamePlayScreen;

	public DashBoard(GamePlayScreen gamePlayScreen) {
		super();
		this.gamePlayScreen = gamePlayScreen;
		// this.footer = TextureAsset.FOOTER.get();
		// this.hauteurBarre = (Global.SCREEN_HEIGHT - footer.getHeight() - (MARGE * 2)
		// - 60);
	}
	
	private void addLifeCount() {
	}
	
	private void addShieldBar() {
	}
	
	private void addScore() {	
	}
	
	private void addStatusBar() {
		int fps = 60; // TO DO get the speed somewhere
		Ship ship = gamePlayScreen.getShip();
		// TO DO ajouter notion shield
		String titleBar = String.format(FMT_MSG_BAR, fps, ship.getLifeCount(), "Ajouter shield", ship.getLifeCount());
	}
}
