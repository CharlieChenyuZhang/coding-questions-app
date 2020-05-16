package com.codingquestions.app.DFSII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing
 * all subsets of the characters whose size is K.
 * 
 * Assumptions
 * 
 * There are no duplicate characters in the original set.
 * 
 * ​Examples
 * 
 * Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
 * 
 * Set = "", K = 0, all the subsets are [""].
 * 
 * Set = "", K = 1, all the subsets are [].
 */

public class AllSubsetsofSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        int level = 0;
        helper(result, set, level, sb, k);
        return result;
    }

    private void helper(List<String> result, String set, int level, StringBuilder sb, int k) {
        // base case
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }

        if (level == set.length()) {
            return;
        }

        // case 1: we don't add char to the sb
        helper(result, set, level + 1, sb, k);

        // case 2: we add char at level to the sb
        helper(result, set, level + 1, sb.append(set.charAt(level)), k);
        // remember to spit out the char
        sb.deleteCharAt(sb.length() - 1);
    }

}