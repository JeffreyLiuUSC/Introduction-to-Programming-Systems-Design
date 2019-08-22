// Name: Jiahao Liu
// USC NetID: liujiaha
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/**
 * A dictionary of all anagram sets. 
 * the processing is case-sensitive，which means if the dictionary has all lower
 * case words, you will likely want any string you test to have all lower case
 * letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {

    private HashMap<String, ArrayList<String>> anagramDict;


    /**
     * Create an anagram dictionary by the fileName, exception check will
     * by conducted for the existence of file.
     *
     * @param fileName  the name of the file to read from
     * @throws FileNotFoundException  if the file is not found
     */
    public AnagramDictionary(String fileName) throws FileNotFoundException {

        File input = new File(fileName);
        Scanner in = new Scanner(input);
        anagramDict = getAnagramDict(in);

    }


    /**
     * Get all anagrams of the given string.
     *
     * @param str string to process
     * @return an ArrayList of the anagrams of s
     *
     */
    public ArrayList<String> getAnagramsOf(String str) {

        String canon = getCanon(str);

        if(anagramDict.containsKey(canon)) {

            //avoid side effect
            return new ArrayList<>(anagramDict.get(canon));

        }
        else {
            return new ArrayList<>();
        }
    }


    /**
     * Get the canonical form of given string
     *
     * @param rawString given string needed to be sorted
     * @return  canonical form of given string
     */
    private String getCanon(String rawString) {

        char[] charOfString = rawString.toCharArray();

        Arrays.sort(charOfString);

        String sortedString = new String(charOfString);

        return sortedString;

    }


    /**
     * Create the Dictionary of anagrams. HashMap is used to store the preprocessed anagram dictionary.
     * canonical form of the string is used as the key in HashMap,
     * value is the ArrayList which store all the string with the same canonical form.
     * If key already exists in map, then add the string to the corresponding ArrayList;
     * If key doesn't exist, creates a new ArrayList with the string.
     *
     * @param in  input of the dictionary
     * @return  map of anagram dictionary
     */
    private HashMap<String, ArrayList<String>> getAnagramDict(Scanner in) {

        HashMap<String, ArrayList<String>> dict = new HashMap<>();
        String tempString;
        String tempCanon;

        while(in.hasNext()) {

            tempString = in.next();

            //get the key (canonical form) of map
            tempCanon = getCanon(tempString);

            ArrayList<String> tempList = new ArrayList<>();

            if(!dict.containsKey(tempCanon)) {
                tempList.add(tempString);
                dict.put(tempCanon, tempList);
            }
            else {
                //get the value (list of anagrams) towards the key
                tempList = dict.get(tempCanon);
                tempList.add(tempString);
                dict.put(tempCanon, tempList);
            }
        }

        return dict;
    }
}