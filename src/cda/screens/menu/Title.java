package cda.screens.menu;

import cda.commons.libs.FontAsset;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Title extends Pane {
	private Text text;

	public Title(String name) {
		String spreadName = name.replaceAll("\\B|\\b", " "); // put space for each character (including original spaces)

		text = new Text(spreadName);
		text.setFont(Font.loadFont(FontAsset.FIVE_BY_FIVE.getFilePath(), 48));
		text.setFill(Color.WHITE);
		text.setEffect(new DropShadow(30, Color.BLACK));

		getChildren().addAll(text);
	}

	public double getTitleWidth() {
		return text.getLayoutBounds().getWidth();
	}

	public double getTitleHeight() {
		return text.getLayoutBounds().getHeight();
	}
}
