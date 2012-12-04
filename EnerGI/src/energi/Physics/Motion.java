/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Physics;
import energi.Collisions.Vector2;
//import energi.Core.Game;

/**
 * Non instanced class for rudimentary motion calculations.
 * Time in all these calculations is 1 as these calculations are done on a per-loop iteration basis.
 * All functions support chaining (ie. using previous value as next starting value), and also supports vector calculations
 * using negatives
 * @author andrew
 * @version 1.0
 */
public final class Motion
{
	/**
	 * Gravity constant which uses negative value for vector calculation.
	 */
	public final static double gravity = -9.81;
	/**
	 * Final vertical velocity after 1 frame. Used to fully describe gravity-affected motion
	 */
	private double finalVelocity = 0.0;

	/**
	 * Calculate the next position of an object moving horizontally with constant velocity (no vertical movement such as walking).
	 * @param startPoint the starting point
	 * @param velocity the ground velocity
	 * @return the next point
	 */
	final public Vector2 staticHorizontalMotion(Vector2 startPoint, double velocity, float time)
	{
		Vector2 endPoint = new Vector2();
		
		// calculate the coordinates based on constant velocity and the game's delta value
		endPoint.setX(startPoint.getX() + velocity * time);
		endPoint.setY(startPoint.getY());
		return endPoint;
	}

	/**
	 * Calculate the next position of an object moving vertically with constant velocity (eg. climbing a ladder).
	 * Not affected by gravity.
	 * @param startPoint the starting point
	 * @param velocity the vertical velocity
	 * @return the next point
	 */
	final public Vector2 staticVerticalMotion(Vector2 startPoint, double velocity, float time)
	{
		Vector2 endPoint = new Vector2();
		endPoint.setX(startPoint.getX());
		endPoint.setY(startPoint.getY() + velocity * time);
		return endPoint;
	}

	/**
	 * Calculate the next point assuming dynamic vertical motion (eg. jumping).
	 * Gravity affects the result.
	 * @param startPoint the starting point
	 * @param velocity the initial vertical velocity
         * @param time The time delta, expressed in seconds
	 * @return the next point
	 */
	final public Vector2 dynamicVerticalMotion(Vector2 startPoint, double velocity, float time)
	{
		Vector2 endPoint = new Vector2();
		endPoint.setX(startPoint.getX());
		endPoint.setY(startPoint.getY() + velocity * time + 0.5 * gravity * (time * time));
		finalVelocity = velocity + gravity * time;
		return endPoint;
	}
	
	/**
	 * Resets the chained angle and velocity values
	 */
	final public void reset()
	{
		finalVelocity = 0.0;
	}
        
        /**
         * Get the current velocity for chaining
         * @return The current final velocity
         */
        public double getCurrentVelocity()
        {
            return finalVelocity;
        }
}
