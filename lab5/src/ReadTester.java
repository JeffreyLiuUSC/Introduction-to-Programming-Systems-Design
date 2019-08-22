import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class ReadTester{
    static ArrayList<String> myArrList = new ArrayList<String>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter a space separated list of numbers:");
            String input = sc.nextLine();
            String arr[] = input.split("\\s+");
            for (int i = 0; i < arr.length; i++) {
                String x = arr[i];
                myArrList.add(x);
            }
            System.out.println("The numbers were: " + myArrList);
            myArrList.clear();
        }
    }
}