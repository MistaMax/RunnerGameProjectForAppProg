package Model;

import java.io.File;

public class SoundModel {
	private File jumpSound;

	public SoundModel() {
		super();
		jumpSound = new File("jump.wav");
	}

	public File getJumpSound() {
		return jumpSound;
	}

}
