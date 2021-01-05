package cda.commons.libs;

import java.net.URISyntaxException;

/**
 * 
 * Get the font from the assets.
 * 
 * @author Antoine
 *
 */

public enum FontAsset {

	FIVE_BY_FIVE("five-by-five.ttf");
	
	private final String filePath;

	FontAsset(String pFileName) {
		try {
			this.filePath = FontAsset.class.getResource("/font/" + pFileName).toURI().toString();
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e.getCause());
		}
	}

	public String getFilePath() {
		return filePath;
	}
	
}
