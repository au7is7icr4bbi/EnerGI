/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Core;

import energi.Core.GameObject;
import energi.Core.Game;
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
public class GameTest {

    public GameTest() {
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
	 * Test of init method, of class Game.
	 */
	@Test
	public void testInit()
	{
		System.out.println("init");
		Game instance = new GameImpl();
		GameObject entity = new Entity();
		instance.addObject(entity);
		try
		{
			instance.init();
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	/**
	 * Test of update method, of class Game.
	 */
	@Test
	public void testUpdate()
	{
		System.out.println("update");
		Game instance = new GameImpl();
		try
		{
			instance.update(20);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	/**
	 * Test of Draw method, of class Game.
	 */
	@Test
	public void testDraw() {
		System.out.println("Draw");
		Game instance = new GameImpl();
		try
		{
			instance.Draw(20);
		}
		catch (EngineException e)
		{
			e.printCause();
			e.handleException();
		}
	}

	public class GameImpl extends Game
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
				e.handleException();
			}
			System.out.println("Test successful");
		}

		@Override
		public void update(float delta)
		{
			try
			{
				super.update(delta);
			}
			catch (EngineException e)
			{
				e.printCause();
				e.handleException();
			}
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
				e.handleException();
			}
		}
	}

	public class GameObjectImpl implements GameObject
	{
		public void init()
		{
		}

		public void update(float delta)
		{
		}

		public void Draw(float delta)
		{
		}
	}

	public class Entity implements GameObject
	{
		private int entry;
		public Entity()
		{

		}
		public void init()
		{
			entry = 0;
		}

		public void update(float delta)
		{

		}

		public void Draw(float delta)
		{

		}
	}
}