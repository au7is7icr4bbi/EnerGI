/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Audio;

import energi.Audio.Playable;
import energi.Shared.EngineException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for the Playable interface
 * @author andrew
 */
public class PlayableTest {

    public PlayableTest() {
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
	 * Test of play method, of class Playable.
	 */
	@Test
	public void testPlay()
	{
		System.out.println("play");
		Playable instance = new PlayableImpl();
		try
		{
			instance.play();
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	/**
	 * Test of stop method, of class Playable.
	 */
	@Test
	public void testStop()
	{
		System.out.println("stop");
		Playable instance = new PlayableImpl();
		instance.stop();
	}

	/**
	 * Test of playLoop method, of class Playable.
	 */
	@Test
	public void testPlayLoop()
	{
		System.out.println("playLoop");
		Playable instance = new PlayableImpl();
		try
		{
			instance.playLoop();
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	public class PlayableImpl implements Playable
	{
		public void play()
		{
			assertTrue(true);
		}

		public void stop()
		{
			assertTrue(true);
		}

		public void playLoop()
		{
			assertTrue(true);
		}
	}
}