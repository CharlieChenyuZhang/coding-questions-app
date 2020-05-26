package com.codingquestions.app.DFSII;

/**
 * Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ....,
 * k - 1, k - 1, k, k], such that the output integer array satisfy this
 * condition:
 * 
 * Between each two i's, they are exactly i integers (for example: between the
 * two 1s, there is one number, between the two 2's there are two numbers).
 * 
 * If there does not exist such sequence, return null.
 * 
 * Assumptions:
 * 
 * k is guaranteed to be > 0 Examples:
 * 
 * k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
 */

public class KeepDistanceForIdenticalElements {
    // recursion tree has k level and dynamic number of branches
    public int[] keepDistance(int k) {
        int[] array = new int[2 * k];
        return helper(array, k) ? array : null;
    }

    private boolean helper(int[] array, int k) {
        // base case
        if (k == 0) {
            return true;
        }

        // I place number k in index i
        for (int i = 0; i < array.length - k - 1; i++) {
            if (array[i] == 0 && array[i + k + 1] == 0) {
                array[i] = k;
                array[i + k + 1] = k;
                if (helper(array, k - 1)) {
                    return true;
                }
                array[i] = 0;
                array[i + k + 1] = 0;
            }
        }
        return false;
    }

}