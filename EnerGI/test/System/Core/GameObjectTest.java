/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Core;

import energi.Core.GameObject;
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
public class GameObjectTest {

    public GameObjectTest()
	{
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
	 * Test of init method, of class GameObject.
	 */
	@Test
	public void testInit()
	{
		System.out.println("init");
		GameObject instance = new GameObjectImpl();
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
	 * Test of update method, of class GameObject.
	 */
	@Test
	public void testUpdate()
	{
		System.out.println("update");
		GameObject instance = new GameObjectImpl();
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
	 * Test of Draw method, of class GameObject.
	 */
	@Test
	public void testDraw()
	{
		System.out.println("Draw");
		GameObject instance = new GameObjectImpl();
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

	class GameObjectImpl implements GameObject
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
}