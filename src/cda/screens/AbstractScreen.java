package cda.screens;

import cda.commons.Global;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class AbstractScreen {
	protected Stage window;
	protected Parent root;
	protected Scene scene;
	
	// private static final ControllerAdapter<GameControls> userInput = new
	// ControllerAdapter<>(ControllerFactory.buildMultiController());

	// private final SpriteBatch batch;

	public AbstractScreen(Stage window) {
		this.window = window;
		this.root = new Group();
		this.scene = new Scene(root, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
	}

	public Scene getScene() {
		return scene;
	}
}
