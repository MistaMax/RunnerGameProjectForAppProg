package Model;

public class GameModel {

	private int maxX, maxY;
	private int state;
	private int menuState;
	private int leaderboardState;
	private int multiplier;
	private boolean paused;
	private CharacterModel charModel;
	private LevelModel levModel;
	private PlatformModel platModel;
	private RandomModel randModel;
	private SoundModel soundModel;
	private Score currentScore;
	private ScoreBoard scoreBoard;

	public GameModel() {
		this.maxX = 100;
		this.maxY = 100;
		this.state = 0;
		this.menuState = 0;
		this.multiplier = 1;
		this.charModel = new CharacterModel();
		this.levModel = new LevelModel();
		this.platModel = new PlatformModel();
		this.randModel = new RandomModel();
		this.soundModel = new SoundModel();
		this.scoreBoard = new ScoreBoard("high_scores.txt");
		this.paused = false;
	}

	public CharacterModel getCharModel() {
		return charModel;
	}

	public LevelModel getLevModel() {
		return levModel;
	}

	public PlatformModel getPlatModel() {
		return platModel;
	}

	public RandomModel getRandModel() {
		return randModel;
	}

	public SoundModel getSoundModel() {
		return soundModel;
	}

	public Score getCurrentScore() {
		return currentScore;
	}

	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}

	public void newScore() {
		this.currentScore = new Score();
		this.currentScore.setScore(0);
	}

	public void changeState(int newState) {
		this.state = newState;
	}

	public int getState() {
		return this.state;
	}

	public void changeMenuState(int newState) {
		this.menuState = newState;
	}

	public int getMenuState() {
		return this.menuState;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public void setMult(int m) {
		this.multiplier = m;
	}

	public int getMult() {
		return this.multiplier;
	}
	
	public int getLeaderboardState(){
		return leaderboardState;
	}
	
	public void setLeaderboardState(int s){
		this.leaderboardState = s;
	}

	public boolean isPaused() {
		return paused;
	}
	
	public void switchPaused(){
		this.paused = !(this.paused);
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
