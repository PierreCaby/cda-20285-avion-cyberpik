package cda.screens;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class AbstractScreen {
	protected Stage window;
	protected Pane root;
	protected Scene scene;
	
	// private static final ControllerAdapter<GameControls> userInput = new
	// ControllerAdapter<>(ControllerFactory.buildMultiController());

	// private final SpriteBatch batch;

	public AbstractScreen(Stage window) {
		this.window = window;
	}

	public Scene getScene() {
		return scene;
	}

	public Pane getRoot() {
		return root;
	}
}
