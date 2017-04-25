package Controller;

import Model.*;
import View.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MenuButtonController implements ActionListener {

	private GameModel model;
	private GameView view;
	private OverallController overallController;

	public MenuButtonController(GameModel model, GameView view, OverallController c) {
		super();
		this.overallController = c;
		this.model = model;
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		if (command == "Start") {
			(overallController.getLevelController()).reset();
			(model.getPlatModel()).addPlatform(0, 250, 1000);
			(overallController.getRandomGenController()).genRandSpace();
			(overallController.getLevelController()).updateLevel();

			model.changeState(1);
			view.displayPanel(model.getState());
		} else if (command == "Options") {
			model.changeMenuState(1);
			view.displayPanel(model.getState());
		} else if (command == "Help") {
			JOptionPane.showMessageDialog(view, "The objective of the game is to survive as long as you can\n"
					+ "\nPress \"space\" to jump \nPress \"down key\" to accelerate down");
		} else if (command == "Back"){
			model.changeMenuState(0);
			view.displayPanel(model.getState());
		} else if (command == "Exit") {
		
			System.exit(0);
		}
	}
	
}