package cda.commons.libs;

public enum SoundEffectAsset {

	EXPLOSION("explosion.wav"),
	LOST_GAME("lost-game.wav"),
	LOST_LIFE("lost-life.wav"),
	NEW_HIGHSCORE("new-highscore.wav"),
	SHIELD("shield.wav"),
	SHOT("shot.wav");

	private final String fileName;

	SoundEffectAsset(String pFileName) {
		this.fileName = "audio/sound-effect/";
	}

	public String getFileName() {
		return fileName;
	}
}
