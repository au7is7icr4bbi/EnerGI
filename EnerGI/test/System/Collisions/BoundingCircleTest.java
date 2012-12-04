/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Collisions;

import energi.Collisions.BoundingBox;
import energi.Collisions.BoundingCircle;
import energi.Collisions.Vector2;
import energi.Shared.Axis;
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
public class BoundingCircleTest {

    public BoundingCircleTest() {
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
	 * Test of isColliding method, of class BoundingCircle.
	 */
	@Test
	public void testIsColliding_Point() {
		System.out.println("isColliding");
		Vector2 otherPoint = new Vector2();
		BoundingCircle instance = new BoundingCircle();
		boolean expResult = true;
		boolean result = instance.isColliding(otherPoint);
		assertEquals(expResult, result);
	}

	/**
	 * Test of isColliding method, of class BoundingCircle.
	 */
	@Test
	public void testIsColliding_BoundingCircle() {
		System.out.println("isColliding");
		BoundingCircle circle = new BoundingCircle(new Vector2(1, 0), 1);
		BoundingCircle instance = new BoundingCircle();
		boolean expResult = true;
		boolean result = instance.isColliding(circle);
		assertEquals(expResult, result);
	}

	/**
	 * Test of isColliding method, of class BoundingCircle.
	 */
	@Test
	public void testIsColliding_BoundingBox()
	{
		System.out.println("isColliding");
		BoundingBox box = new BoundingBox();
		BoundingCircle instance = new BoundingCircle();
		boolean expResult = true;
		boolean result = instance.isColliding(box);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testMove()
	{
		System.out.println("Move");
		BoundingCircle circle = new BoundingCircle();
		Vector2 expected = new Vector2(1, 1);
		circle.move(1, 1);
		assertEquals(expected.getX(), circle.getCenter().getX(), 0.0);
		assertEquals(expected.getY(), circle.getCenter().getY(), 0.0);
	}
	
	@Test
	public void testRotate()
	{
		System.out.println("Rotate");
		BoundingCircle circle = new BoundingCircle();
		double expected = 90.0;
		circle.rotate(90, Axis.X);
		//assertEquals(expected, circle.getCenter().getDirection(), 0.0);
	}
	
	@Test
	public void testScale()
	{
		System.out.println("Scale");
		BoundingCircle circle = new BoundingCircle();
		double expected = 2.0;
		circle.scale(2, 2);
		assertEquals(expected, circle.getRadius(), 0.0);
	}

}