package com.codingquestions.app.DFSII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing
 * all subsets of the characters whose size is K. Notice that each subset
 * returned will be sorted for deduplication.
 * 
 * 
 * 
 * Assumptions
 * 
 * There could be duplicate characters in the original set.
 * 
 * ​
 * 
 * Examples
 * 
 * Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
 * 
 * Set = "abb", K = 2, all the subsets are [“ab”, “bb”].
 * 
 * Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].
 * 
 * Set = "", K = 0, all the subsets are [""].
 * 
 * Set = "", K = 1, all the subsets are [].
 * 
 * Set = null, K = 0, all the subsets are [].
 */

public class AllSubsetsIIofSizeK {
    public List<String> subSetsIIOfSizeK(String set, int k) {
        // assumption: k >= 0
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        // NOTE: make sure it's sorted so that we can dedup
        Arrays.sort(arraySet);
        StringBuilder sb = new StringBuilder();
        helper(result, sb, 0, arraySet, k);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, int index, char[] set, int k) {
        // base case
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }

        if (index == set.length) {
            return;
        }

        // recursive rule
        // case 1
        helper(result, sb.append(set[index]), index + 1, set, k);
        sb.deleteCharAt(sb.length() - 1);

        // skip all dup elements
        while (index < set.length - 1 && set[index] == set[index + 1]) {
            index++;
        }

        // case 2
        helper(result, sb, index + 1, set, k);
    }

}