/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Core;
import energi.Shared.EngineException;

/**
 *
 * Interface implemented by all game objects. Encapsulates
 * all standard functionality covered by the application loop
 * @author andrew
 * @version 1.0
 */
public interface GameObject
{
	/**
	 * Initialise the game object
	 * @throws EngineException
	 */
	public void init() throws EngineException;

	/**
	 * Update the game object
	 * @throws EngineException
	 */
	public void update(float delta) throws EngineException;

	/**
	 * Draw the game object. All classes that implement this interface must implement this function, but can leave it empty if the object is non-drawable
	 * @throws EngineException
	 */
	public void Draw(float delta) throws EngineException;
}
