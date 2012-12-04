/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Audio;

import energi.Audio.Playable;
import energi.Audio.MidiItem;
import energi.Audio.AudioPlayer;
import energi.Shared.EngineException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for the AudioPlayer class
 * @author andrew
 * @version 1.0
 */
public class AudioPlayerTest {

    public AudioPlayerTest() {
    }

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

	/**
	 * Test of play method, of class AudioPlayer.
	 */
	@Test
	public void testPlay()
	{
		System.out.println("play");
		try
		{
			Playable s = new MidiItem("/home/andrew/Downloads/surfingalien.mid");
			AudioPlayer.play(s);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	/**
	 * Test of stop method, of class AudioPlayer.
	 */
	@Test
	public void testStop()
	{
		System.out.println("stop");
		try
		{
			Playable s = new MidiItem("/home/andrew/Downloads/surfingalien.mid");
			AudioPlayer.playLoop(s);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
		AudioPlayer.stop();
	}

	/**
	 * Test of restartLoop method, of class AudioPlayer.
	 */
	@Test
	public void testRestartLoop()
	{
		System.out.println("restartLoop");
		try
		{
			Playable s = new MidiItem("/home/andrew/Downloads/surfingalien.mid");
			AudioPlayer.playLoop(s);
			AudioPlayer.stop();
			AudioPlayer.restartLoop();
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	/**
	 * Test of playLoop method, of class AudioPlayer.
	 */
	@Test
	public void testPlayLoop()
	{
		System.out.println("playLoop");
		try
		{
			Playable loop = new MidiItem("/home/andrew/Downloads/surfingalien.mid");
			AudioPlayer.playLoop(loop);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}
}