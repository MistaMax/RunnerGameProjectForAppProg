package Controller;

import Model.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class SoundController {
	private SoundModel sMod;

	public SoundController(GameModel model) {
		super();
		this.sMod = model.getSoundModel();
	}
	
	//plays sound based on file
	public static synchronized void playSound(File sound) {
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);

			Clip clip = AudioSystem.getClip();

			clip.open(audioIn);
			FloatControl gainControl = 
				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10.0f);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playJumpSound() {
		playSound(sMod.getJumpSound());
	}
}
