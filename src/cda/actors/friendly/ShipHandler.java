package cda.actors.friendly;

import cda.screens.game.GamePlayScreen;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class ShipHandler {

	private static boolean up;
	private static boolean down;
	private static boolean left;
	private static boolean right;
	private static Node nodeShip;
	
	public static Ship shipMove() {
		Pane root = GamePlayScreen.getRoot();
		final double width = root.getScene().getWidth();
		final double height = root.getScene().getHeight();
		
		Ship ship = new Ship(width/2, height/2, 64, 64, ShipView.SHIP.getImage(), 4, true, false, false, 5, 0);
		Ship.setShip(ship);
		nodeShip = ship.getNode();		



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
				default:
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
				default:
					break;					
				}
			}
		});

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				int dx = 0, dy = 0;

				if (up)
					dy -= 5;
				if (down)
					dy += 5;
				if (left)
					dx -= 5;
				if (right)
					dx += 5;

				moveShipBy(nodeShip, dx, dy, width, height);
			}
		};
		timer.start();
		return ship;
	}

	public static void moveShipBy(Node pShip, int px, int py, double pWidth, double pHeight) {
		if (px == 0 && py == 0)
			return;

		final double vx = pShip.getBoundsInLocal().getWidth() / 2;
		final double vy = pShip.getBoundsInLocal().getHeight() / 2;

		double x = vx + pShip.getLayoutX() + px;
		double y = vy + pShip.getLayoutY() + py;

		moveShipTo(pShip, x, y, pWidth, pHeight);
	}

	public static void moveShipTo(Node pShip, double px, double py, double pWidth, double pHeight) {
		final double vx = pShip.getBoundsInLocal().getWidth() / 2;
		final double vy = pShip.getBoundsInLocal().getHeight() / 2;

		if (px - vx >= 0 && px + vx <= pWidth && py - vy >= 0 && py + vy <= pHeight) {
			pShip.relocate(px - vx, py - vy);
		}
	}

}
