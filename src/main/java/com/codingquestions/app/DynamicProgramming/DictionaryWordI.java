package com.codingquestions.app.DynamicProgramming;

import java.util.Set;
import java.util.HashSet;

/**
 * Given a word and a dictionary, determine if it can be composed by
 * concatenating words from the given dictionary.
 * 
 * Assumptions
 * 
 * The given word is not null and is not empty The given dictionary is not null
 * and is not empty and all the words in the dictionary are not null or empty
 * Examples
 * 
 * Dictionary: {“bob”, “cat”, “rob”}
 * 
 * Word: “robob” return false
 * 
 * Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
 */

public class DictionaryWordI {
    /**
     * 
     * i ← total number of characters in input we consider j ← number of characters
     * in left big chunk
     * 
     * M[i] represents whether the word from index [0, i - 1] can be composed using
     * the given dictionary. M[i] = true iff there exist a j in [0, i) s.t. M[j] &&
     * input.substring(j, i) is true
     * 
     */

    public boolean canBreak(String input, String[] dict) {
        Set<String> dictSet = toSet(dict);
        boolean[] M = new boolean[input.length() + 1];
        M[0] = true; // empty string

        for (int i = 1; i < M.length; i++) {
            boolean canBreak = false;
            for (int j = 0; j < i; j++) {
                if (M[j] && dictSet.contains(input.substring(j, i))) {
                    canBreak = true;
                    break;
                }
            }
            M[i] = canBreak;
        }
        return M[M.length - 1];
    }

    private Set<String> toSet(String[] dict) {
        Set<String> result = new HashSet<>();
        for (String s : dict) {
            result.add(s);
        }
        return result;
    }

}