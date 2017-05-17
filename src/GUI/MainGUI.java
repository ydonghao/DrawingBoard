package GUI;

//mouse events
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.JButton;
//swing components
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
/**
 * MainGUI - This is the main GUI for my drawing board project.
 * 
 * @author gavinshrader
 * @version 1.0.0 Final (May 17, 2017)
 *
 */
public class MainGUI extends JFrame {
	//FINALS
	private final int RESOLUTION = 50;  //number of pixels in board
	private JPanel mainPanel;
	private Board newBoard;
	public static ColorSelector newColor;
	private JButton clear;
	private JButton toFile;
	private JButton help;
	
	/**
	 * Main methods - start and run a new GUI
	 */
	public static void main(String[] args) {
		new MainGUI();
	}
	
	/**
	 * MainGUI - Initialize GUI, set size, location, operations and
	 * add components to panel.
	 */
	public MainGUI() {
		//add to panel
		setMainPanel();
		setDrawingBoard();
		setColorSelector();
		setRightPanel();
		
		//defaults
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(new Dimension(700, 550));
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	//PRIVATE METHODS 
	/**
	 * setMainPanel - creates the main content pane and sets the background
	 */
	private void setMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		setContentPane(mainPanel);
	}
	
	/**
	 * setDrawingBoard - instantiates the main board, adds to main panel
	 */
	private void setDrawingBoard() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setPreferredSize(new Dimension(510, 510));
		//set board object
		newBoard = new Board(500, 500, RESOLUTION);
		panel.add(newBoard);
		mainPanel.add(panel);
	}
	
	/**
	 * setColorSelector - instantiates the color selector panel, adds to main panel
	 */
	private void setColorSelector() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(50, 490));
		//set color object
		newColor = new ColorSelector(50, 490);
		panel.add(newColor);
		mainPanel.add(panel);
	}
	
	/**
	 * setRightPanel - creates the right panel with clear and unfinished to-file buttons, adds to main panel
	 */
	private void setRightPanel() {
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout());
		rightPanel.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints con = new GridBagConstraints();
		con.gridwidth = GridBagConstraints.REMAINDER;
		con.anchor = GridBagConstraints.CENTER;
		
		help = new JButton("Help");
		help.addActionListener(e-> {
			StringBuilder sb = new StringBuilder();
			sb.append("This is a simple drawing program.");
			sb.append("\nDraw by holding left click, erase individual pixels with right click or press \"clear\".");
			sb.append("\n\"To File\" does not currently work, in version 2.0 it will create an image with your drawing.");
			sb.append("\n\nCreated by Gavin Shrader, May 2017");
			JOptionPane.showMessageDialog(this, sb.toString(), "Help", JOptionPane.PLAIN_MESSAGE);
		});
		clear = new JButton("Clear");
		clear.addActionListener(e -> newBoard.clear());
		toFile = new JButton("To File");
		//add buttons to panel
		rightPanel.add(help, con);
		rightPanel.add(Box.createVerticalStrut(20));
		rightPanel.add(clear, con);
		rightPanel.add(Box.createVerticalStrut(20));
		rightPanel.add(toFile, con);

		mainPanel.add(rightPanel);
	}

}