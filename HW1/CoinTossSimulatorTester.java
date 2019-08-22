package pa1;

//Name: Yan Liu
//USC NetID:liu156
//CS 455 PA1
//Spring 2018
/*
 * This is CoinTossSimulatorTester class
 * Print out simulated data for corresponding trials before reset and after reset
 */
public class CoinTossSimulatorTester {

	//This function print out the simulation results corresponding to different number of trials
	public static void printResult(CoinTossSimulator toss) {
		boolean addUp = toss.getTwoHeads() + toss.getTwoTails() + toss.getHeadTails() == toss.getNumTrials();
		System.out.println("Number of Trials: " + toss.getNumTrials());
		System.out.println("Two-head tosses: " + toss.getTwoHeads());
		System.out.println("Two-tail tosees: " + toss.getTwoTails());
		System.out.println("One-head One-tail tosses: " + toss.getHeadTails());
		System.out.println("Tosses add up correctly? " + addUp);
	}

	public static void main(String[] args) {
		
		//Display the simulation results before reset
		CoinTossSimulator coinToss = new CoinTossSimulator();
		int[] numOfTrials = new int[]{0,1,10,100};
		for (int i: numOfTrials) {
			coinToss.run(i);
			System.out.println("After run(" + i + ")");
			printResult(coinToss);
		}
		
		//Display the simulation results after reset
		System.out.println("After reset: ");
		coinToss.reset();
		int[] trials = new int[] {0,10,100,1000};
		for (int i: trials) {
			coinToss.run(i);
			System.out.println("After run(" + i + ")");
			printResult(coinToss);
			coinToss.reset();
		}
	}
		
}
	

