package cda.game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Valentin
 *
 *         Generate the main window and the main loop, load the different
 *         screens
 */
public final class SchmupApp extends Application {
	private static String WIN_TITLE = "Cyberpik Schmup";
	private static int WIN_HEIGHT = 700;
	private static int WIN_WIDTH = 600;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Config
		primaryStage.setTitle(WIN_TITLE);
		primaryStage.setResizable(false);

		Group root = new Group();
		// BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
