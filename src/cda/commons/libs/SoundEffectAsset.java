package cda.commons.libs;

import java.net.URISyntaxException;

/**
 * 
 * Get the sound effects from the assets.
 * 
 * @author Antoine
 *
 */

public enum SoundEffectAsset {

	EXPLOSION("explosion.wav"),
	BONUS("shield.wav"),
	SHOT("shot.wav");

	private final String filePath;

	SoundEffectAsset(String pFileName) {
		try {
			this.filePath = ClassLoader.getSystemResource("audio/sound-effect/" + pFileName).toURI().toString();
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e.getCause());
		}
	}

	public String getFilePath() {
		return filePath;
	}
	
}
