package Main;


import javax.swing.JFrame;

import Controller.*;
import Model.*;
import View.*;

public class Launcher {

	public static void main(String[] args) {
		GameModel model = new GameModel();
		GameView view = new GameView(model);
		OverallController controller = new OverallController(model,view);
		
		
		/*GameKeyController controller1 = new GameKeyController(model, view);
		GameMouseController controller2 = new GameMouseController(model, view);
		GameOverController controller3 = new GameOverController(model, view);
		MenuButtonController controller4 = new MenuButtonController(model, view);*/

		// register controller as the listener
		view.registerListener(controller);
		
		model.setMaxX(1600);
		model.setMaxY(500);
	
		// start it up
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 500);
		view.setResizable(false);
		view.setVisible(true);
	}

}
