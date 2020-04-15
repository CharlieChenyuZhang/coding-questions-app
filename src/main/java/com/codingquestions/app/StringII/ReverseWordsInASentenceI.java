package com.codingquestions.app.StringII;

/**
 * Reverse the words in a sentence.
 * 
 * Assumptions
 * 
 * Words are separated by single space
 * 
 * There are no heading or tailing white spaces
 * 
 * Examples
 * 
 * “I love Google” → “Google love I”
 * 
 * Corner Cases
 * 
 * If the given string is null, we do not need to do anything.
 */

// TIME: O(n)
// SPACE: O(1)
public class ReverseWordsInASentenceI {
    public String reverseWords(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();
        // step 1: reverse the whole string
        reverse(array, 0, array.length - 1);

        // step 2: reverse each word
        // I want to loop through the array to find the start and end
        // index for each words

        // i --> start
        // j --> end
        int i = 0;
        for (int j = 0; j <= array.length; j++) {
            // case 1: j is not a empty space, j++
            // case 2: j is an empty space, reverse in [start, j - 1]
            // i = j + 1;

            if (j < array.length && array[j] != ' ') {
                continue;
            }

            reverse(array, i, j - 1);
            i = j + 1;
        }
        return new String(array);
    }

    // iterative solution
    private void reverse(char[] array, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] array, int one, int two) {
        char tmp = array[one];
        array[one] = array[two];
        array[two] = tmp;
    }

}