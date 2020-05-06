package com.codingquestions.app.DynamicProgramming;

/**
 * Given an unsorted integer array, find the subarray that has the greatest sum.
 * Return the sum.
 * 
 * Assumptions
 * 
 * The given array is not null and has length of at least 1. Examples
 * 
 * {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
 * 
 * {-2, -1, -3}, the largest subarray sum is -1
 */

// M[i] represents the largest subarray sum that includes the index i
// M[i] = array[i] if M[i-1] <= 0
// = M[i - 1] + array[i]

public class LargestSubArraySum {
    // TIME: O(n)
    // SPACE: O(1)
    public int largestSum(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        int prevSum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            prevSum = Math.max(prevSum + array[i], array[i]);
            maxSum = Math.max(maxSum, prevSum);
        }
        return maxSum;
    }

}