package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * ColorSelector - this class draws the color selector panel and is responsible for setting the current color,
 * setting the red selector around the current color and returning the color when called
 * @author gavinshrader
 * @version 1.0.0 (May 17, 2017)
 *
 */
public class ColorSelector extends JPanel implements MouseMotionListener, MouseListener {
	//FINALS
	private final Color[] colors = {Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.PINK, Color.RED, Color.ORANGE, Color.YELLOW};
	private final int[] colorPositions = {5, 45, 85, 125, 165, 205, 245, 285, 325, 365, 405, 445, 485};
	
	//DECLARATIONS
	int x_pos = 10; //used in drawing rectangles
	int y_pos = 5; //used in drawing rectangles
	int lastColorPosition = 5; //used in drawing selector, default to BLACK 
	int currentColorPositionNormalized = 0; //default BLACK
	
	/**
	 * ColorSelector - constructor, sets window size, background color, creates selector panel and adds mouse listener
	 * @param width of panel
	 * @param height of panel
	 */
	public ColorSelector(int w, int h) {
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.WHITE);
		
		createColorSelector();
		addMouseListener(this);
	}
	
	/**
	 * getCurrentColor - returns whatever color you have selected
	 * @return currently selected color
	 */
	public Color getCurrentColor() {
		return colors[currentColorPositionNormalized];
	}
	
	//OVERRIDE
	@Override
	protected void paintComponent(Graphics gh) {
		super.paintComponent(gh);
		
		createColorSelector(gh);
	}
	
	@Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        findSelection(e);
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
     * createColorSelector - repaint board
     */
	private void createColorSelector() {
		repaint();
	}
	
	/**
	 * createColorSelector - paint board, loop through color array and create rectangles
	 * @param graphics element
	 */
	private void createColorSelector(Graphics gh) {
		for(Color c: colors) {
			//loop through colors array, set to display board
			gh.setColor(c);
			gh.fillRect(x_pos, y_pos, 30, 30);
			y_pos += 40;
		}
		y_pos = 5; //return to default
		drawSelectionRectangle(gh, lastColorPosition);
	}
	
	/**
	 * drawSelectionRectangle - draw the red rectangle around the selected color
	 * @param graphics element
	 * @param y_position - the position of the current color 
	 */
	private void drawSelectionRectangle(Graphics gh, int y_position) {
		gh.setColor(Color.RED);
		gh.drawLine(9, y_position - 1, 41, y_position - 1); //top
		gh.drawLine(9, y_position + 31, 41, y_position + 31); //bottom
		gh.drawLine(9, y_position - 1, 9, y_position + 31); //left side
		gh.drawLine(41, y_position - 1, 41, y_position + 31); //right side
	}
	
	/**
	 * findSelection - when the mouse event is triggered check if the user is selecting a viable color
	 * @param mouse event e
	 */
	private void findSelection(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		int temp = 0;
		if(mouseX > 9 && mouseX < 41) {
			//within x
			for(int checkYPosition: colorPositions) {
				temp++;
				if(mouseY >= checkYPosition && mouseY <= (checkYPosition + 30)) {
					lastColorPosition = checkYPosition;
					currentColorPositionNormalized = temp - 1;
					repaint();
				}
			}
		}
	}
}
