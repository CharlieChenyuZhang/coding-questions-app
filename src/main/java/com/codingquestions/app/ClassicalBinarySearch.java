package com.codingquestions.app;

// Problem:
// Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

// Assumptions

// There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
// Examples

// A = {1, 2, 3, 4, 5}, T = 3, return 2
// A = {1, 2, 3, 4, 5}, T = 6, return -1
// A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
// Corner Cases

// What if A is null or A is of zero length? We should return -1 in this case.

// Solution:
public class ClassicalBinarySearch {
    public int binarySearch(int[] array, int target) {
        // assume the array has been sorted in ascending order
        // we assume -1 when the size of array in 0 or target not
        // found
        if (array == null || array.length == 0) {
            return -1;
        }

        int l = 0; // left pointer
        int r = array.length - 1; // right pointer

        while (l <= r) {
            int m = l + (r - l) / 2; // middle pointer
            // case one: find the target
            if (array[m] == target) {
                return m;
            } else if (array[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
