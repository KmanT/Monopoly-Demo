package cis.monopoly;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This class plays sounds whenever an action is made.
 * @author Kyle Turske
 * 
 * @version 1.0
 *
 */
public final class SoundPlayer {
	
	/**The base directory for the sound files.*/
	private static final String SOUND_DIR = "src/cis/monopoly/sounds/";
	
	/**Used in randomly selecting the dice sound.*/
	private static final int RAND_MIN = 1;
	/**Used in randomly selecting the dice sound.*/
	private static final int RAND_MAX = 4;
	
	/**
	 * Private constructor.
	 */
	private SoundPlayer() {
		
	}
	
	/**
	 * Plays a sound from a given file path.
	 * @param filePath The location of the audio file
	 * @throws IOException When there is something wrong with the sound file.
	 */
	public static void playSound(final String filePath) throws IOException {
		File file = new File(filePath);
		Media sound = new Media(file.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();		
	}
	
	/**
	 * Plays a "click" sound.
	 * @throws IOException When there is something wrong with the sound file.
	 */
	public static void playClick() throws IOException {
		String filePath = SOUND_DIR + "click.wav";
		playSound(filePath);
	}
	
	/**
	 * Plays a "dice roll" sound.
	 * @throws IOException When there is something wrong with the sound file.
	 */
	public static void playRoll() throws IOException {
		Random rand = new Random();
		int num = rand.nextInt(RAND_MAX - RAND_MIN) + RAND_MIN;
		String filePath = SOUND_DIR + "roll" + Integer.toString(num) + ".wav";
		playSound(filePath);
	}
	
	/**
	 * Plays a "ding" sound.
	 * @throws IOException When there is something wrong with the sound file.
	 */
	public static void playDing() throws IOException {
		String filePath = SOUND_DIR + "ding.wav";
		playSound(filePath);
	}
	
	/**
	 * Plays a "card flip" sound.
	 * @throws IOException When there is something wrong with the sound file.
	 */
	public static void playFlip() throws IOException {
		String filePath = SOUND_DIR + "flip.wav";
		playSound(filePath);
	}
	
	/**
	 * Plays a "wobble" sound.
	 * @throws IOException When there is something wrong with the sound file.
	 */
	public static void playWobble() throws IOException {
		String filePath = SOUND_DIR + "wobble.wav";
		playSound(filePath);
	}
}
