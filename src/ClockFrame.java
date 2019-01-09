/*
 * Melecia Young
 * CS 120
 * Clock Frame
 */

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class ClockFrame extends JFrame{
	
	// static variables for dimensions
	private static final int WIDTH = 500;
	private static final int HEIGHT = 520;
	
	// cPanel member variable
	private ClockPanel cPanel;
	
	// tim the timer!
	private Timer tim;
	
	// constructor
	public ClockFrame() {
		super();
		
		// set size of the panel 
		this.setSize(WIDTH, HEIGHT);
		
		//initialize the panel
		cPanel = new ClockPanel();
		
		// add cPanel to the frame
		this.add(cPanel);
		
		// set the background color of the frame to black 
		this.setBackground(Color.black);
		
		//closing event
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// initialize Tim
		
	} // end of method
	
	// main method displays clock
		public static void main(String[] args) {

			// create clock frame
			ClockFrame mf;
			mf = new ClockFrame();
			mf.setVisible(true);

		} // end of main method

} // end of class
