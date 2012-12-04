/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Collisions;
import energi.Shared.Axis;

/**
 * Represents a box boundary around a game object
 * @author Andrew Pigram
 * @version 1.0
 */
public class BoundingBox implements Movable
{
	private Vector2 center;
	private double width;
	private double height;

	/**
	 * Creates a 1x1 bounding box for collision detection
	 */
	public BoundingBox()
	{
		center = new Vector2(0.0, 0.0);
		width = 1.0;
		height = 1.0;
	}

	/**
	 * Creates a bounding box for collision detection based on a center point, height and width
	 * @param centerX the x coordinate of the center point
	 * @param centerY the y coordinate of the center point
	 * @param w Width
	 * @param h Height
	 */
	public BoundingBox(double centerX, double centerY, double w, double h)
	{
		center = new Vector2(centerX, centerY);
		width = w;
		height = h;
	}
	/**
	 * Creates a bounding box for collision detection based on a supplied center point, width and height
	 * @param c Center point
	 * @param w Width
	 * @param h Height
	 */
	public BoundingBox(Vector2 c, double w, double h)
	{
		center = c;
		width = w;
		height = h;
	}

	/**
	 * Tests for a collision between the bounding box and a point on the grid
	 * @param p the point to test
	 * @return true if point is within the x and y range of the bounding box, otherwise false
	 */
	final public boolean isColliding(Vector2 p)
	{
		if (p.getX() >= center.getX() - (width / 2.0) && p.getX() <= center.getX() + (width / 2.0))
		{
			if (p.getY() <= center.getY() + (height / 2.0) && p.getY() >= center.getY() - (height / 2.0))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Tests for a collision between the bounding box and another bounding box
	 * @param otherBox the bounding box to test
	 * @return true if box boundaries are within the range of the bounding box, otherwise false
	 * @see #isColliding(energi.Collisions.Vector2)
	 */
	final public boolean isColliding(BoundingBox otherBox)
	{
		if (isColliding(new Vector2(otherBox.getCenter().getX() - (width / 2.0), otherBox.getCenter().getY() + (height / 2.0))))
		{
			return true;
		}
		if (isColliding(new Vector2(otherBox.getCenter().getX() + (width / 2.0), otherBox.getCenter().getY() - (height / 2.0))))
		{
			return true;
		}
		if (isColliding(new Vector2(otherBox.getCenter().getX() + (width / 2.0), otherBox.getCenter().getY() + (height / 2.0))))
		{
			return true;
		}
		if (isColliding(new Vector2(otherBox.getCenter().getX() - (width / 2.0), otherBox.getCenter().getY() - (height / 2.0))))
		{
			return true;
		}
		return false;
	}

	/**
	 * Move the BoundingBox
	 * @param x The x-axis distance
	 * @param y The y-axis distance
	 */
	@Override
	final public void move(double x, double y)
	{
		center.setX(center.getX() + x);
		center.setY(center.getY() + y);
	}

	/**
	 * Rotate the BoundingBox around the supplied axis.
	 * @param angle The angle of rotation
	 * @param axis The rotation axis
	 */
	@Override
	final public void rotate(double angle, Axis axis)
	{
		//center.setDirection(angle);
	}

	/**
	 * Scale up the BoundingBox dimensions. This implementation currently only allows positive scaling
	 * @param x The horizontal scale factor
	 * @param y The vertical scale factor
	 */
	@Override
	final public void scale(double x, double y)
	{
		width *= x;
		height *= y;
	}
	/**
	 * Gets the center of the BoundingBox
	 * @return The center point of the BoundingBox
	 */
	final public Vector2 getCenter()
	{
		return center;
	}
	
	/**
	 * Returns the width of the bounding box
	 * @return The width of the bounding box
	 */
	final public double getWidth()
	{
		return width;
	}
	
	/**
	 * Returns the height of the bounding box
	 * @return The height of the bounding box
	 */
	final public double getHeight()
	{
		return height;
	}
}
