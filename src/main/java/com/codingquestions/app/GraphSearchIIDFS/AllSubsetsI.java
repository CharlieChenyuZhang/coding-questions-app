package com.codingquestions.app.GraphSearchIIDFS;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a set of characters represented by a String, return a list containing
 * all subsets of the characters.
 * 
 * Assumptions
 * 
 * There are no duplicate characters in the original set. ​Examples
 * 
 * Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
 * Set = "", all the subsets are [""] Set = null, all the subsets are []
 */

// TIME: O(2^n)
// SPACE: O(n)
public class AllSubsetsI {
    public List<String> subSets(String set) {
        // 3 levels in the recursion tree
        // two branches for each node
        List<String> result = new ArrayList<>();

        if (set == null) {
            return result;
        }

        char[] charArray = set.toCharArray();

        // this helper will add satisfying results to the result
        StringBuilder sb = new StringBuilder();
        helper(result, charArray, 0, sb);
        return result;
    }

    // index → current char that we are looking at
    // sb → the string that we have built so far
    private void helper(List<String> result, char[] charArray, int index, StringBuilder sb) {
        // base case: when we reach the bottom
        if (index == charArray.length) {
            result.add(sb.toString());
            return;
        }

        // recursive rules
        helper(result, charArray, index + 1, sb);
        sb.append(charArray[index]);
        helper(result, charArray, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

    }

}