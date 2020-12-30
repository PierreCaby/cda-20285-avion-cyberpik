package cda.commons.libs;

import java.io.File;

public enum FontAsset {

	FIVE_BY_FIVE("five-by-five.ttf");
	
	private final String filePath;

	FontAsset(String pFileName) {
		this.filePath = new File("assets/font/" + pFileName).toURI().toString();
	}

	public String getFilePath() {
		return filePath;
	}
	
}
