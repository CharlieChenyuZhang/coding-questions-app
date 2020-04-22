package com.codingquestions.app.BitRepresentationAndOperation;

/**
 * Determine if the characters of a given string are all unique.
 * 
 * Assumptions
 * 
 * We are using ASCII charset, the value of valid characters are from 0 to 255
 * The given string is not null Examples
 * 
 * all the characters in "abA+\8" are unique "abA+\a88" contains duplicate
 * characters
 */

public class AllUniqueCharactersII {
    public boolean allUnique(String word) {
        int[] vector = new int[8];
        for (int i = 0; i < word.length(); i++) {
            char eachChar = word.charAt(i);
            int decimalRepresentation = (int) eachChar;
            int row = decimalRepresentation / 32;
            int column = decimalRepresentation % 32;
            if (((vector[row] >> column) & 1) == 1) {
                return false;
            } else {
                vector[row] |= (1 << column);
            }
        }
        return true;
    }

}