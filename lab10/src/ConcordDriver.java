import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * Finds frequency of each word in a file.
 * Unlike the lecture version of this code, this one is smarter
 * about what it considers a word.
 *
 * Version for the lab.
 */

public class ConcordDriver {


   public static void main(String[] args) throws FileNotFoundException{

      Concord concord = new Concord();

     // File inputFile = new File("melville.txt");

      Scanner in = new Scanner(System.in);

      concord.addData(in);

     // PrintStream out = new PrintStream("melvilleOut.txt");
    //  PrintStream out = new PrintStream(System.out);
      //concord.print(out);

      concord.printSorted(System.out);

      in.close();
   }

}
