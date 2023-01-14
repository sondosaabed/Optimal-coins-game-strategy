package coins.game.application;
/*
 * Create a pick and set it's value, make it false
 */
public class Pick {
	//Attributes
	private int value;
	private boolean picked;

	public Pick(int value, boolean picked) {
		this.value=value;
		this.picked=false;
	}
	
	/*
	 * Getters and Setters
	 */
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isPicked() {
		return picked;
	}

	public void setPicked(boolean picked) {
		this.picked = picked;
	}
}