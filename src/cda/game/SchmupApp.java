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
		// Config
		window.setTitle(Global.SCREEN_TITLE);
		window.setResizable(false);

		// Create the different scene through a factory
		AbstractScreen menuScreen = ScreenFactory.createScreen(ScreenFactory.MENU_SCREEN, window);
		AbstractScreen gamePlayScreen = ScreenFactory.createScreen(ScreenFactory.GAME_SCREEN, window);
		AbstractScreen scoreBoardScreen = ScreenFactory.createScreen(ScreenFactory.SCORE_BOARD_SCREEN, window);
		
		
		// Display the menu
		window.setScene(menuScreen.getScene());
		window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
