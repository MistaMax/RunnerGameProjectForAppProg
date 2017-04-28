package Controller;

import java.awt.event.*;

import javax.swing.*;

import View.*;
import Model.*;

public class GameOverController implements ActionListener {

	private OverallController overallController;

	private GameView view;
	private GameModel model;
	private ScoreBoard scoreBoard;
	private Score score;

	public GameOverController(GameModel model, GameView view, OverallController c) {
		this.model = model;
		this.view = view;
		this.overallController = c;
		this.scoreBoard = model.getScoreBoard();
	}

	public void initGameOver() {
		System.out.println("you failed!");
		this.score = model.getCurrentScore();

		model.changeState(3);
		view.displayPanel(model.getState());

		// Popup must happen after Panel is switched, glitches if before
		if (!scoreBoard.isFull() || scoreBoard.getLowestScore() < score.getScore()) {
			String name = JOptionPane.showInputDialog(view, "Enter your name",
					Integer.toString(scoreBoard.getscores().size()));
			score.setName(name);
			if (name != null) {
				scoreBoard.addScore(score.getScore(), score.getName());
				overallController.getLeaderBoardController().writeScore(model.getScoreBoard().getScoreFile());
			}
		}
		try{
			Thread.sleep(50);
		} catch(Exception e){
			
		}
		view.displayPanel(model.getState());
		// Update display again in order to prevent glitch

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command == "Play Again") {
			(overallController.getLevelController()).reset();
			(model.getPlatModel()).addPlatform(0, 250, 1000);
			(overallController.getRandomGenController()).genRandSpace();
			(overallController.getLevelController()).updateLevel();

			model.changeState(1);
			view.displayPanel(model.getState());
		} else if (command == "Leaderboard") {
			view.showLeaderboard();
		} else if (command == "Main Menu") {
			model.changeState(0);
			view.displayPanel(model.getState());
		}
	}
}
