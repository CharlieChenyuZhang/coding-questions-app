package com.codingquestions.app.DynamicProgramming;

/**
 * Given an array A of non-negative integers, you are initially positioned at
 * index 0 of the array. A[i] means the maximum jump distance from that position
 * (you can only jump towards the end of the array). Determine if you are able
 * to reach the last index.
 * 
 * Assumptions
 * 
 * The given array is not null and has length of at least 1. Examples
 * 
 * {1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then
 * reach the end of the array)
 * 
 * {2, 1, 1, 0, 2}, we are not able to reach the end of array
 */

public class ArrayHopperI {
    // M[i] represents whether I can jump from the index i to the end
    // M[i] = true iff there exists a j s.t. M[j] is true where j is in the range of
    // [0, array[i]]

    public boolean canJump(int[] array) {
        boolean[] M = new boolean[array.length];
        M[M.length - 1] = true;

        for (int i = M.length - 2; i >= 0; i--) { // index of curr ele
            for (int j = 1; j <= array[i]; j++) {// how many jumps
                if (i + j < array.length && M[i + j]) {
                    M[i] = true;
                }
            }
        }
        return M[0];
    }

}