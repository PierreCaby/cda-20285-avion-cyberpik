package cda.screens.menu;

import java.util.Arrays;
import java.util.List;

import cda.commons.Global;
import cda.commons.libs.MusicAsset;
import cda.commons.libs.VisualAsset;
import cda.game.SchmupApp;
import cda.screens.AbstractScreen;
import cda.screens.ScreenFactory;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

public class MenuScreen extends AbstractScreen {
	private static final String GAME_TITLE = "CYBERSHMUP";
	private VBox menuBox = new VBox(-5);
	private Line line;

	public MenuScreen(Stage window) {
		super(window);
		this.root = new Pane();
		this.scene = new Scene(createContent());
	}

	private List<Pair<String, Runnable>> menuData = Arrays.asList(
            new Pair<String, Runnable>("Single Player", () -> {
            	stopMusic();
            	AbstractScreen gamePlayScreen = ScreenFactory.createScreen(ScreenFactory.GAME_SCREEN, window);
            	SchmupApp.setGamePlayScreen(gamePlayScreen);
            	}
            ),
            new Pair<String, Runnable>("ScoreBoard", () -> {}),
            new Pair<String, Runnable>("Exit to Desktop", Platform::exit)
    );

	private Parent createContent() {
		addBackground();
		addTitle();
		playMusic(MusicAsset.STARTER_MENU);

		double lineX = Global.SCREEN_WIDTH / 2 - 100;
		double lineY = Global.SCREEN_HEIGHT / 3 + 50;

		addLine(lineX, lineY);
		addMenu(lineX + 5, lineY + 5);

		startAnimation();

		return root;
	}

	private void addBackground() {
		ImageView imageView = new ImageView(new Image(VisualAsset.SKY_BACKGROUND.getFilePath()));
		imageView.setFitWidth(Global.SCREEN_WIDTH);
		imageView.setFitHeight(Global.SCREEN_HEIGHT);

		root.getChildren().add(imageView);
	}

	private void addTitle() {
		Title title = new Title(GAME_TITLE);
		title.setTranslateX(Global.SCREEN_WIDTH / 2 - title.getTitleWidth() / 2);
		title.setTranslateY(Global.SCREEN_HEIGHT / 3);

		root.getChildren().add(title);
	}

	private void addLine(double x, double y) {
		line = new Line(x, y, x, y + 125);
		line.setStrokeWidth(3);
		line.setStroke(Color.color(1, 1, 1, 0.75));
		line.setEffect(new DropShadow(5, Color.BLACK));
		line.setScaleY(0);

		root.getChildren().add(line);
	}

	private void startAnimation() {
		ScaleTransition st = new ScaleTransition(Duration.seconds(1), line);
		st.setToY(1);
		st.setOnFinished(e -> {

			for (int i = 0; i < menuBox.getChildren().size(); i++) {
				Node n = menuBox.getChildren().get(i);

				TranslateTransition tt = new TranslateTransition(Duration.seconds(1 + i * 0.15), n);
				tt.setToX(0);
				tt.setOnFinished(e2 -> n.setClip(null));
				tt.play();
			}
		});
		st.play();
	}

	private void addMenu(double x, double y) {
		menuBox.setTranslateX(x);
		menuBox.setTranslateY(y);
		menuData.forEach(data -> {
			MenuItem item = new MenuItem(data.getKey());
			item.setOnAction(data.getValue());
			item.setTranslateX(-300);

			Rectangle clip = new Rectangle(300, 30);
			clip.translateXProperty().bind(item.translateXProperty().negate());

			item.setClip(clip);

			menuBox.getChildren().addAll(item);
		});

		root.getChildren().add(menuBox);
	}
}
