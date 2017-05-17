package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * ModifyBoard - This contains the math and the graphics behind the board, draws the lines
 * stores the individual block objects via ArrayList and sets the colors via colorSelector 
 * @author gavinshrader
 * @version 1.0.0 (May 17, 2017)
 */
public class ModifyBoard extends JPanel {
	
	//Declarations
	protected ArrayList<Block> blocks;
	private int resolution, height, width;
	
	/**
	 * ModifyBoard - called via super on Board.java, same params
	 * @param width of board
	 * @param height of board
	 * @param resolution of board (Number of Blocks to add)
	 */
	public ModifyBoard(int w, int h, int res) {
		super();
		this.width = w;
		this.height = h; 
		this.resolution = res;
		
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.WHITE);
		
		generateBlocks();
	}
	
	//OVERRIDES
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		generateBlocks(g);
		drawBlocks(g);
	}
	
	//PRIVATE METHODS
	/**
	 * GenerateBlocks - This method will do the math to input the line grid onto the board, this will then
	 * add block objects onto the arrayList with the resolution given as the paramter via Constructor via Super
	 */
	private void generateBlocks() {
		blocks = new ArrayList<>();
		
		for(int x = 0; x < resolution; x++) {
			for(int i = 0; i < resolution; i++) {
				//do math, this finds the lines on the board
				int lineX = (x * (width/resolution));
				int lineY = (i * (height/resolution));
				int width_input = width/resolution;
				int height_input = height/resolution;
				
				blocks.add(new Block(lineX, lineY, width_input, height_input));
			}
		}
		repaint(); 
		//sections have been added, repaint
	}
	
	/**
	 * generateBlocks - Draws the lines on the board
	 * @param graphics element
	 */
	private void generateBlocks(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		
		for(Block b: blocks) {
			g.drawLine(0, b.getY(), width, b.getY());
			g.drawLine(b.getX(), 0, b.getX(), height);
		}
	}
	
	/**
	 * drawBlocks - fill in active blocks
	 * @param graphics element
	 */
	private void drawBlocks(Graphics g) {
		for(Block b: blocks) {
			if(b.isActive()) {
				g.setColor(b.getColor());
				g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
			}
		}
	}
	
	/**
	 * clear - this will clear the board
	 */
	public void clear() {
		for(Block b: blocks) {
			b.setActive(false);
		}
		repaint();
	}
}
