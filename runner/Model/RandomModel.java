package Model;

public class RandomModel {
	private double range;
	private double decRatio;
	private double maxSpaceBetweenPlatforms, minSpaceBetweenPlatforms;
	private int currentSpaceBetweenPlatforms, spaceBetweenPlatforms, minLength, maxLength, maxHeightDiff;
	private int genRange;

	public RandomModel() {
		super();
		this.range = 30.00;
		this.decRatio = 0.50;
		this.maxSpaceBetweenPlatforms = 200.00;
		this.minSpaceBetweenPlatforms = 50.00;
		this.currentSpaceBetweenPlatforms = 0;
		this.spaceBetweenPlatforms = 0;
		this.maxHeightDiff = 70;
		this.minLength = 70;
		this.maxLength = 400;
		this.genRange = 50;
	}
	
	public int getGenRange() {
		return genRange;
	}

	public int getSpaceBetweenPlatforms() {
		return spaceBetweenPlatforms;
	}

	public void setSpaceBetweenPlatforms(int spaceBetweenPlatforms) {
		this.spaceBetweenPlatforms = spaceBetweenPlatforms;
	}

	public int getMaxHeightDiff() {
		return maxHeightDiff;
	}

	public void setMaxHeightDiff(int maxHeightDiff) {
		this.maxHeightDiff = maxHeightDiff;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public void setMinSpaceBetweenPlatforms(double minSpaceBetweenPlatforms) {
		this.minSpaceBetweenPlatforms = minSpaceBetweenPlatforms;
	}

	public int getCurrentSpaceBetweenPlatforms() {
		return currentSpaceBetweenPlatforms;
	}

	public void setCurrentSpaceBetweenPlatforms(int currentSpaceBetweenPlatforms) {
		this.currentSpaceBetweenPlatforms = currentSpaceBetweenPlatforms;
	}

	public double getMinSpaceBetweenPlatforms() {
		return minSpaceBetweenPlatforms;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public double getMaxSpaceBetweenPlatforms() {
		return maxSpaceBetweenPlatforms;
	}

	public void setMaxSpaceBetweenPlatforms(double maxSpaceBetweenPlatforms) {
		this.maxSpaceBetweenPlatforms = maxSpaceBetweenPlatforms;
	}

	public double getDecRatio() {
		return decRatio;
	}
	
	
}
