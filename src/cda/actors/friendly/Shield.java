package cda.actors.friendly;

public class Shield {
	
	private boolean activated = false;
	
	public void activate() {
		this.activated = true;
	}
	
	public void deactivate() {
		this.activated = false;
	}
	
	public void shieldActivated() {
		
	}
	
}
