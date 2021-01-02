package cda.actors.friendly;

import cda.screens.game.GamePlayScreen;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class ShipHandler {

	private static boolean up;
	private static boolean down;
	private static boolean left;
	private static boolean right;
	
	public static Ship shipMove() {
		Pane root = GamePlayScreen.getRoot();
		final double width = root.getScene().getWidth();
		final double height = root.getScene().getHeight();
		
		Ship ship = new Ship(64, 64, width/2, height/2, ShipView.SHIP.getImage(), 4, true, false, false, 5, 0);
		Ship.setShip(ship);
		Node nodeShip = ship.getNode();		



		root.getChildren().add(nodeShip);

		moveShipTo(nodeShip, width / 2, height / 2, width, height);

		root.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					up = true;
					break;
				case DOWN:
					down = true;
					break;
				case LEFT:
					left = true;
					break;
				case RIGHT:
					right = true;
					break;
				}
			}
		});

		root.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case UP:
					up = false;
					break;
				case DOWN:
					down = false;
					break;
				case LEFT:
					left = false;
					break;
				case RIGHT:
					right = false;
					break;
				}
			}
		});

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				int dx = 0, dy = 0;

				if (up)
					dy -= 4;
				if (down)
					dy += 4;
				if (left)
					dx -= 4;
				if (right)
					dx += 4;

				moveShipBy(nodeShip, dx, dy, width, height);
			}
		};
		timer.start();
		return ship;
	}

	private static void moveShipBy(Node pShip, int dx, int dy, double pWidth, double pHeight) {
		if (dx == 0 && dy == 0)
			return;

		final double cx = pShip.getBoundsInLocal().getWidth() / 2;
		final double cy = pShip.getBoundsInLocal().getHeight() / 2;

		double x = cx + pShip.getLayoutX() + dx;
		double y = cy + pShip.getLayoutY() + dy;

		moveShipTo(pShip, x, y, pWidth, pHeight);
	}

	private static void moveShipTo(Node pShip, double x, double y, double pWidth, double pHeight) {
		final double cx = pShip.getBoundsInLocal().getWidth() / 2;
		final double cy = pShip.getBoundsInLocal().getHeight() / 2;

		if (x - cx >= 0 && x + cx <= pWidth && y - cy >= 0 && y + cy <= pHeight) {
			pShip.relocate(x - cx, y - cy);
		}
	}

}
