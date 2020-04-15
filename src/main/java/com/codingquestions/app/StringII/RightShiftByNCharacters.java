package com.codingquestions.app.StringII;

/**
 * Right shift a given string by n characters.
 * 
 * Assumptions
 * 
 * The given string is not null. n >= 0. Examples
 * 
 * "abc", 4 -> "cab"
 */

public class RightShiftByNCharacters {
    // Time: O(n)
    // Space: O(1)
    public String rightShift(String input, int n) {
        if (n == 0 || input == null || input.length() <= 1) {
            return input;
        }

        int shift = n % input.length();
        char[] array = input.toCharArray();

        // reverse the whole input
        reverse(array, 0, array.length - 1);
        reverse(array, 0, shift - 1);
        reverse(array, shift, array.length - 1);
        return new String(array);
    }

    // reverse the array in the range of [start, end]
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] array, int one, int two) {
        char tmp = array[one];
        array[one] = array[two];
        array[two] = tmp;
    }

}