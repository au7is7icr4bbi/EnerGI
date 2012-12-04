/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Audio;

import org.newdawn.slick.openal.*;
import energi.Shared.*;
import org.newdawn.slick.util.ResourceLoader;
import java.io.*;

/**
 * Represents an audio item (Ogg Vorbis, WAVE or AIFF) for playback by the AudioPlayer class
 * @author andrew
 * @version 1.0
 */
public class AudioItem implements Playable
{
	private Audio audioEffect;
	private String filename;

	/**
	 * Default constructor
	 */
	public AudioItem()
	{
		audioEffect = null;
	}

	/**
	 * Pull the audio file from the content pipeline
	 * @throws EngineException
	 */
	private void init() throws EngineException
	{
		try
		{
			audioEffect = AudioLoader.getAudio(filename.substring(filename.length() - 3).toUpperCase(), ResourceLoader.getResourceAsStream(filename));
		}
		catch (IOException e)
		{
			throw new EngineException("Content pipeline error: " + e.getMessage(), ExceptionAction.EXIT, null);
		}
	}

	/**
	 * Generate the audio item (through the init() function)
	 * @param f Filename
	 * @throws EngineException
	 */
	final public void generateMusic(String f) throws EngineException
	{
		filename = f;
		init();
	}

	/**
	 * Play the audio file as a sound effect
	 */
	final public void play()
	{
		audioEffect.playAsSoundEffect(1.0f, 1.0f, false);
	}

	/**
	 * Stop the currently playing audio file
	 */
	final public void stop()
	{
		audioEffect.stop();
	}

	/**
	 * Play the audio file as music (ie. loop)
	 */
	final public void playLoop()
	{
		audioEffect.playAsMusic(1.0f, 1.0f, true);
	}
}
