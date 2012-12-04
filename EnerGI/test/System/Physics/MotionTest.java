/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Physics;

import energi.Physics.Motion;
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
public class MotionTest {

    public MotionTest() {
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
	 * Test of staticHorizontalMotion method, of class Motion.
	 */
	@Test
	public void testStaticHorizontalMotion() {
		System.out.println("staticHorizontalMotion");
		Vector2 startPoint = new Vector2();
		double velocity = 1.0;
		Vector2 expResult = new Vector2(1, 0);
		Vector2 result = new Motion().staticHorizontalMotion(startPoint, velocity, 1);
		assertEquals(true, expResult.getX() == result.getX());
		assertEquals(true, expResult.getY() == result.getY());
	}

	/**
	 * Test of staticVerticalMotion method, of class Motion.
	 */
	@Test
	public void testStaticVerticalMotion() {
		System.out.println("staticVerticalMotion");
		Vector2 startPoint = new Vector2();
		double velocity = 1.0;
		Vector2 expResult = new Vector2(0, 1);
		Vector2 result = new Motion().staticVerticalMotion(startPoint, velocity, 1);
		assertEquals(true, expResult.getX() == result.getX());
		assertEquals(true, expResult.getY() == result.getY());
	}

	/**
	 * Test of dynamicVerticalMotion method, of class Motion.
	 */
	@Test
	public void testDynamicVerticalMotion() {
		System.out.println("dynamicVerticalMotion");
		Vector2 startPoint = new Vector2();
		double velocity = 10.0;
		Vector2 expResult = new Vector2(0, 15.0);
		Vector2 result = new Motion().dynamicVerticalMotion(startPoint, velocity, 1);
		assertEquals(true, expResult.getX() == result.getX());
		assertEquals(true, expResult.getY() == result.getY());
	}
	
	@Test
	public void testChaining()
	{
		System.out.println("Velocity/angle chaining");
		Vector2 startPoint = new Vector2();
		Motion newInstance = new Motion();
                newInstance.reset();
		double velocity = 10.0;
		double expectedVResult = 7.6; // expected result for final velocity
		newInstance.dynamicVerticalMotion(startPoint, velocity, 1);
		assertEquals(expectedVResult, newInstance.getCurrentVelocity(), 0.5);
	}

}