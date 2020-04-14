package com.codingquestions.app.HashTableAndStringI;

/**
 * Remove adjacent, repeated characters in a given string, leaving only one
 * character for each group of such characters.
 * 
 * Assumptions
 * 
 * Try to do it in place. Examples
 * 
 * “aaaabbbc” is transferred to “abc” Corner Cases
 * 
 * If the given string is null, returning null or an empty string are both
 * valid.
 */

// TIME: O(n)
// SPACE: O(1)
public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        if (input == null) {
            return input;
        }

        char[] array = input.toCharArray();
        int i = 0;
        for (int j = 0; j < input.length(); j++) {
            if (j > 0 && array[j] == array[j - 1]) {
                continue;
            }
            array[i++] = array[j];
        }
        return new String(array, 0, i);
    }

}