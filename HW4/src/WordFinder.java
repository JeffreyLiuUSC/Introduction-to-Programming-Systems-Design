// Name: Jiahao Liu
// USC NetID: liujiaha
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * WordFinder Class
 *
 * use default(sowpods.txt) or typed dictionary as anagram dictionary
 * when type . , exit.
 * use input string as rack, get its allsubsets stored in arraylist.
 * for all subsets of string, find its anagrams.
 * use arraylist of map store the legal string and its values and sorted it into decreasing order,
 * then print it as required.
 */

public class WordFinder {

    public static void main(String[] args) {

        String fileName = "sowpods.txt";

        if (args.length > 0) {
            fileName = args[0];
        }

        try {
            AnagramDictionary ad = new AnagramDictionary(fileName);
            prompts();
            Scanner in = new Scanner(System.in);
            displayResult(in, ad);
        }

        catch(FileNotFoundException e) {
            System.out.println("Can not find input file: " + fileName);
        }
    }

    /**
    * Display the prompts for user about exit the program and what to type.
    **/
    private static void prompts(){

        System.out.println("Type . to quit.");
        System.out.print("Rack? ");

    }

    /**
     * Find and display all the words that be formed from the letters on the rack ,
     * with the corresponding Scrabble score for each word, in decreasing order by score.
     * For words with the same scrabble score, the words appear in alphabetical order.
     *
     * @param in  system input string
     * @param ad  dictionary of anagrams
     */
    private static void displayResult(Scanner in, AnagramDictionary ad) {

        while(in.hasNext()) {

            String input = in.next();

            if(input.equals(".")) {
                break;
            }

            Rack rack = new Rack(input);

            ArrayList<String> subsetsList = rack.getAllSubsets();
            ArrayList<String> anagramsList = new ArrayList<>();

            for(String string : subsetsList) {
                anagramsList.addAll(ad.getAnagramsOf(string));
            }

            ArrayList<Map.Entry<String, Integer>> entryList = getWordsAndScores(anagramsList);

            System.out.println("We can make " + entryList.size() + " words from \"" + input + "\"");

            if(entryList.size() != 0) {
                System.out.println("All of the words with their scores (sorted by score): ");
            }

            for (Map.Entry<String, Integer> curr : entryList) {
                System.out.println(curr.getValue() + ": " + curr.getKey());
            }

            System.out.print("Rack? ");
        }
    }


    /**
     * Use TreeMap to represent all the words and scores.
     * Use words as key, scores as value. Sort the entries in
     * decreasing order by score.
     *
     * @param anagramsList
     * @return  sorted entry list
     */
    private static ArrayList<Map.Entry<String, Integer>> getWordsAndScores(ArrayList<String> anagramsList) {

        TreeMap<String, Integer> anagramsMap = new TreeMap<>();

        ScoreTable score = new ScoreTable();

        for(String string : anagramsList) {
            anagramsMap.put(string, score.getScore(string));
        }

        ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>();

        entryList.addAll(anagramsMap.entrySet());

        Collections.sort(entryList, new ScoreComparator());

        return entryList;

    }
}


/**
 * Implement Comparator Interface.
 * Compare the value of entry so as to sort the entry in decreasing order of scores.
 */
class ScoreComparator implements Comparator<Map.Entry<String, Integer>> {

    public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){

        return b.getValue() - a.getValue();

    }
}