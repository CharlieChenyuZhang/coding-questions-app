package com.codingquestions.app.DynamicProgramming;

/**
 * Given two strings of alphanumeric characters, determine the minimum number of
 * Replace, Delete, and Insert operations needed to transform one string into
 * the other.
 * 
 * Assumptions
 * 
 * Both strings are not null Examples
 * 
 * string one: “sigh”, string two : “asith”
 * 
 * the edit distance between one and two is 2 (one insert “a” at front then
 * replace “g” with “t”).
 */

public class EditDistance {
    // TIME: O(m * n)
    // SPACE: O(m * n) → O(max(m, n))
    public int editDistance(String one, String two) {
        // each column is each character in one
        // each row is each character in two
        int[] prevRow = new int[one.length() + 1];
        int[] currRow = new int[one.length() + 1];
        for (int i = 0; i < prevRow.length; i++) {
            prevRow[i] = i;
        }

        for (int i = 1; i < two.length() + 1; i++) { // rowIndex
            currRow[0] = i;
            for (int j = 1; j < one.length() + 1; j++) {// ColIndex
                if (one.charAt(j - 1) == two.charAt(i - 1)) {
                    currRow[j] = prevRow[j - 1];
                } else {
                    currRow[j] = 1 + Math.min(currRow[j - 1], Math.min(prevRow[j], prevRow[j - 1]));
                }
            }

            // copy(currRow, prevRow); // NOTE: I don't need to deep copy here. Swap
            // reference instead
            int[] temp = prevRow;
            prevRow = currRow;
            currRow = temp;
        }
        return prevRow[prevRow.length - 1];
    }

    private void copy(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }
}
