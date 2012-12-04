/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Collisions;

/**
 * Represents a point on a grid. (0, 0) is the origin.
 * @author andrew
 * @version 1.0
 */
public class Vector2
{
	private double x;
	private double y;

	/**
	 * Create a point at the origin (0, 0)
	 */
	public Vector2()
	{
		x = 0.0;
		y = 0.0;
	}

	/**
	 * Create a point at a specific xy coordinate
	 * @param xcoord x coordinate
	 * @param ycoord y coordinate
	 */
	public Vector2(double xcoord, double ycoord)
	{
		x = xcoord;
		y = ycoord;
	}

	/**
	 * Sets the x coordinate of the point
	 * @param xcoord new x coordinate
	 */
	final public void setX(double xcoord)
	{
		x = xcoord;
	}

	/**
	 * Sets the y coordinate of the point
	 * @param ycoord new y coordinate
	 */
	final public void setY(double ycoord)
	{
		y = ycoord;
	}

	/**
	 * Returns the x coordinate
	 * @return x coordinate
	 */
	final public double getX()
	{
		return x;
	}

	/**
	 * Returns the y coordinate
	 * @return y coordinate
	 */
	final public double getY()
	{
		return y;
	}
	
	/**
	 * Get the direction the vector is facing as a unit vector
	 * @return The unit vector representing the vector's direction
	 */
	final public Vector2 getDirection()
	{
            float length = (float)Math.sqrt(x * x + y * y);
            Vector2 vec  = new Vector2(x / length, y / length);
            return vec;
	}

	/**
	 * Determines whether the point is colliding with another point
	 * @param otherPoint the other point
	 * @return true if colliding, otherwise false
	 * @see BoundingBox
	 * @see BoundingCircle
	 */
	final public boolean isColliding(Vector2 otherPoint)
	{
		if (x == otherPoint.x && y == otherPoint.y)
		{
			return true;
		}
		return false;
	}

	// don't need to test for collisions with bounding shapes; these are tested
	// by the bounding shapes themselved
}
