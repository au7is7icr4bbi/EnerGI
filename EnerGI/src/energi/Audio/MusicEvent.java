/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Audio;
import energi.Content.Asset;
import energi.Shared.EngineException;

/**
 * Represents an event where music either changes or is triggered
 * @author andrew
 * @version 1.0
 */
public class MusicEvent extends Asset
{
	/**
	 * Create a MusicEvent from a Playable item
	 * @param music The audio item to play
	 * @throws EngineException 
	 */
	public MusicEvent(Playable music) throws EngineException
	{
		if (AudioPlayer.isPlaying())
		{
			AudioPlayer.stop();
		}
		AudioPlayer.playLoop(music);
	}
}
