package com.codingquestions.app.StringII;

/**
 * Given a string in compressed form, decompress it to the original string. The
 * adjacent repeated characters in the original string are compressed to have
 * the character followed by the number of repeated occurrences.
 * 
 * Assumptions
 * 
 * The string is not null
 * 
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 * 
 * There are no adjacent repeated characters with length > 9
 * 
 * Examples
 * 
 * “a1c0b2c4” → “abbcccc”
 */

// TIME: O(n)
public class DecompressStringII {
    // Note that if you are asked to do this in place, usually the input array is a
    // sufficient large one so you won't need to allocate a new array

    public String decompress(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        int newLength = 0;
        char[] array = input.toCharArray();

        // find the new length
        int i = 0;
        while (i <= array.length - 1) {
            // two cases
            // when the char is a digit
            if (Character.isDigit(array[i])) {
                int start = i;
                while (i <= array.length - 1 && Character.isDigit(array[i])) {
                    i++;
                }
                newLength += findInt(array, start, i - 1);
            } else {
                i++;
            }
        }

        // compose result
        char[] result = new char[newLength];
        int slow = 0;
        int fast = 0;
        while (fast <= array.length - 1) {
            char charValue = array[fast++]; // assume the first is always a char
            int start = fast;
            while (fast <= array.length - 1 && Character.isDigit(array[fast])) {
                fast++;
            }
            int count = findInt(array, start, fast - 1);

            while (count > 0) {
                result[slow++] = charValue;
                count--;
            }
        }
        return new String(result);
    }

    // convert the it to a number represented in the range [start, end]
    private int findInt(char[] array, int start, int end) {
        int result = 0;
        int len = end - start;
        for (int i = 0; i <= len; i++) {
            result += pow(10, i) * Character.getNumericValue(array[end]);
            end--;
        }
        return result;
    }

    private int pow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        int mid = pow(base, exponent / 2);
        if (exponent % 2 == 0) {
            return mid * mid;
        }
        return mid * mid * base;
    }

}