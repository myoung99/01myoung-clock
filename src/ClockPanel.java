/*
 * Melecia Young
 * CS 120
 * ClockPanel 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import javax.swing.JPanel;

public class ClockPanel extends JPanel{
	
	// declare and initialize center x and y constants
	private final int CENTER_X = 250;
	private final int CENTER_Y = 250;
	 
	
	// gets a calendar using the default time zone and location
	Calendar cal = Calendar.getInstance();
	
	// get the current hour, min, and sec
	private int hour = cal.get(Calendar.HOUR);
	private int min = cal.get(Calendar.MINUTE);
	private int sec = cal.get(Calendar.SECOND);
	
	// declare variables for the hour, min, and second hand (angle and length)
	private double hAngle;
	private double hSize;

	private double mAngle;
	private double mSize;

	private double sAngle;
	private double sSize;
	
	public void paint(Graphics g) {
		
		//adds one second to the ticking second hand
		cal.add(Calendar.SECOND, 1);
		
		//update the time
		hour = cal.get(Calendar.HOUR);
		min = cal.get(Calendar.MINUTE);
		sec = cal.get(Calendar.SECOND);
		
		// create the clock face
		g.setColor(Color.white);
		g.fillOval(0, 0, this.getWidth(), this.getHeight());
		
		
		// use a for loop to draw the other tick marks
		for (int i = 0; i <= 12; i++) {
			g.setColor(Color.black);
			
			double angle =  (i-3) * 2 * Math.PI/12;
			double size = .5 * (this.getWidth());
			int x = (int)Math.round(250 + size * Math.cos(angle));
			int y = (int)Math.round(250 + size * Math.sin(angle));
			int sizeX = (int)Math.round(250 + (size*.7) * Math.cos(angle));
			int sizeY = (int)Math.round(250 + (size * .7) * Math.sin(angle));
			g.drawLine(sizeX, sizeY, x, y);
		}
		
		// label the hours
		g.setColor(Color.red);
		//draw 12
		g.drawString("12", 246, 130);
		//draw 3
		g.drawString("3", 385, 255);
		//draw 6
		g.drawString("6", 246, 360);
		// draw 9
		g.drawString("9", 120, 255);
		
		/*
		 * HOUR HAND
		 * subtract 3 from hour hand bc each hand increments within a span of 3
		 * divide by 12 because there are 12 hours
		 */
		
		hAngle = (hour-3) * 2 * Math.PI/12;
		hSize = .4 * (this.getWidth() / 2);
		
		// get the x and y coordinates for the current hour
		int xHr = (int)Math.round(250 + hSize * Math.cos(hAngle)); // have to use cos for x
		int yHr = (int)Math.round(250 + hSize * Math.sin(hAngle)); // have to use sin for y
		
		g.setColor(Color.red);
		g.drawLine(CENTER_X, CENTER_Y-15, xHr, yHr);
		//thicken the hand and have it come to a point
		g.drawLine(CENTER_X, CENTER_Y-14,xHr , yHr);
		g.drawLine(CENTER_X, CENTER_Y-16,xHr , yHr);
		
		System.out.println("Hour: " + hour); // TEST the accuracy
		
		/*
		 * MINUTE HAND
		 * subtract 15 from min hand
		 * divide by 60 (60 minutes total)
		 */
		
		mAngle = (min - 15) * 2 * Math.PI/60;
		mSize = .6 * (this.getWidth() / 2);
		
		// get the x and y coordinates for the current minute
		int xMin = (int)Math.round(250 + mSize * Math.cos(mAngle));
		int yMin = (int)Math.round(250 + mSize * Math.sin(mAngle));
		
		g.setColor(Color.green);
		g.drawLine(CENTER_X, CENTER_Y-15, xMin ,yMin);
		//thicken the line
		g.drawLine(CENTER_X, CENTER_Y-14, xMin, yMin);
		g.drawLine(CENTER_X, CENTER_Y-16, xMin, yMin);
		
		System.out.println("Minutes: " + min); // TEST the accuracy
		
		/*
		 * SECONDS HAND
		 * subtract 15 from sec hand 
		 * divide 60 because there's 60 seconds in a minute
		 */
		
		//need to update the second hand
		sec = cal.get(Calendar.SECOND);
		sAngle = (sec - 15) * 2 * Math.PI/60;
		sSize = .6 * (this.getWidth()/4);
		
		int xSec = (int)Math.round(250 + sSize * Math.cos(sAngle));
		int ySec = (int)Math.round(250 + sSize * Math.sin(sAngle));
		
		g.setColor(Color.black);
		g.drawLine(CENTER_X, CENTER_Y-15, xSec, ySec);
		g.drawLine(CENTER_X,CENTER_Y-14,xSec, ySec);
		g.drawLine(CENTER_X, CENTER_Y-16, xSec, ySec);
		
		System.out.println("Seconds: " + sec ); // TEST
		
		// create the inner circle so it covers the hands
		g.setColor(Color.GRAY);
		g.fillOval(CENTER_X, CENTER_Y-20, 10, 10);
		
	}
	

}
