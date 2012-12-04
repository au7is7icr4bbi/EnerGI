/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Audio;

import javax.sound.midi.*;
import java.io.*;
import energi.Shared.*;

/**
 * Encapsulates a MIDI audio item usable by an instance of MidiPlayer. Useful for playing audio loops
 * @author andrew
 * @version 1.0
 */
public class MidiItem implements Playable
{
	private Sequence midiSequence;
	private String filename;
	private static Sequencer sequencer;

	/**
	 * Create an empty MidiItem object
	 * @throws EngineException
	 */
	public MidiItem() throws EngineException
	{
		if (sequencer == null)
		{
			try
			{
				sequencer = MidiSystem.getSequencer();
				sequencer.open();
			}
			catch (MidiUnavailableException e)
			{
				throw new EngineException("MIDI Sequencer error", ExceptionAction.EXIT, null);
			}
		}
	}

	/**
	 * Create a MIDI item object from a file
	 * @param f Filename
	 * @throws EngineException
	 */
	public MidiItem(String f) throws EngineException
	{
		if (sequencer == null)
		{
			try
			{
				sequencer = MidiSystem.getSequencer();
				sequencer.open();
			}
			catch (MidiUnavailableException e)
			{
				throw new EngineException("Sequencer error", ExceptionAction.EXIT, null);
			}
		}
		filename = f;
		init();
	}

	/**
	 * Play the MIDI file once
	 * @throws EngineException
	 */
	final public void play() throws EngineException
	{
		if (sequencer.isRunning())
		{
			sequencer.stop();
		}
		try
		{
			sequencer.setSequence(midiSequence);
		}
		catch (InvalidMidiDataException e)
		{
			throw new EngineException("Invalid MIDI sequence", ExceptionAction.EXIT, null);
		}
		sequencer.start();
	}

	/**
	 * Stop the MIDI file
	 */
	final public void stop()
	{
		sequencer.stop();
	}

	/**
	 * Loop the MIDI file
	 * @throws EngineException
	 */
	final public void playLoop() throws EngineException
	{
		play();
	}

	/**
	 * Generate the MIDI sequence for the MidiItem
	 * @throws EngineException
	 */
	private void init() throws EngineException
	{
		try
		{
			midiSequence = MidiSystem.getSequence(new File(filename));
		}
		catch (IOException e)
		{
			throw new EngineException("Content pipeline error: " + e.getMessage(), ExceptionAction.EXIT, null);
		}
		catch (InvalidMidiDataException e)
		{
			throw new EngineException("Invalid MIDI sequence", ExceptionAction.EXIT, null);
		}
	}

	/**
	 * Initialise the MIDI sequence
	 * @param f
	 * @throws EngineException
	 */
	final public void generateMusic(String f) throws EngineException
	{
		filename = f;
		init();
	}
}
