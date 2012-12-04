/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package energi.Graphics;

import org.newdawn.slick.opengl.*;
import org.newdawn.slick.util.ResourceLoader;
import static org.lwjgl.opengl.GL11.*;
import java.io.*;
import energi.Shared.*;
/**
 * Represents a sprite used by certain game objects. Can be scaled, translated and rotated
 * @author andrew
 * @version 1.0
 */

public final class Sprite
{
	private Texture texture; // the image
	private String filename;
	private float cornerX;
	private float cornerY;
	private boolean visible; // defaults to visible
	/**
	 * Creates a new sprite from an image file in the content pipeline
	 * @param f the image file
	 */
	public Sprite(String f) throws EngineException
	{
		filename = f;
		init();
		cornerX = 0;
		cornerY = 0;
		visible = true;
	}
	
	/**
	 * Set the visibility of the sprite
	 * @param v True if visible, false if invisible
	 */
	final public void setVisible(boolean v)
	{
		visible = v;
	}
	
	/**
	 * Returns whether the sprite is visible or invisible
	 * @return True is visible, false if invisible
	 */
	final public boolean isVisible()
	{
		return visible;
	}

	/**
	 * Load the sprite from the content pipeline
	 * @throws EngineException
	 */
	private void init() throws EngineException
	{
		try
		{
			texture = TextureLoader.getTexture(filename.substring(filename.length() - 3).toUpperCase(), ResourceLoader.getResourceAsStream(filename));
		}
		catch (IOException e)
		{
			throw new EngineException("Content pipeline error: " + e.getMessage(), ExceptionAction.EXIT, null);
		}
	}

	/**
	 * Draws the sprite on the screen, based on the supplied image and previous movement actions
	 */
	final public void Draw()
	{
		if (visible)
		{
			glBegin(GL_QUADS);
				texture.bind();
				glTexCoord2f(0,0);
				glVertex2f(cornerX,texture.getTextureHeight() + cornerY);
				glTexCoord2f(1,0);
				glVertex2f(texture.getTextureWidth() + cornerX,texture.getTextureHeight() + cornerY);
				glTexCoord2f(1,1);
				glVertex2f(texture.getTextureWidth() + cornerX, cornerY);
				glTexCoord2f(0,1);
				glVertex2f(cornerX,cornerY);
			glEnd();
		}
	}
	
	/**
	 * Sets the top corner of the sprite. Used for particular texture rotations
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	final public void setTopCorner(float x, float y)
	{
		cornerX = x;
		cornerY = y;
	}
	
	/**
	 * Gets the width of the sprite
	 * @return The sprite width
	 */
	final public float getWidth()
	{
		return texture.getImageWidth();
	}
	
	/**
	 * Sets the height of the sprite
	 * @return The sprite height
	 */
	final public float getHeight()
	{
		return texture.getImageHeight();
	}
}
