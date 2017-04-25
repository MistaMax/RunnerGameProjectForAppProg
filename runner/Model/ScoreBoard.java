package Model;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScoreBoard {
	private LinkedList<Score> scores;
	private String scoreFile;

	public ScoreBoard(String file) {
		scores = new LinkedList<Score>();
		scoreFile = file;
		importScoreFromFile();
	}

	public void importScoreFromFile() {
		Score tmp = new Score();
		Scanner scanScore;
		scanScore = new Scanner(scoreFile);
		while (scanScore.hasNextInt()) {
			tmp.setScore(scanScore.nextInt());
			if (scanScore.hasNext()) {
				tmp.setName(scanScore.next());
				addScore(tmp);
			} else
				break;
		}
		scanScore.close();
	}

	public void writeScore() {
		try {
			PrintWriter writer = new PrintWriter(scoreFile, "UTF-8");
			for (Score score : scores)
				writer.println(score.getScore() + " " + score.getName());
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

	public void addScore(Score nScore) {
		scores.add(nScore);
		scores.sort(null);
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
