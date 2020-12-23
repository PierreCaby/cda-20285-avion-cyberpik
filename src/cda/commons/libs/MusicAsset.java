package cda.commons.libs;

public enum MusicAsset {

	GAME("game.mp3"),
	STARTER_MENU("starter-menu.mp3");

	private final String fileName;

	MusicAsset(String pFileName) {
		this.fileName = "audio/game-music/";
	}

	public String getFileName() {
		return fileName;
	}

}
