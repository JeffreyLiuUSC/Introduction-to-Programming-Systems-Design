import java.util.Scanner;
import java.util.ArrayList;

public class ReadTester2 {
    static ArrayList<Integer> myArrList = new ArrayList<Integer>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter a space separated list of numbers: ");
        while (sc.hasNextLine()) {
            Scanner scInt = new Scanner(sc.nextLine());
            while (scInt.hasNextInt()) {
                myArrList.add(scInt.nextInt());
            }
            System.out.println("The numbers were: " + myArrList);
            myArrList.clear();
            System.out.print("Enter a space separated list of numbers: ");
        }

    }
}