package Controller;

import Model.*;

public class CharacterController {

	private OverallController overallController;
	private CharacterModel chMod;
	private PlatformModel pMod;

	public CharacterController(GameModel model, OverallController c) {
		super();
		this.overallController = c;
		this.chMod = model.getCharModel();
		this.pMod = model.getPlatModel();
	}

	public void update() {
		boolean platFound = false;
		if (chMod.getCurrYVel() != 0) {
			chMod.setY(chMod.getY() - chMod.getCurrYVel());
			chMod.setCurrYVel(chMod.getCurrYVel() - chMod.getGrav());
		}
		for (Platform platforms : pMod.getPlatforms()) {
			int highRangePlatX = platforms.getStartX() + platforms.getLength();
			int highRangeCharX = chMod.getX() + chMod.getWidth();
			int highRangeCharY = (int) chMod.getY() + chMod.getHieght();

			if (highRangeCharX >= platforms.getStartX() && highRangePlatX >= chMod.getX()) {
				platFound = true;
				if (highRangeCharY == platforms.getStartY()) {
					chMod.setTouchingGround(true);
					chMod.setGoingDown(false);
				} else if ((highRangeCharY >= platforms.getStartY()
						&& highRangeCharY <= platforms.getStartY() + pMod.getErrSpace())) {
					chMod.setY(platforms.getStartY() - chMod.getHieght());
					chMod.setCurrYVel(0);
				} else if (platforms.getStartY() + pMod.getErrSpace() < highRangeCharY) {
					(overallController.getGameOverController()).initGameOver();
				} else {
					chMod.setTouchingGround(false);
					chMod.setY(chMod.getY() - chMod.getCurrYVel());
					chMod.setCurrYVel(chMod.getCurrYVel() - chMod.getGrav());
				}
				break;
			}
		}

		if (!(platFound)) {
			chMod.setTouchingGround(false);
			chMod.setY(chMod.getY() - chMod.getCurrYVel());
			chMod.setCurrYVel(chMod.getCurrYVel() - chMod.getGrav());
		}

	}

	public void jump() {
		if (chMod.isTouchingGround()) {
			chMod.setCurrYVel(chMod.getJumpPow());
			chMod.setTouchingGround(false);
			overallController.getSoundController().playJumpSound();
		}
		
	}
	public void down() {
		if (!chMod.isTouchingGround() && !chMod.isGoingDown()) {
			chMod.setGoingDown(true);
			chMod.setCurrYVel(chMod.getDown());
		}
		
	}
}
