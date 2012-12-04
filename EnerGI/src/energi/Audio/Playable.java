/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Audio;
import energi.Shared.EngineException;

/**
 * Interface class for all audio item subclasses
 * @author andrew
 * @version 1.0
 */
public interface Playable
{
	/**
	 * Play the audio file once
	 * @throws EngineException
	 */
	public void play() throws EngineException;

	/**
	 * Stop the audio file
	 * @throws EngineException
	 */
	public void stop();

	/**
	 * Play the audio file as a loop
	 * @throws EngineException
	 */
	public void playLoop() throws EngineException;
}
