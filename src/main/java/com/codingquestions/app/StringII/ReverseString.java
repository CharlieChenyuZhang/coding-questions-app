package com.codingquestions.app.StringII;

/**
 * Reverse a given string.
 * 
 * Assumptions
 * 
 * The given string is not null.
 */

public class ReverseString {
    // iterative solution
    // TIEM: O(n)
    // SPACE: O(1)

    public String reverse(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();

        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            swap(array, i, j);

        }

        return new String(array);
    }

    // recursive solution:
    // TIME: O(n)
    // SPACE: O(n)
    public String reverse2(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        return new String(helper(input.toCharArray(), 0, input.length() - 1));
    }

    // we are working on the [left, right] in array
    private char[] helper(char[] array, int left, int right) {
        // base case
        if (left >= right) {
            return array;
        }

        // outside the base case, I want to make sure there are
        // at least two characters in the input

        // recursive rule
        swap(array, left, right);
        return helper(array, left + 1, right - 1);
    }

    private void swap(char[] array, int one, int two) {
        char tmp = array[one];
        array[one] = array[two];
        array[two] = tmp;
    }

}