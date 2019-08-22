// Name: Jiahao Liu
// USC NetID: liujiaha
// CS 455 PA4
// Fall 2018

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * A Rack of Scrabble tiles
 */

public class Rack {

    private String unique;
    private int[] mult;
    private ArrayList<String> allSubsets;

    public Rack (String str) {

        getUnique(str);
        this.allSubsets = allSubsets(unique, mult, 0);

    }


    /**
     * Get all subsets of rack
     *
     * @return  all subsets of rack
     */
    public ArrayList<String> getAllSubsets() {

        return  allSubsets;

    }

    /**
     * Get a string of unique letters for rack and multiplicity of each letter from string.
     * each unique letter is used for key, its corresponding values indicate the multiplicity
     * Iterate the entry set of map, get value
     * of multiplicity and store the value in array.
     *
     * @param str  given rack
     */
    private void getUnique(String str) {

        this.unique = "";

        //convert string into chars so that we can sort it
        char[] charOfString = str.toCharArray();
        Arrays.sort(charOfString);

        //use map to compute the multiplicity of letter
        //use unique letter as key, use multiplicity of each letter as value
        TreeMap<Character, Integer> map = new TreeMap<>();

        for(char characters : charOfString) {
            Integer num = map.get(characters);
            if (num == null){
                map.put(characters, 1);
            }else {
                map.put(characters, num + 1);
            }
        }

        Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();

        this.mult = new int[map.size()];

        for(int i = 0; i < this.mult.length; i++) {

            Map.Entry<Character, Integer> entry = iter.next();

            this.mult[i] = entry.getValue();

            this.unique += Character.toString(entry.getKey());

        }
    }

    /**
     * Finds all subsets of the multiset starting at position k in unique and mult.
     * unique and mult describe a multiset such that mult[i] is the multiplicity of the char
     *      unique.charAt(i).
     * PRE: mult.length must be at least as big as unique.length()
     *      0 <= k <= unique.length()
     *
     * @param unique a string of unique letters
     * @param mult the multiplicity of each letter from unique.
     * @param k the smallest index of unique and mult to consider.
     * @return all subsets of the indicated multiset
     * @author Claire Bono
     */
    private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
        ArrayList<String> allCombos = new ArrayList<>();

        if (k == unique.length()) {  // multiset is empty
            allCombos.add("");
            return allCombos;
        }

        // get all subsets of the multiset without the first unique char
        ArrayList<String> restCombos = allSubsets(unique, mult, k+1);

        // prepend all possible numbers of the first char (i.e., the one at position k)
        // to the front of each string in restCombos.  Suppose that char is 'a'...

        String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
        for (int n = 0; n <= mult[k]; n++) {
            for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets
                // we found in the recursive call
                // create and add a new string with n 'a's in front of that subset
                allCombos.add(firstPart + restCombos.get(i));
            }
            firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
        }

        return allCombos;
    }
}