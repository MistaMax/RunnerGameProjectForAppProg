package Model;

import java.util.*;

public class ScoreBoard {
	private LinkedList<Score> scores;
	private String scoreFile;

	public ScoreBoard(String file) {
		scores = new LinkedList<Score>();
		scoreFile = file;
	}

	public String getScoreFile() {
		return scoreFile;
	}

	public void addScore(int s, String n) {
		Score nScore = new Score();
		nScore.setName(n);
		nScore.setScore(s);
		this.scores.addLast(nScore);
		String nm = null;
		int sr = 0;
		//*
		for (int i = 0; i < scores.size(); i++) {
			for (int j = 0; j < scores.size(); j++) {
				if (scores.get(i).getName().compareTo(scores.get(j).getName()) < 0) {
					nm = scores.get(i).getName();
					sr = scores.get(i).getScore();
					scores.get(i).setName(scores.get(j).getName());
					scores.get(i).setScore(scores.get(j).getScore());
					scores.get(j).setName(nm);
					scores.get(j).setScore(sr);
				}
			}
		}
		//*/
		for (int i = 0; i < scores.size(); i++) {
			for (int j = i; j < scores.size(); j++) {
				if (scores.get(j).getScore() > scores.get(i).getScore()) {
					nm = scores.get(i).getName();
					sr = scores.get(i).getScore();
					scores.get(i).setName(scores.get(j).getName());
					scores.get(i).setScore(scores.get(j).getScore());
					scores.get(j).setName(nm);
					scores.get(j).setScore(sr);
				}
			}
		}
		if (scores.size() > 10) {
			scores.removeLast();
		}

	}

	public Boolean isFull() {
		switch (scores.size()) {
		case 10:
			return true;
		default:
			return false;
		}
	}

	public LinkedList<Score> getscores() {
		return scores;
	}

	public int getLowestScore() {
		if (scores.isEmpty())
			return 0;
		return scores.getLast().getScore();
	}

}
