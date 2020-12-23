package cda.screens.game;

/**
 * classe responsable des affichages "tableau" de bord : le score et la status
 * bar.
 * 
 *
 */

public class DashBoard
{
	private static final String FMT_MSG_BAR = "SchmupGame // FPS : %d // lifePoints : %d // Shield : %02.2f %% // lifeCount : %d";
	private static final int PADDING = 10;
	private static final int MARGE = 10;
	private int hauteurBarre;

	// private Color weaponColor = new Color(0f, 1f, 0f, 0.5f);
	private GamePlayScreen gamePlayScreen;
	// private Texture footer;
	// private BitmapFont font = TrueTypeFont.SHARETECH_12.getFont();

	public DashBoard(GamePlayScreen gamePlayScreen)
	{
		super();
		this.gamePlayScreen = gamePlayScreen;
		// this.footer = TextureAsset.FOOTER.get();
		// this.hauteurBarre = (Global.SCREEN_HEIGHT - footer.getHeight() - (MARGE * 2) - 60);
	}
}
