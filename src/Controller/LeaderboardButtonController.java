package Controller;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.LinkedList;

import Model.*;
import View.*;

public class LeaderboardButtonController implements ActionListener {
	private GameModel model;
	private GameView view;

	public LeaderboardButtonController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
		importScoreFromFile(model.getScoreBoard().getScoreFile());
	}

	public void importScoreFromFile(String scoreFile) {
		System.out.println(scoreFile);
		int s = 0;
		String n = null;
		Scanner scanScore = null;
		try {
			scanScore = new Scanner(new File(scoreFile));
			while (scanScore.hasNextInt()) {
				s = scanScore.nextInt();
				System.out.println(s);
				n = scanScore.next();
				System.out.println(n);
				model.getScoreBoard().addScore(s,n);
			}
			scanScore.close();
			for(Score score : model.getScoreBoard().getscores())
				System.out.println(score.getScore() + " " + score.getName());
		} catch (Exception e) {
			System.out.println("git rekt!");
		}
		writeScore(scoreFile);
	}

	public void writeScore(String scoreFile) {
		try {
			PrintWriter writer = new PrintWriter(scoreFile, "UTF-8");
			LinkedList<Score> score = model.getScoreBoard().getscores();
			for (int i=0;i<score.size();i++){
				writer.println(score.get(i).getScore() + " " + score.get(i).getName());
			}
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand().toLowerCase();
		if (cmd == "back") {
			view.displayPanel(model.getState());
		}
	}

}
