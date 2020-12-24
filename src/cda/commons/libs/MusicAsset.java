package cda.commons.libs;

public enum MusicAsset {

	GAME("game.mp3"),
	STARTER_MENU("starter-menu.mp3");

	private final String fileName;

	MusicAsset(String pFileName) {
		this.fileName = "assets/audio/game-music/" + pFileName;
	}

	public String getFileName() {
		return fileName;
	}

}
