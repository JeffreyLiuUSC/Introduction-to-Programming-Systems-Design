package pa1;

 // Name: Yan Liu
 //USC NetID: liu156
 //CSCI 455 PA1
 //Spring 2018


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/** CoinSimComponent Class
 * This class extends JComponenet
 * Constructs bar graph from the results of running simulation using CoinTossSimulator
*/
public class CoinSimComponent extends JComponent {
	private CoinTossSimulator simulator;
	
	public final static int VERTICAL_BUFFER = 50; //the distance reserved between tallest bar you could draw and top/bottom of the frame
	public final static int BAR_WIDTH = 100; 
	public final static Color COLOR_OF_TWOHEADS = Color.red;
	public final static Color COLOR_OF_HEADTAILS = Color.green;
	public final static Color COLOR_OF_TWOTAILS = Color.BLUE;
	public final static int PERCENTAGE = 100;

	/** 
	 * CoinSimComponent Constructor initialize CoinTossSimulator and runs a simulation for given number of trials
	 * @param numberOfTrials
	 */
	public CoinSimComponent(int numberOfTrials) {
		simulator = new CoinTossSimulator();
		simulator.run(numberOfTrials);
	}
	
	// Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		// Calculating offsets needed for drawing bar graph
		double scale = (double)(getHeight() - VERTICAL_BUFFER * 2) / PERCENTAGE;
		int gap_width = (getWidth() - BAR_WIDTH * 3) / 4;
		int bottom = getHeight() - VERTICAL_BUFFER;
		
		// Calculating the bar height in application units(percentage):
		int twoHead_height = (int)(simulator.getTwoHeads() * PERCENTAGE) / simulator.getNumTrials();
		int headTail_height = (int)(simulator.getHeadTails() * PERCENTAGE) / simulator.getNumTrials();
		int twoTail_height = (int)(simulator.getTwoTails() * PERCENTAGE) / simulator.getNumTrials();
		
		// Formatting the proper bar title
		String BarTwoHeadsTitle = String.format("Two Heads: %d (%d%s)", 
				simulator.getTwoHeads(), twoHead_height, "%");
		String BarHeadTailTitle = String.format("A Head and a tail: %d (%d%s)", 
				simulator.getHeadTails(), headTail_height, "%");
		String BarTwoTailsTitle = String.format("Two Tails: %d (%d%s)", 
				simulator.getTwoTails(), twoTail_height, "%");
		
		// Constructs the bars based on following parameters:
		// bottom, left, width, height(in units), scale(pixels per unit), color, title
		Bar BarTwoHeads = new Bar(bottom, gap_width, BAR_WIDTH,
				twoHead_height, scale, COLOR_OF_TWOHEADS, BarTwoHeadsTitle);
		Bar BarHealTail = new Bar(bottom, gap_width * 2 + BAR_WIDTH,BAR_WIDTH,
				headTail_height, scale, COLOR_OF_HEADTAILS, BarHeadTailTitle);
		Bar BarTwoTails = new Bar(bottom, gap_width * 3 + BAR_WIDTH * 2 ,BAR_WIDTH,
				twoTail_height, scale, COLOR_OF_TWOTAILS, BarTwoTailsTitle);

		BarTwoHeads.draw(g2);
		BarHealTail.draw(g2);
		BarTwoTails.draw(g2);
		
	}
	

}
