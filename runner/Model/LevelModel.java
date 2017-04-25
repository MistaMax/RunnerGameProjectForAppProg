package Model;

public class LevelModel {
	private long delay; // in ms
	private int decay; // how many pixels will be lost per tick
	private int preRenderDist; // in pixels, when should the platforms be
								// generated
	private int defaultDecay = 6;

	public LevelModel() {
		super();
		this.delay = 10;
		this.decay = defaultDecay;
		this.preRenderDist = 1500;
	}

	public int getDefaultDecay() {
		return defaultDecay;
	}

	public int getPreRenderDist() {
		return preRenderDist;
	}

	public long getDelay() {
		return delay;
	}

	public int getDecay() {
		return decay;
	}

	public void setDecay(int decay) {
		this.decay = decay;
	}
	
	


}

