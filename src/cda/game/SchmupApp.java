package cda.game;

import cda.commons.Global;
import cda.screens.AbstractScreen;
import cda.screens.ScreenFactory;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * Generate the main window and the main loop, load the different
 * screens
 *
 * @author Valentin
 * 
 */
public final class SchmupApp extends Application {
	private static AbstractScreen menuScreen;
	private static AbstractScreen gamePlayScreen;
	private static AbstractScreen scoreBoardScreen;
	
	@Override
	public void start(Stage window) throws Exception {
		configurePrimaryStage(window);
		createFirstScene(window);

		// Display the menu
		window.setScene(menuScreen.getScene());
		window.show();
	}

	private static void configurePrimaryStage(Stage window) {
		window.setTitle(Global.SCREEN_TITLE);
		window.setResizable(false);
	}
	
	/**
	 * Create the different scenes through a factory
	 */
	private static void createFirstScene(Stage window) {
		menuScreen = ScreenFactory.createScreen(ScreenFactory.MENU_SCREEN, window);
		// gamePlayScreen = ScreenFactory.createScreen(ScreenFactory.GAME_SCREEN, window);
		// scoreBoardScreen = ScreenFactory.createScreen(ScreenFactory.SCORE_BOARD_SCREEN, window);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
		
	public static AbstractScreen getMenuScreen() {
		return menuScreen;
	}

	public static void setMenuScreen(AbstractScreen menuScreen) {
		SchmupApp.menuScreen = menuScreen;
	}

	public static AbstractScreen getGamePlayScreen() {
		return gamePlayScreen;
	}

	public static void setGamePlayScreen(AbstractScreen gamePlayScreen) {
		SchmupApp.gamePlayScreen = gamePlayScreen;
	}

	public static AbstractScreen getScoreBoardScreen() {
		return scoreBoardScreen;
	}

	public static void setScoreBoardScreen(AbstractScreen scoreBoardScreen) {
		SchmupApp.scoreBoardScreen = scoreBoardScreen;
	}



}
