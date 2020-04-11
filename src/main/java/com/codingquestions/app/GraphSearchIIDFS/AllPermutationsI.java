package com.codingquestions.app.GraphSearchIIDFS;

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 * Given a string with no duplicate characters, return a list with all
 * permutations of the characters.
 * 
 * Assume that input string is not null.
 * 
 * Examples
 * 
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * 
 * Set = "", all permutations are [""]
 */

// TIME: O(n!)
// SPACE: O(n)
public class AllPermutationsI {
    public List<String> permutations(String input) {
        List<String> result = new ArrayList<>();
        char[] inputArray = input.toCharArray();
        helper(inputArray, 0, result);
        return result;
    }

    // input → input string
    // index → index of the current characters
    // sb → the result we have so far
    // result → a list of result
    private void helper(char[] input, int index, List<String> result) {
        // base case, we exist when we reach the bottom layer
        if (index == input.length) {
            result.add(new String(input));
            return;
        }

        // recursive ruls
        for (int i = index; i <= input.length - 1; i++) {
            swap(input, index, i);
            helper(input, index + 1, result);
            swap(input, index, i); // I need to swap it back
        }
    }

    private void swap(char[] input, int one, int two) {
        char tmp = input[one];
        input[one] = input[two];
        input[two] = tmp;
    }

}