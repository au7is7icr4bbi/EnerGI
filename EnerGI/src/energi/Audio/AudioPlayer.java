/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Audio;
import energi.Shared.EngineException;

/**
 * Shared class that manages audio playback over the entire application
 * @author andrew
 * @version 1.0
 */
public class AudioPlayer
{
	private static Playable soundEffect;
	private static Playable loopingMusic;
	private static boolean isPlaying;

	/**
	 * Play a one-off sound effect
	 * @param s Sound effect
	 * @throws EngineException
	 */
	public static void play(Playable s) throws EngineException
	{
		soundEffect = s;
		isPlaying = true;
		soundEffect.play();
	}
	
	public static boolean isPlaying()
	{
		return isPlaying;
	}

	/**
	 * Stop the currently playing audio loop
	 */
	public static void stop()
	{
		isPlaying = false;
		loopingMusic.stop();
	}

	/**
	 * Restart the looping audio
	 * @throws EngineException
	 */
	public static void restartLoop() throws EngineException
	{
		loopingMusic.playLoop();
	}

	/**
	 * Begin looping a playable item
	 * @param loop The playable item to loop
	 * @throws EngineException
	 */
	public static void playLoop(Playable loop) throws EngineException
	{
		loopingMusic = loop;
		loopingMusic.playLoop();
		isPlaying = true;
	}
}
