/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Graphics;
import java.util.LinkedList;
import energi.Content.Asset;
import energi.Shared.EventHandler;

/**
 * Represents a container for sprites used in an animation sequence. 
 * Frames can be added separately or as an array of Sprite objects
 * @author andrew
 * @version 1.1
 */
public class Animation extends Asset
{
	private boolean loop;
	private LinkedList<Sprite> keyframes;
	private int index;
	private EventHandler beginHandler;
	private EventHandler endHandler;
	
	/**
	 * Enumeration of animation events
	 */
	public enum AnimationEvent
	{
		/**
		 * Beginning of animation
		 */
		BEGIN,
		/**
		 * End of non-looping animation
		 */
		END,
	}
	
	/**
	 * Initialise a blank Animation object with no looping
	 */
	public Animation()
	{
		index = 0;
		loop = false;
		keyframes = new LinkedList<Sprite>();
		beginHandler = null;
		endHandler = null;
	}
	
	/**
	 * Initialise a new Animation object with a looping parameter and an array of Sprites
	 * @param willLoop The looping parameter
	 * @param frames An array of Sprite objects representing the key frames of the animation
	 */
	public Animation(boolean willLoop, Sprite frames[])
	{
		keyframes = new LinkedList<Sprite>();
		loop = willLoop;
		
		// add the frames from the array here
		for (int i = 0; i < frames.length; i++)
		{
			keyframes.add(frames[i]);
		}
		index = 0;
		beginHandler = null;
		endHandler = null;
	}
	
	/**
	 * Sets the loopback parameter for the animation
	 * @param flag True if looping, otherwise false
	 */
	final public void setLoopback(boolean flag)
	{
		loop = flag;
	}
	
	/**
	 * Returns a boolean indicating whether this animation will loop
	 * @return True if looping; otherwise false
	 */
	final public boolean willLoop()
	{
		return loop;
	}
	
	/**
	 * Add a frame to the end of the animation
	 * @param newFrame The sprite that represents the next animation frame
	 */
	final public void addFrame(Sprite newFrame)
	{
		keyframes.add(newFrame);
		index++;
	}
	
	/**
	 * Bind an event handler to an animation event (either beginning or ending)
	 * @param event The event you wish to bind the handler to. Either BEGIN or END.
	 * @param handler The event handler (a subclass/implementation of the EventHandler interface)
	 */
	final public void setHandler(AnimationEvent event, EventHandler handler)
	{
		if (event == AnimationEvent.BEGIN)
		{
			beginHandler = handler;
		}
		else
		{
			endHandler = handler;
		}
	}
	
	/**
	 * Remove a frame from any point in the animation
	 * @param index The index of the frame
	 */
	final public void removeFrame(int index)
	{
		keyframes.remove(index);
		index--;
	}
	
	/**
	 * Retrieves the next frame for animation, and enforces loopback if it is enabled
	 * @return The Sprite object for the frame, or null if the animation has ended and does not loop
	 */
	final public Sprite nextFrame()
	{
		if (index == 0 && beginHandler != null)
		{
			beginHandler.handleEvent(null);
		}
		if (loop && index >= keyframes.size())
		{
			// no images left but looping, so return to the beginning frame
			index = 0;
		}
		if (!loop && index >= keyframes.size())
		{
			// no images left in the cycle and not looping, so return null
			if (endHandler != null)
			{
				endHandler.handleEvent(null);
			}
			return null;
		}
		// get the keyframe at the specified index, then move to the next one
		Sprite frame = keyframes.get(index);
		index++;
		
		return frame;
	}
}
