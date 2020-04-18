
package com.codingquestions.app.StringII.ThreeSlidingWIndowQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the longest substring without any repeating characters
 * and return the length of it. The input string is guaranteed to be not null.
 * 
 * For example, the longest substring without repeating letters for "bcdfbd" is
 * "bcdf", we should return 4 in this case.
 */

// TIME: O(n)
// SPACE: O(n)
public class LongestSubstringWithKRepeatingCharacters {
    // FIXME:
    // Return the length of the longest substring
    // TIME: O(n)
    // SPACE: O(n)
    public int longest(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        char[] array = input.toCharArray();
        int leftBoundary = 0;
        int rightBoundary = 0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;

        while (rightBoundary <= array.length - 1) {
            if (set.add(array[rightBoundary])) {
                maxLength = Math.max(maxLength, rightBoundary++ - leftBoundary + 1);
            } else {
                set.remove(array[leftBoundary++]);
            }
        }
        return maxLength;
    }

}