package com.codingquestions.app.HashTableAndStringI;

/**
 * Given a string, remove all leading/trailing/duplicated empty spaces.
 * 
 * Assumptions:
 * 
 * The given string is not null. Examples:
 * 
 * “ a” --> “a” “ I love MTV ” --> “I love MTV”
 */

// TIME: O(n)
// SPACE: O(1)
public class RemoveSpaces {
    public String removeSpaces(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        char[] array = input.toCharArray();

        int slow = 0;

        for (int fast = 0; fast < input.length(); fast++) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                continue;
            }
            array[slow++] = array[fast];
        }

        // post-processing
        if (slow - 1 > 0 && array[slow - 1] == ' ') {
            slow--;
        }

        return new String(array, 0, slow);
    }

}