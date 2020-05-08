package com.codingquestions.app.DynamicProgramming;

/**
 * Given an array containing only 0s and 1s, find the length of the longest
 * subarray of consecutive 1s.
 * 
 * Assumptions
 * 
 * The given array is not null Examples
 * 
 * {0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
 */

public class LongestConsecutive1s {
    // M[i] represents the longest consecutive 1s that ends with array[i]
    // M[i] = M[i - 1] + 1 if array[i] == 1
    // = 0 if array[i] == 0

    // TIME: O(n)
    // SPACE: O(1)

    public int longest(int[] array) {
        int prevLength = 0;
        int max = 0;
        for (int each : array) {
            if (each == 0) {
                prevLength = 0;
            } else {
                prevLength++;
            }
            max = Math.max(max, prevLength);
        }
        return max;
    }

}