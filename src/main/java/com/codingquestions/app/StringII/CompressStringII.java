package com.codingquestions.app.StringII;

/**
 * Given a string, replace adjacent, repeated characters with the character
 * followed by the number of repeated occurrences.
 * 
 * Assumptions
 * 
 * The string is not null
 * 
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 * 
 * Examples
 * 
 * “abbcccdeee” → “a1b2c3d1e3”
 */

public class CompressStringII {
    public String compress(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] array = input.toCharArray();
        return encode(array);
    }

    private String encode(char[] array) {
        // step 1: from left to right, handle duplicate characters
        int slow = 0;
        int fast = 0;
        int newLength = 0;
        while (fast <= array.length - 1) {
            int begin = fast;
            while (fast <= array.length - 1 && array[fast] == array[begin]) {
                fast++;
            }
            array[slow++] = array[begin];
            if (fast - begin == 1) {
                newLength += 2;
            } else {
                int len = copyDigits(array, slow, fast - begin);
                slow += len;
                newLength += len + 1;
            }
        }

        // if it is required to do this in place, usuaslly the input
        // array is a sufficiently large one
        char[] result = new char[newLength];
        fast = slow - 1;
        slow = newLength - 1;
        while (fast >= 0) {
            if (Character.isDigit(array[fast])) {
                while (fast >= 0 && Character.isDigit(array[fast])) {
                    result[slow--] = array[fast--];
                }
            } else {
                result[slow--] = '1';
            }
            result[slow--] = array[fast--];
        }
        return new String(result);
    }

    private int copyDigits(char[] array, int index, int count) {
        int len = 0;

        for (int i = count; i > 0; i /= 10) {
            index++;
            len++;
        }

        for (int i = count; i > 0; i /= 10) {
            int digit = i % 10;
            array[--index] = (char) ('0' + digit);
        }
        return len;
    }
}