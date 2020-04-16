package com.codingquestions.app.StringII;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

/**
 * Given a string with possible duplicate characters, return a list with all
 * permutations of the characters.
 * 
 * Examples
 * 
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "aba", all permutations are ["aab", "aba", "baa"] Set = "", all
 * permutations are [""] Set = null, all permutations are []
 */

public class AllPermutationsII {
    // TIME: O(n!)
    // SPACE: O(n^2)
    public List<String> permutations(String input) {
        List<String> result = new ArrayList<>();
        char[] array = input.toCharArray();
        helper(array, 0, result);
        return result;
    }

    // sb → we use this to build the result
    private void helper(char[] array, int startIndex, List<String> result) {
        // base case, when startIndex points to the last ele
        if (startIndex == array.length) {
            result.add(new String(array));
            return;
        }

        HashSet<Character> charUsedSoFar = new HashSet<>();
        // recursive rule
        // swapping startIndex <-> endIndex
        for (int endIndex = startIndex; endIndex <= array.length - 1; endIndex++) {
            if (charUsedSoFar.add(array[endIndex])) {
                swap(array, startIndex, endIndex);
                helper(array, startIndex + 1, result);
                swap(array, startIndex, endIndex); // swap it back
            }
        }
    }

    private void swap(char[] array, int one, int two) {
        char tmp = array[one];
        array[one] = array[two];
        array[two] = tmp;
    }

}