/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Graphics;

import energi.Graphics.Sprite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import energi.Core.*;
import energi.Shared.*;

/**
 *
 * @author andrew
 */
public class SpriteTest {

    public SpriteTest() {
    }

	@BeforeClass
	public static void setUpClass() throws Exception
	{
		// set up the GL view
		GameTest test = new GameTest();
		test.init();
	}

	@AfterClass
	public static void tearDownClass() throws Exception
	{
		
	}

    @Before
    public void setUp()
	{
    }

    @After
    public void tearDown() {
    }

	/**
	 * Test of Draw method, of class Sprite.
	 */
	@Test
	public void testDraw()
	{
		// This test displays an image on the screen
		System.out.println("Draw");
		Sprite instance = null;
		try	
		{
			instance = new Sprite("/home/andrew/Downloads/pic.jpg");
		}
		catch (EngineException e)
		{
			e.printCause();
			e.printStackTrace();
		}
		instance.Draw();
		assertNotNull(instance);
	}
}

// subclass of Game created solely to initialise OpenGL and run core GL functionality
class GameTest extends Game
{
	@Override
	public void init()
	{
		try
		{
			super.init();
		}
		catch (EngineException e)
		{
			e.printCause();
			e.printStackTrace();
		}
	}

	@Override
	public void update(float delta)
	{

	}

	@Override
	public void Draw(float delta)
	{
		try
		{
			super.Draw(delta);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.printStackTrace();
		}
	}
}