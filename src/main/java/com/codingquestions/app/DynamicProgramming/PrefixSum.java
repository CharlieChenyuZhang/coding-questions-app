package com.codingquestions.app.DynamicProgramming;

/**
 * Given an array, compute the sum between index i and j (i < j) in O(1) time.
 */

public class PrefixSum {
    int[] M; // M[i] represents the sum from index 0 → i

    public int prefixSum(int[] array, int i, int j) {
        // assume array has at least one element
        // assume i < j; i, j >= 0
        if (M == null) {
            computePrefixSum(array);
        }

        return M[j] - M[i] + array[i];
    }

    private void computePrefixSum(int[] array) {
        M[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            M[i] = M[i - 1] + array[i];
        }
    }
}
