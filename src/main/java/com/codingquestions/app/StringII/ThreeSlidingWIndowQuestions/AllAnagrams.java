package com.codingquestions.app.StringII.ThreeSlidingWIndowQuestions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> result = new ArrayList<>();
        if (l.length() == 0) {
            return result;
        }
        if (s.length() > l.length()) {
            return result;
        }
        Map<Character, Integer> map = countMap(s); // count the number that hasn't matched yet
        int match = 0;
        for (int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            // handle the rightmost character
            if (count != null) {
                map.put(tmp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            // handle the leftmost character
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            // for the current sliding window
            if (match == map.size()) {
                result.add(i - s.length() + 1);
            }
        }
        return result;
    }

    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            // case 1: element is not in the map yet
            // case 2: element is in the map
            Integer count = map.get(array[i]);
            count = count == null ? 1 : count + 1;
            map.put(array[i], count);
        }
        return map;
    }
}