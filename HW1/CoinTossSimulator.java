
//Name: Yan Liu	
//USC NetID: 8025477178
//CS 455 PA1
//Spring 2018

import java.util.Random;

/**
* class CoinTossSimulator
* 
* Simulates trials of repeatedly tossing two coins and allows the user to access the
* cumulative results.
* 
* NOTE: we have provided the public interface for this class.  Do not change
* the public interface.  You can add private instance variables, constants, 
* and private methods to the class.  You will also be completing the 
* implementation of the methods given. 
* 
* Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
* 
*/
public class CoinTossSimulator {
	final static int HEAD_VALUE = 0;
	final static int TAIL_VALUE = 1;
	
	private int numTrials;
	private int twoHeads;
	private int twoTails;
	private int headTails;
	private Random rand;
	
/**
   Creates a coin toss simulator with no trials done yet.
*/
public CoinTossSimulator() {
	numTrials = 0;
	twoHeads = 0;
	twoTails = 0;
	headTails = 0;
	this.rand = new Random();
		
}


/**
   Runs the simulation for numTrials more trials. Multiple calls to this method
   without a reset() between them *add* these trials to the current simulation.
   
   @param numTrials  number of trials to for simulation; must be >= 1
 */
public void run(int numTrials) {
	int random_index = 2;//index for generate random int between 1 and 0
	for (int i = 0; i < numTrials; i++) {
		int value = rand.nextInt(random_index);
		int value2 = rand.nextInt(random_index);
		if (value == HEAD_VALUE && value2 == HEAD_VALUE) {
			twoHeads++;
		} 
		else if (value == TAIL_VALUE && value2 == TAIL_VALUE ) {
			twoTails++;
		}
		else {
			headTails++;
		}
	}
	this.numTrials += numTrials;	
}


/**
   Get number of trials performed since last reset.
*/
public int getNumTrials() {
    return numTrials; 
}


/**
   Get number of trials that came up two heads since last reset.
*/
public int getTwoHeads() {
    return twoHeads; 
}


/**
  Get number of trials that came up two tails since last reset.
*/  
public int getTwoTails() {
    return twoTails; 
}


/**
  Get number of trials that came up one head and one tail since last reset.
*/
public int getHeadTails() {
    return headTails; 
}


/**
   Resets the simulation, so that subsequent runs start from 0 trials done.
 */
public void reset() {
	numTrials = 0;
	twoHeads = 0;
	twoTails = 0;
	headTails = 0;
}

}