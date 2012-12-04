/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package System.Collisions;

import energi.Collisions.BoundingBox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import energi.Shared.Axis;
import energi.Collisions.Vector2;

/**
 *
 * @author andrew
 */
public class BoundingBoxTest {

    public BoundingBoxTest() {
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
	 * Test of isColliding method, of class BoundingBox.
	 */
	@Test
	public void testIsColliding_Point() {
		System.out.println("isColliding");
		Vector2 p = new Vector2();
		BoundingBox instance = new BoundingBox();
		boolean expResult = true;
		boolean result = instance.isColliding(p);
		assertEquals(expResult, result);
	}

	/**
	 * Test of isColliding method, of class BoundingBox.
	 */
	@Test
	public void testIsColliding_BoundingBox()
	{
		System.out.println("isColliding");
		BoundingBox instance = new BoundingBox(new Vector2(1.5, 1.5), 3, 3);
		BoundingBox otherBox = new BoundingBox();
		boolean expResult = true;
		boolean result = instance.isColliding(otherBox);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetCenter()
	{
		System.out.println("getCenter");
		BoundingBox instance = new BoundingBox();
		Vector2 expected = new Vector2(0.5, 0.5);
		Vector2 center = instance.getCenter();
		assertEquals(expected.getX(), center.getX(), 0.0);
		assertEquals(expected.getY(), center.getY(), 0.0);
	}
	
	@Test
	public void testMove()
	{
		System.out.println("Move");
		BoundingBox instance = new BoundingBox();
		instance.move(1, 1);
		Vector2 center = instance.getCenter();
		assertEquals(1.5, center.getX(), 0.0);
		assertEquals(1.5, center.getY(), 0.0);
	}
	
	@Test
	public void testRotate()
	{
		System.out.println("Rotate");
		BoundingBox instance = new BoundingBox();
		instance.rotate(Math.PI / 2.0, Axis.Y);
		Vector2 vertices[] = new Vector2[4];
		Vector2 expected[] = new Vector2[4];
		expected[0] = new Vector2(0, 0);
		expected[1] = new Vector2(0, 1);
		expected[2] = new Vector2(1, 0);
		expected[3] = new Vector2(1, 1);
		
		for (int i = 0; i < 4; i++)
		{
			assertEquals(expected[i].getX(), vertices[i].getX(), 0.0);
			assertEquals(expected[i].getY(), vertices[i].getY(), 0.0);
		}
	}
	
	@Test
	public void testScale()
	{
		System.out.println("Scale");
		BoundingBox instance = new BoundingBox(new Vector2(-0.5, -0.5), 1, 1);
		System.out.println(instance.getCenter().getX());
		System.out.println(instance.getCenter().getY());
		instance.scale(2, 2);
		Vector2 center = instance.getCenter();
		
		assertEquals(0.0, center.getX(), 0.0);
		assertEquals(0.0, center.getY(), 0.0);
	}
}