package Controller;

import java.awt.event.*;
import Model.*;
import View.*;

public class LeaderboardButtonController implements ActionListener {
	private GameModel model;
	private GameView view;
	
	
	public LeaderboardButtonController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand().toLowerCase();
		if(cmd == "back"){
			view.displayPanel(model.getState());
		}
	}

}
