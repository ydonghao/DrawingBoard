package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

/**
 * Board - Creates the main board, implements mouse listeners and calls ModifyBoard via super
 * @author gavinshrader
 * @version 1.0.0 (May 17, 2017)
 */
public class Board extends ModifyBoard implements MouseMotionListener, MouseListener{
	
	/**
	 * Board - adds mouses listeners and creates ModifyBoard via super
	 * @param width of board
	 * @param height of board
	 * @param resolution of board (this is how many pixels will be drawn)
	 */
	public Board(int w, int h, int resolution) {
		super(w, h, resolution);
		
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	//OVERRIDES
	@Override
    public void mouseDragged(MouseEvent e) {
        setBlock(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setBlock(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    //PRIVATE METHODS
    /**
     * setBlock - loop through each block and check if current x / y
     * location are within bounds of any section, if so set active or not
     * @param MouseEvent e
     */
    private void setBlock(MouseEvent e) {
    	for(Block b: blocks) {
    		if(e.getX() > b.getX() && e.getX() < (b.getX() + b.getWidth()) && e.getY() > b.getY() 
    			&& e.getY() < (b.getY() + b.getHeight())) {
    				if(SwingUtilities.isLeftMouseButton(e)) {
    				//set to active
    					b.setActive(true);
    					//This use of static variable is poor design, my object flow was not properly balanced!
						b.setColor(MainGUI.newColor.getCurrentColor());
    				} else if (SwingUtilities.isRightMouseButton(e)) {
    				//set to inactive
    					b.setActive(false);
    				}
    		}
    	}
    	repaint();
    }

}
