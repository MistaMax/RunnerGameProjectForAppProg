package Controller;

import java.util.Random;
import Model.*;
/**
 * This moderately complicated class controls the random generation of objects used in the game
 * @author Max Crookshanks
 *
 */
public class RandomGenController {
	
	private GameModel gMod;
	private RandomModel rMod;
	private PlatformModel pMod;
	private Random r;
	/**
	 * the constructor setting up all the models used and initiating the random object
	 * @param model
	 */
	public RandomGenController(GameModel model) {
		super();
		this.gMod = model;
		this.rMod = model.getRandModel();
		this.pMod = model.getPlatModel();
		this.r = new Random();
	}
	/**
	 * This code Randomly generates the platforms
	 */
	public void genPlatforms(){
		int x, y, length;
		y = 0;
		x = 0;
		length = 0;
		//just using certain algorithms based on the random model to generate random integers
		boolean cont = true;
		while(cont){
			y = (pMod.getPlatformAtIndex(pMod.getSize() - 1)).getStartY() - rMod.getMaxHeightDiff() + r.nextInt(rMod.getMaxHeightDiff() * 2);
			if(y <= (gMod.getMaxY() - rMod.getGenRange()) && y >= rMod.getGenRange())
				cont = false;
		}
		length = rMod.getMinLength() + r.nextInt(rMod.getMaxLength() - rMod.getMinLength());
		x = rMod.getSpaceBetweenPlatforms() + (pMod.getPlatformAtIndex(pMod.getSize() - 1)).getStartX() + (pMod.getPlatformAtIndex(pMod.getSize() - 1)).getLength();
		//generates the platform
		pMod.addPlatform(x, y, length);
		//generates the random space between the latest platform and null
		genRandSpace();
	}
	/**
	 * This code randomly generates the spaces in between the platforms
	 */
	public void genRandSpace(){
		rMod.setSpaceBetweenPlatforms((int) (rMod.getMinSpaceBetweenPlatforms()) + r.nextInt((int) (rMod.getMaxSpaceBetweenPlatforms() - rMod.getMinSpaceBetweenPlatforms())));
		rMod.setCurrentSpaceBetweenPlatforms(rMod.getSpaceBetweenPlatforms());
	}
	
}
