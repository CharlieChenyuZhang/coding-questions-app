package com.codingquestions.app.DynamicProgramming;

/**
 * Given an unsorted array, find the length of the longest subarray in which the
 * numbers are in ascending order.
 * 
 * Assumptions
 * 
 * The given array is not null Examples
 * 
 * {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length
 * is 4.
 * 
 * {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
 */

public class LongestAscendingSubArray {
    /**
     * M[i] represents the longest ascending subArray from index 0 to index i
     * including the element array[i] M[i] = M[i-1] + 1 if array[i] > array[i - 1];
     * = 1 otherwise
     */

    // TIME: O(n)
    // SPACE: O(n) → can be improved on O(1)
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int[] M = new int[array.length];
        M[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                M[i] = M[i - 1] + 1;
            } else {
                M[i] = 1;
            }

            if (M[i] > maxLength) {
                maxLength = M[i];
            }
        }

        return maxLength;
    }

    // SPACE: O(1)
    public int longestII(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int prev = 1;
        int maxLength = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                prev += 1;
            } else {
                prev = 1;
            }

            if (prev > maxLength) {
                maxLength = prev;
            }
        }
        return maxLength;
    }

    // sliding window
    // semantics [left, right) is the window that contains result
    public int longestIII(int[] array) {
        if (array == null) {
            return -1;
        }

        if (array.length == 0) {
            return 0;
        }

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < array.length; right++) {
            if (right == 0 || array[right] > array[right - 1]) {
                maxLength = Math.max(right - left + 1, maxLength);
            } else {
                left = right;
            }
        }
        return maxLength;
    }

}