
package com.codingquestions.app.DynamicProgramming;

/**
 * Given an unsorted integer array, find the subarray that has the greatest sum.
 * Return the sum and the indices of the left and right boundaries of the
 * subarray. If there are multiple solutions, return the leftmost subarray.
 * 
 * Assumptions
 * 
 * The given array is not null and has length of at least 1. Examples
 * 
 * {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5. The indices
 * of the left and right boundaries are 0 and 2, respectively.
 * 
 * {-2, -1, -3}, the largest subarray sum is -1. The indices of the left and
 * right boundaries are both 1
 * 
 * 
 * Return the result in a array as [sum, left, right]
 */

public class LargestSubArraySumII {
    public int[] largestSum(int[] array) {
        if (array.length == 1) {
            return new int[] { array[0], 0, 0 };
        }

        int globalLeft = 0;
        int globalRight = 0;
        int curLeft = 0;
        int[] M = new int[array.length];
        M[0] = array[0];
        int globalMax = array[0]; // globalMax = array[globalLeft] + array[globalLeft + 1] + … +
                                  // array[globalRight];

        for (int i = 1; i < array.length; i++) {
            if (M[i - 1] < 0) {
                curLeft = i;
                M[i] = array[i];
            } else {
                M[i] = M[i - 1] + array[i];
            }

            if (M[i] > globalMax) {
                globalLeft = curLeft;
                globalRight = i;
                globalMax = M[i];
            }
        }
        return new int[] { globalMax, globalLeft, globalRight };
    }
}