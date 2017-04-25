package Model;

import java.util.LinkedList;
/**
 * Contains the data of all the platforms
 * @author Max Crookshanks
 *
 */
public class PlatformModel {
	private LinkedList<Platform> platforms;
	private int errSpace;

	public PlatformModel() {
		this.platforms = new LinkedList<Platform>();
		this.errSpace = 20;
	}
	
	public int getErrSpace() {
		return errSpace;
	}

	public int getSize(){
		return platforms.size();
	}
	
	public void removePlatformAtIndex(int i){
		platforms.remove(i);
	}

	public Platform getPlatformAtIndex(int i){
		return platforms.get(i);
	}
	
	public LinkedList<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(LinkedList<Platform> platforms) {
		this.platforms = platforms;
	}
	
	public void addPlatform(int x, int y, int length){
		Platform newPlatform = new Platform(length, x, y);
		platforms.addLast(newPlatform);
	}
}
