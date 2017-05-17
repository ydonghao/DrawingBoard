package GUI;

import java.awt.Color;

/**
 * Block - This class represents one individual block object on the board
 * @author gavinshrader
 * @version 1.0.0 (May 17, 2017)
 */
public class Block {
	
	//DECLARATIONS
	private boolean isActive;
	private Color col;
	private int x;
	private int y;
	private int width;
	private int height;
	
	/**
	 * Block - constructs one block
	 * @param x position
	 * @param y position
	 * @param width  (variable of width/resolution)
	 * @param height (variable of height/resolution)
	 */
	public Block(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.isActive = false;
	}
	
	/**
	 * isActive - returns true if block is not empty
	 * @return is block set
	 */
	public boolean isActive() {
		return isActive;
	}
	
	/**
	 * setColor - set the color of the block
	 * @param color
	 */
	public void setColor(Color c) {
		col = c;
	}
	
	/**
	 * getColor - get the color of the block
	 * @return color of block
	 */
	public Color getColor() {
		return col;
	}
	
	/**
	 * setActive - set the block to parameter, either on (active) or off (!active)
	 * @param is block active
	 */
	public void setActive(boolean active) {
		isActive = active;
	}
	
	/**
	 * getX
	 * @return x position of block
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * getY
	 * @return y position of block
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * getWidth
	 * @return width of block
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * getHeight
	 * @return height of block
	 */
	public int getHeight() {
		return height;
	}
}
