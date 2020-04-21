package com.codingquestions.app.StringII.ThreeSlidingWIndowQuestions;

import java.util.HashMap;
import java.util.Map;

import com.codingquestions.app.BinarySearch.KClosestInSortedArray;

/**
 * Given a string, find the longest substring with k repeating characters and
 * return the length of it. The input string is guaranteed to be not null.
 * 
 * For example, the longest substring with 2 repeating characters for "bcdbfbd"
 * is "bcdbf", we should return 5 in this case.
 */

// TIME: O(n)
// SPACE: O(n)
public class LongestSubstringWithKRepeatingCharacters {
    // Return the length of the longest substring
    public int longest(String input, int k) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        char[] array = input.toCharArray();
        int leftBoundary = 0;
        int rightBoundary = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        while (rightBoundary <= array.length - 1) {
            int count = map.getOrDefault(array[rightBoundary], 0);
            if (count < k) {
                map.put(array[rightBoundary], count + 1);
                maxLength = Math.max(maxLength, rightBoundary++ - leftBoundary + 1);
            } else {
                count = map.get(array[leftBoundary]);
                if (count == 1) {
                    map.remove(array[leftBoundary++]);
                } else {
                    map.put(array[leftBoundary++], count - 1);
                }
            }
        }
        return maxLength;
    }

}