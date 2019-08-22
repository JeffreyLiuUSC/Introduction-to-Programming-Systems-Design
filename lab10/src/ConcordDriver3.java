import java.io.PrintStream;
import java.util.Scanner;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * Finds frequency of each word in a file.  
 * (Version for Exercise 3.)
 *
 * Optional command line argument is the threshold for the number of
 * letters a word must have to be printed with its number of occurrences.
 *
 * If argument isn't given, prints all words and number of occurrences.
 *
 */

public class ConcordDriver3 {


   public static void main(String[] args) throws FileNotFoundException{

      int threshold = 15;

      if (args.length > 0) {
         threshold = Integer.parseInt(args[0]);
      }

      Concord concord = new Concord();
     // File inputFile = new File("poe.txt");

      Scanner in = new Scanner(System.in);

      concord.addData(in);
      PrintStream out ;
      // add code here to print out the selected entries
     // concord.printSatisfying(new PrintStream("poeOutLarge.txt"), new LargeWordPre(threshold));
      concord.printSatisfying(System.out, new LargeWordPre(threshold));
   }
}
// add new class here
class LargeWordPre implements Predicate{
   private int length;
   public LargeWordPre(int len) {
      length = len;
   }
   public boolean predicate(Map.Entry<String,Integer> item) {
      return item.getKey().length() >= length;
   }
}