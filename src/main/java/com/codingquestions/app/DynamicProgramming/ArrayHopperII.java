package com.codingquestions.app.DynamicProgramming;

/**
 * Given an array A of non-negative integers, you are initially positioned at
 * index 0 of the array. A[i] means the maximum jump distance from index i (you
 * can only jump towards the end of the array). Determine the minimum number of
 * jumps you need to reach the end of array. If you can not reach the end of the
 * array, return -1.
 * 
 * Assumptions
 * 
 * The given array is not null and has length of at least 1. Examples
 * 
 * {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the
 * end of array)
 * 
 * {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in
 * this case.
 */

// Analysis:
// M[i] represents the minimum number of jump from index i to the end of array

// e.g.
// 3 3 1 0 4
// M 2 1 -1 -1 0

// M[i] = 1 if array[i] + i >= array.length - 1
// = min(1 + M[j] for all j in [i+1, array.length - 1] && M[j] != -1)

// TIME: O(n^2)
// SPACE: O(n)
public class ArrayHopperII {
    public int minJump(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int[] M = new int[array.length];
        M[array.length - 1] = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] + i >= array.length - 1) {
                M[i] = 1;
                continue;
            }
            M[i] = -1;
            for (int j = array[i]; j >= 1; j--) {
                if (M[i + j] == -1) {
                    continue;
                } else {
                    M[i] = Math.min(M[i] == -1 ? Integer.MAX_VALUE : M[i], 1 + M[i + j]);
                }
            }
        }
        return M[0];
    }

}