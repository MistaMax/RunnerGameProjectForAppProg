package Controller;

import Model.*;
import View.*;

public class OverallController {
	private GameKeyController keyController;
	private GameOverController gameOverController;
	private MenuButtonController menuButtonController;
	private CharacterController characterController;
	private RandomGenController randomGenController;
	private SoundController soundController;
	private LevelUpdateController levelController;
	private LeaderboardButtonController leaderBoardController;

	public OverallController(GameModel model, GameView view) {
		super();
		this.keyController = new GameKeyController(model, this);
		this.gameOverController = new GameOverController(model, view, this);
		this.menuButtonController = new MenuButtonController(model, view, this);
		this.characterController = new CharacterController(model, this);
		this.randomGenController = new RandomGenController(model);
		this.soundController = new SoundController(model);
		this.levelController = new LevelUpdateController(model, view, this);
		this.leaderBoardController = new LeaderboardButtonController(model, view);
	}

	public LeaderboardButtonController getLeaderBoardController() {
		return leaderBoardController;
	}

	public LevelUpdateController getLevelController() {
		return levelController;
	}

	public GameKeyController getKeyController() {
		return keyController;
	}

	public GameOverController getGameOverController() {
		return gameOverController;
	}

	public MenuButtonController getMenuButtonController() {
		return menuButtonController;
	}

	public CharacterController getCharacterController() {
		return characterController;
	}

	public RandomGenController getRandomGenController() {
		return randomGenController;
	}

	public SoundController getSoundController() {
		return soundController;
	}

}
