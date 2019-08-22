package pa1;

//Name: Yan Liu
//USC NetID:liu156
//CS 455 PA1
//Spring 2018

/**
 * Class CoinSimViewer
 *  Prompts for the number of trials, and creates the JFrame containing the CoinSimComponent
 */

import javax.swing.JFrame;
import java.util.Scanner;

public class CoinSimViewer {
	
	final static int IMAGE_WIDTH = 800;
	final static int IMAGE_HEIGHT = 500;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Number of Trials: ");
		int Num_Of_Trials = sc.nextInt();
		
		//Error checking
		while (Num_Of_Trials <= 0) {
			System.out.println("The Number of Trials You Entered is invalid, "
					+ "Please Enter a Positive Number");
			Num_Of_Trials = sc.nextInt();
		}
		
		//Display bar graphs of given number of trials entered
		JFrame frame = new JFrame();
		frame.setSize(IMAGE_WIDTH,IMAGE_HEIGHT);
		frame.setTitle("CoinTossSimulate");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		CoinSimComponent component = new CoinSimComponent(Num_Of_Trials); //Creates CoinSimComponent for given number of trials
		frame.add(component);
		
	}

}
