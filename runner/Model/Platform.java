package Model;
/**
 * A platform to run on
 * @author Max Crookshanks
 *
 */
public class Platform {
	private int length;
	private int startX;
	private int startY;
	private boolean noStartXChange;
	
	public Platform(){
		super();
		this.length = 500;
		this.startX = 0;
		this.startY = 0;
	}

	public Platform(int length, int startX, int startY) {
		super();
		this.length = length;
		this.startX = startX;
		this.startY = startY;
		this.noStartXChange = true;
	}

	public boolean isNoStartXChange() {
		return noStartXChange;
	}

	public void setNoStartXChange(boolean noStartXChange) {
		this.noStartXChange = noStartXChange;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}
}
