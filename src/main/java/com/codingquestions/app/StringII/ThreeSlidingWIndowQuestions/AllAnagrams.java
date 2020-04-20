package com.codingquestions.app.StringII.ThreeSlidingWIndowQuestions;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Find all occurrence of anagrams of a given string s in a given string l.
 * Return the list of starting indices.
 * 
 * Assumptions
 * 
 * sh is not null or empty. lo is not null. Examples
 * 
 * l = "abcbac", s = "ab", return [0, 3] since the substring with length 2
 * starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 */

// TIEM: O(n)
// SPACE: O(n)
public class AllAnagrams {
    public List<Integer> allAnagrams(String sh, String lo) {
        // build the HashMap using the sh string
        List<Integer> result = new ArrayList<>();
        if (lo.length() == 0) {
            return result;
        }

        if (sh.length() > lo.length()) {
            return result;
        }

        HashMap<Character, Integer> map = buildHashMap(sh);

        char[] array = lo.toCharArray();
        int counter = 0; // tracks how many matches we have
        int i = 0;// left boundary in lo
        // j is the right boundary in lo
        for (int j = 0; j <= array.length - 1; j++) {
            // handle the right pointer first
            Integer val = map.get(array[j]);
            if (val != null) {
                map.put(array[j], val - 1);
                if (val == 1) {
                    counter++;
                }
            }

            // handle the left pointer first
            if (j - i == sh.length()) {
                // remove the ele that i was originally pointed at
                // then i++
                val = map.get(array[i]);
                if (val != null) {
                    map.put(array[i], val + 1);
                    if (val == 0) {
                        counter--;
                    }
                }
                i++;
            }

            if (counter == map.size()) {
                result.add(i);
            }
        }
        return result;
    }

    private HashMap<Character, Integer> buildHashMap(String sh) {
        char[] array = sh.toCharArray();
        HashMap<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            Character key = array[i];
            Integer val = result.get(key);
            if (val == null) {
                result.put(key, 1);
            } else {
                result.put(key, val + 1);
            }
        }
        return result;
    }

}