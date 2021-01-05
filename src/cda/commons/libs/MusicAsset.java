package cda.commons.libs;

import java.net.URISyntaxException;

/**
 * 
 * Get the musics from the assets.
 * 
 * @author Antoine
 *
 */

public enum MusicAsset {

	GAME("game.mp3"), 
	STARTER_MENU("starter-menu.mp3");

	private final String filePath;

	MusicAsset(String pFileName) {
		try {
			this.filePath = ClassLoader.getSystemResource("audio/game-music/" + pFileName).toURI().toString();
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e.getCause());
		}
	}

	public String getFilePath() {
		return filePath;
	}
}
