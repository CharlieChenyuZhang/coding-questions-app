package com.codingquestions.app.DFSII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string with no duplicate characters, return a list with all
 * permutations of the string and all its subsets.
 * 
 * 
 * 
 * Examples
 * 
 * Set = “abc”, all permutations are [“”, “a”, “ab”, “abc”, “ac”, “acb”, “b”,
 * “ba”, “bac”, “bc”, “bca”, “c”, “cb”, “cba”, “ca”, “cab”].
 * 
 * Set = “”, all permutations are [“”].
 * 
 * Set = null, all permutations are [].
 * 
 * 
 */

public class AllPermutationsofSubsets {
    public List<String> allPermutationsOfSubsets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }

        // NOTE: DFS string problem, I convert it to CharArray because
        // its easier to swap
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    private void helper(char[] array, int index, List<String> result) {
        // every state is a valid permutation
        // note that I don't need to specify the return here in
        // the base case because it won't go inside the while loop
        result.add(new String(array, 0, index));

        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            helper(array, index + 1, result);
            swap(array, i, index);
        }
    }

    private void swap(char[] array, int one, int two) {
        char tmp = array[one];
        array[one] = array[two];
        array[two] = tmp;
    }

}