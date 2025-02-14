package cda.actors.friendly;

import cda.commons.Global;
import cda.screens.game.GamePlayScreen;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * 
 * Ship movement handler with visual changing.
 * 
 * @author Antoine
 *
 */

public class ShipHandler {

	private static boolean up;
	private static boolean down;
	private static boolean left;
	private static boolean right;
	private static ImageView nodeShip;
	private final static double WIDTH = Global.SCREEN_WIDTH;
	private final static double HEIGHT = Global.SCREEN_HEIGHT;
	
	public static Ship shipMove() {
		// Set the direction to false to avoid problems of pressed keys when launching again the game;
		up = false;
		down = false;
		left = false;
		right = false;
		
		Pane root = GamePlayScreen.getRoot();
		final double height = root.getScene().getHeight();
		
		Ship ship = new Ship(WIDTH/2, height/2, 64, 64, ShipView.SHIP_NOREACTOR.getImage(), 4, true, false, false, 5, 0);
		Ship.setShip(ship);
		nodeShip = ship.getNode();	

		root.getChildren().add(nodeShip);

		moveShipTo(nodeShip, WIDTH / 2, height / 2, WIDTH, height);

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

		
		
		return ship;
	}

	public static void movehandler() {
		int dx = 0, dy = 0;

		if (up) {
			dy -= 5;
			nodeShip.setImage(ShipView.SHIP.getImage());
		} 
		if (down) {
			dy += 5;
			nodeShip.setImage(ShipView.SHIP.getImage());
		}
		if (left) {
			dx -= 5;
			nodeShip.setImage(ShipView.SHIP_LEFT.getImage());
		}
		if (right) {
			dx += 5;
			nodeShip.setImage(ShipView.SHIP_RIGHT.getImage());
		}
		if(!up && !down && !left && !right) {
			nodeShip.setImage(ShipView.SHIP_NOREACTOR.getImage());

		}

		moveShipBy(nodeShip, dx, dy, WIDTH, HEIGHT);
	}
		
	public static void moveShipBy(ImageView pShip, int px, int py, double pWidth, double pHeight) {
		if (px == 0 && py == 0)
			return;

		final double vx = pShip.getBoundsInLocal().getWidth() / 2;
		final double vy = pShip.getBoundsInLocal().getHeight() / 2;

		double x = vx + pShip.getLayoutX() + px;
		double y = vy + pShip.getLayoutY() + py;

		moveShipTo(pShip, x, y, pWidth, pHeight);
	}

	public static void moveShipTo(ImageView pShip, double px, double py, double pWidth, double pHeight) {
		final double vx = pShip.getBoundsInLocal().getWidth() / 2;
		final double vy = pShip.getBoundsInLocal().getHeight() / 2;

		if (px - vx >= 0 && px + vx <= pWidth && py - vy >= 0 && py + vy <= pHeight) {
			pShip.relocate(px - vx, py - vy);
		}
	}

}
