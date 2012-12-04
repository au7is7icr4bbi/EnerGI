/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Collisions;
import energi.Shared.Axis;

/**
 * Interface implemented by all movable objects. Usually used in conjunction with a Graphics object
 * @author andrew
 * @version 1.0
 */
public interface Movable
{
	/**
	 * Move the movable object to a new position
	 * @param x the distance along the X-axis
	 * @param y the distance along the Y-axis
	 */
	public void move(double x, double y);

	/**
	 * Rotate the movable object around a given axis
	 * @param angle the angle of rotation in degrees
	 * @param axis The axis to rotate about
	 */
	public void rotate(double angle, Axis axis);

	/**
	 * Scale the movable object. Values between 1 and 0 scale down the object, whereas positive values scale up the object
	 * @param x the scale factor along the X-axis
	 * @param y the scale factor along the Y-axis
	 */
	public void scale(double x, double y);
}
