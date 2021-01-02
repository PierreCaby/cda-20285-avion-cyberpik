package cda.commons.libs;

import java.io.File;

public enum MusicAsset {

	GAME("game.mp3"),
	STARTER_MENU("starter-menu.mp3");

	private final String filePath;

	MusicAsset(String pFileName) {
		this.filePath = new File("assets/audio/game-music/" + pFileName).toURI().toString();
	}

	public String getFilePath() {
		return filePath;
	}
}
