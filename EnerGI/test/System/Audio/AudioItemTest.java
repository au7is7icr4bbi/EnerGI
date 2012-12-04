/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Audio;

import energi.Audio.AudioItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import energi.Shared.EngineException;

/**
 *
 * @author andrew
 */
public class AudioItemTest {

    public AudioItemTest() {
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
	 * Test of generateMusic method, of class AudioItem.
	 */
	@Test
	public void testGenerateMusic() {
		System.out.println("generateMusic");
		String f = "/home/andrew/Desktop/bell.wav";
		AudioItem instance = new AudioItem();
		try
		{
			instance.generateMusic(f);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	/**
	 * Test of play method, of class AudioItem.
	 */
	@Test
	public void testPlay() {
		System.out.println("play");
		String f = "/home/andrew/Desktop/bell.wav";
		AudioItem instance = new AudioItem();
		try
		{
			instance.generateMusic(f);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
		instance.play();
	}

	/**
	 * Test of stop method, of class AudioItem.
	 */
	@Test
	public void testStop() {
		System.out.println("stop");
		String f = "/home/andrew/Desktop/bell.wav";
		AudioItem instance = new AudioItem();
		try
		{
			instance.generateMusic(f);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
		instance.playLoop();
		instance.stop();
	}

	/**
	 * Test of playLoop method, of class AudioItem.
	 */
	@Test
	public void testPlayLoop()
	{
		System.out.println("playLoop");
		AudioItem instance = new AudioItem();
		try
		{
			instance.generateMusic("/home/andrew/Desktop/bell.wav");
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
		instance.playLoop();
	}

}