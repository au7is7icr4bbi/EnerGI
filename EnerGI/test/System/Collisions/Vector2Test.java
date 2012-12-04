/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Collisions;

import energi.Collisions.Vector2;
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
public class Vector2Test {

    public Vector2Test() {
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
	 * Test of setX method, of class Vector2.
	 */
	@Test
	public void testSetX() {
		System.out.println("setX");
		double xcoord = 0.0;
		Vector2 instance = new Vector2();
		instance.setX(xcoord);
		assertEquals(xcoord, instance.getX(), 0.0);
	}

	/**
	 * Test of setY method, of class Vector2.
	 */
	@Test
	public void testSetY() {
		System.out.println("setY");
		double ycoord = 0.0;
		Vector2 instance = new Vector2();
		instance.setY(ycoord);
		assertEquals(ycoord, instance.getY(), 0.0);
	}

	/**
	 * Test of getX method, of class Vector2.
	 */
	@Test
	public void testGetX() {
		System.out.println("getX");
		Vector2 instance = new Vector2();
		double expResult = 0.0;
		double result = instance.getX();
		assertEquals(expResult, result, 0.0);
	}

	/**
	 * Test of getY method, of class Vector2.
	 */
	@Test
	public void testGetY() {
		System.out.println("getY");
		Vector2 instance = new Vector2();
		double expResult = 0.0;
		double result = instance.getY();
		assertEquals(expResult, result, 0.0);
	}

	/**
	 * Test of isColliding method, of class Vector2.
	 */
	@Test
	public void testIsColliding() {
		System.out.println("isColliding");
		Vector2 otherPoint = new Vector2();
		Vector2 instance = new Vector2();
		boolean expResult = true;
		boolean result = instance.isColliding(otherPoint);
		assertEquals(expResult, result);
	}

}