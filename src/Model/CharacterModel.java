package Model;

public class CharacterModel {
	private int x, hieght, width, timer;
	private double grav, jumpPow, y, currYVel, yStart, down;
	private boolean touchingGround, goingDown;

	public CharacterModel() {
		super();
		this.x = 100;
		this.yStart = 50.00;
		this.y = yStart;
		this.hieght = 50;
		this.width = 20;
		this.grav = 0.15;
		this.jumpPow = 7.3;
		this.currYVel = 0;
		this.touchingGround = false;
		this.timer = 0;
		this.down = -4;
	}

	public boolean isGoingDown() {
		return goingDown;
	}

	public void setGoingDown(boolean goingDown) {
		this.goingDown = goingDown;
	}

	public int getTimer() {
		return timer;
	}

	public void updateTimer() {
		this.timer++;
	}

	public void setTimer() {
		this.timer = 1;
	}

	public double getyStart() {
		return yStart;
	}

	public double getCurrYVel() {
		return currYVel;
	}

	public void setCurrYVel(double currYVel) {
		this.currYVel = currYVel;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean isTouchingGround() {
		return touchingGround;
	}

	public void setTouchingGround(boolean touchingGround) {
		this.touchingGround = touchingGround;
	}

	public int getX() {
		return x;
	}

	public int getHieght() {
		return hieght;
	}

	public int getWidth() {
		return width;
	}

	public double getGrav() {
		return grav;
	}

	public double getJumpPow() {
		return jumpPow;
	}

	public double getDown() {
		return down;
	}
}
