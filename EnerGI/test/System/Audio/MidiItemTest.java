/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Audio;

import energi.Audio.MidiItem;
import energi.Shared.EngineException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrew
 */
public class MidiItemTest {

    public MidiItemTest() {
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
	 * Test of play method, of class MidiItem.
	 */
	@Test
	public void testPlay() {
		System.out.println("play");
		try
		{
			MidiItem instance = new MidiItem();
			instance.generateMusic("/home/andrew/Downloads/surfingalien.mid");
			instance.play();
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	/**
	 * Test of stop method, of class MidiItem.
	 */
	@Test
	public void testStop() {
		System.out.println("stop");
		MidiItem instance = null;
		try
		{
			instance = new MidiItem();
			instance.generateMusic("/home/andrew/Downloads/surfingalien.mid");
			instance.play();
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
		instance.stop();
	}

	/**
	 * Test of playLoop method, of class MidiItem.
	 */
	@Test
	public void testPlayLoop() {
		System.out.println("playLoop");
		MidiItem instance = null;
		try
		{
			instance = new MidiItem();
			instance.generateMusic("/home/andrew/Downloads/surfingalien.mid");
			instance.playLoop();
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	/**
	 * Test of generateMusic method, of class MidiItem.
	 */
	@Test
	public void testGenerateMusic()
	{
		System.out.println("generateMusic");
		String f = "/home/andrew/Downloads/surfingalien.mid";
		MidiItem instance = null;
		try
		{
			instance = new MidiItem();
			instance.generateMusic(f);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

}