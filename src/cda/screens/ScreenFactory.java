package cda.screens;

import cda.screens.game.GamePlayScreen;
import cda.screens.menu.MenuScreen;
import cda.screens.scoreboard.ScoreBoardScreen;
import javafx.stage.Stage;

/**
 * Factory of screens
 * 
 * @author Valentin
 *
 */
public class ScreenFactory {
	public static final int MENU_SCREEN = 0;
	public static final int GAME_SCREEN = 1;
	public static final int SCORE_BOARD_SCREEN = 2;

	private ScreenFactory() {
		// factory can't be instanced
	}

	public static AbstractScreen createScreen(int screenType, Stage window) {
		if (screenType < 0 || screenType > 2) {
			throw new IllegalArgumentException("ScreenType not supported : " + screenType);
		} else {
			switch (screenType) {
			case MENU_SCREEN:
				return new MenuScreen(window);
			case GAME_SCREEN:
				return new GamePlayScreen(window);
			case SCORE_BOARD_SCREEN:
				return new ScoreBoardScreen(window);
			default:
				return null; // should not be the case
			}
		}
	}

}
