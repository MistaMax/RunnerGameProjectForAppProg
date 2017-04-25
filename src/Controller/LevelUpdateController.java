package Controller;

import View.*;
import Model.*;
import java.util.LinkedList;

/**
 * This moderately complicated class updates the level and moves the platforms
 * in both length and position as well as deleting them if they go to zero, this
 * class will also call the random generator to create more platforms if needed.
 * 
 * @author Max Crookshanks
 *
 */
public class LevelUpdateController {

	private OverallController overallController;
	private GameModel model;
	private GameView view;
	private PlatformModel pMod;
	private LevelModel lMod;
	private RandomModel rMod;

	/**
	 * The constructor for the level updater
	 * 
	 * @param model
	 * @param view
	 * @param c
	 */
	public LevelUpdateController(GameModel model, GameView view, OverallController c) {
		super();
		this.model = model;
		this.view = view;
		this.overallController = c;
		this.pMod = model.getPlatModel();
		this.lMod = model.getLevModel();
		this.rMod = model.getRandModel();
	}

	/**
	 * Updates the level
	 */
	public void updateLevel() {
		// This is the section to allow for delay
		try {
			Thread.sleep(lMod.getDelay());
		} catch (InterruptedException e) {
			return;
		}

		// this is the main section that determines which part of the platform
		// to move, this prioritizes getting the startX to zero then adjusts the
		// length according to the decay in the LevelModel
		// this will also remove the platform if it has run out of bounds or has
		// stopped at zero
		if (!model.isPaused()) {
			for (int i = 0; i < pMod.getSize(); i++) {
				if ((pMod.getPlatformAtIndex(i)).getStartX() < lMod.getDecay()
						&& (pMod.getPlatformAtIndex(i)).isNoStartXChange()) {
					pMod.getPlatformAtIndex(i).setLength((pMod.getPlatformAtIndex(i)).getStartX()
							+ (pMod.getPlatformAtIndex(i)).getLength() - lMod.getDecay());
					pMod.getPlatformAtIndex(i).setStartX(0);
					pMod.getPlatformAtIndex(i).setNoStartXChange(false);
				} else if (pMod.getPlatformAtIndex(i).getStartX() >= lMod.getDecay()) {
					pMod.getPlatformAtIndex(i).setStartX((pMod.getPlatformAtIndex(i)).getStartX() - lMod.getDecay());
				} else if (pMod.getPlatformAtIndex(i).getLength() > lMod.getDecay()) {
					pMod.getPlatformAtIndex(i).setLength((pMod.getPlatformAtIndex(i)).getLength() - lMod.getDecay());
				} else {
					pMod.removePlatformAtIndex(i);
				}
				// while the platforms are moving the extra space in the
				// prerender is moving as well at the same rate to allow for
				// perfect spaces to appear on the screen without delay
				if (rMod.getCurrentSpaceBetweenPlatforms() > lMod.getDecay()) {
					rMod.setCurrentSpaceBetweenPlatforms(rMod.getCurrentSpaceBetweenPlatforms() - lMod.getDecay());
				} else {
					rMod.setCurrentSpaceBetweenPlatforms(0);
				}
			}
			// randomly generates new platforms and spaces in the prerendered
			// area if the time has come
			if ((pMod.getPlatformAtIndex(pMod.getSize() - 1).getStartX()
					+ (pMod.getPlatformAtIndex(pMod.getSize() - 1)).getLength()
					+ rMod.getSpaceBetweenPlatforms()) < lMod.getPreRenderDist()) {
				(overallController.getRandomGenController()).genPlatforms();
			}
			overallController.getCharacterController().update();

			model.getCurrentScore().setScore(model.getCurrentScore().getScore() + model.getMult());
			if (model.getMult() < 10
					&& model.getCurrentScore().getScore() % (1000 * model.getMult() * model.getMult()) == 0) {
				model.setMult(model.getMult() + 1);
				model.getLevModel().setDecay(model.getLevModel().getDecay() + model.getMult());
			}
		}
		// loops this back to the beginning
		view.displayPanel(model.getState());
	}

	public void reset() {
		model.getCharModel().setCurrYVel(0);
		model.getCharModel().setTouchingGround(false);
		model.getCharModel().setY((model.getCharModel()).getyStart());
		model.getPlatModel().setPlatforms(new LinkedList<Platform>());
		model.newScore();
		model.getLevModel().setDecay(model.getLevModel().getDefaultDecay());
		model.setMult(1);
		model.setPaused(false);
	}

}
