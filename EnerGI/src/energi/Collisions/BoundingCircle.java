/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Collisions;
import energi.Shared.Axis;

/**
 * Represents a boundary circle around a game object
 * @author andrew
 * @version 1.0
 */
public class BoundingCircle implements Movable
{
	private Vector2 center;
	private double radius;

	/**
	 * Creates a new bounding circle at the origin (0, 0) with a radius of 1
	 */
	public BoundingCircle()
	{
		center = new Vector2(0, 0);
		radius = 1;
	}

	/**
	 * Creates a new bounding circle with a center point and a radius
	 * @param c Center point
	 * @param r Radius
	 */
	public BoundingCircle(Vector2 c, double r)
	{
		center = c;
		radius = r;
	}

	/**
	 * Tests if the bounding circle is colliding with a point
	 * @param otherPoint The point
	 * @return true if collision detected, otherwise false
	 */
	final public boolean isColliding(Vector2 otherPoint)
	{
		// check whether the straight-line distance between the two points
		// (center and colliding point) is less than the radius of the bounding circle
		double distanceX = center.getX() - otherPoint.getX();
		double distanceY = center.getY() - otherPoint.getY();
		double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
		if (distance < radius)
		{
			return true;
		}
		return false;
	}

	/**
	 * Tests if the bounding circle is colliding with another bounding circle
	 * @param circle The bounding circle
	 * @return true if collision detected, otherwise false
	 */
	final public boolean isColliding(BoundingCircle circle)
	{
		// check whether the stright-line distance between the two center points
		// is less than the sum of the radii of both circles
		double distanceX = center.getX() - circle.center.getX();
		double distanceY = center.getY() - circle.center.getY();
		double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
		if (distance < (radius + circle.radius))
		{
			return true;
		}
		return false;
	}

	/**
	 * Tests if the bounding circle is colliding with a bounding box
	 * @param box The bounding box
	 * @return true if collision detected, otherwise false
	 */
	final public boolean isColliding(BoundingBox box)
	{
		// check whether the straight-line distance from the center point of the circle
		// to each vertex is less than the radius of the bounding circle.
		// Order is not important here
		Vector2 points[] = new Vector2[4];
		points[0] = new Vector2(box.getCenter().getX() - (box.getWidth() / 2), box.getCenter().getY() - (box.getHeight() / 2));
		points[1] = new Vector2(box.getCenter().getX() - (box.getWidth() / 2), box.getCenter().getY() + (box.getHeight() / 2));
		points[2] = new Vector2(box.getCenter().getX() + (box.getWidth() / 2), box.getCenter().getY() - (box.getHeight() / 2));
		points[3] = new Vector2(box.getCenter().getX() + (box.getWidth() / 2), box.getCenter().getY() + (box.getHeight() / 2));

		for (int i = 0; i < 4; i++)
		{
			double distanceX = center.getX() - points[i].getX();
			double distanceY = center.getY() - points[i].getY();
			double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

			if (distance < radius)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Move the BoundingCircle
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
	 * Rotate the BoundingCircle around the given axis
	 * @param angle The angle of rotation
	 * @param axis The axis of rotation
	 */
	@Override
	final public void rotate(double angle, Axis axis)
	{
            /*
		// only rotate the direction
		if (center.getDirection() + angle >= 360)
		{
			center.setDirection(center.getDirection() + angle - 360);
		}
		else
		{
			center.setDirection(center.getDirection() + angle);
		}*/
	}
	
	/**
	 * Scale the BoundingCircle up or down by a given scale factor
	 * @param x
	 * @param y 
	 */
	@Override
	final public void scale(double x, double y)
	{
		radius *= x;
	}
	
	/**
	 * Gets the center point of the circle
	 * @return The center point of the circle
	 */
	final public Vector2 getCenter()
	{
		return center;
	}
	
	/**
	 * Gets the radius of the circle
	 * @return The radius of the circle
	 */
	final public double getRadius()
	{
		return radius;
	}
}
