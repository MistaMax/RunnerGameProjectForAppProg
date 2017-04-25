package Controller;

import java.awt.event.*;
import Model.*;

public class GameKeyController implements KeyListener {
	private OverallController overallController;

	
	private GameModel model;

	public GameKeyController(GameModel model, OverallController c) {
		super();
		this.overallController = c;
		this.model = model;
	}

	/***************************************************************
	 * Implementation of KeyListener
	 **************************************************************/
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// jump
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W || key == KeyEvent.VK_SPACE) {
			overallController.getCharacterController().jump();
		}

		// pause
		else if (key == KeyEvent.VK_DOWN) {
			overallController.getCharacterController().down();
		} else if(key == KeyEvent.VK_P){
			model.switchPaused();
		}
	}

	public void keyReleased(KeyEvent e) {// just a test

	}

	public void keyTyped(KeyEvent e) {

	}

}
