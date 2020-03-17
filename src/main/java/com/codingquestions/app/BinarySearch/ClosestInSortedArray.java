package com.codingquestions.app.BinarySearch;

// Problem:
// Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

// Assumptions

// There can be duplicate elements in the array, and we can return any of the indices with same value.
// Examples

// A = {1, 2, 3}, T = 2, return 1
// A = {1, 4, 6}, T = 3, return 1
// A = {1, 4, 6}, T = 5, return 1 or 2
// A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
// Corner Cases

// What if A is null or A is of zero length? We should return -1 in this case.

// Solution:
// TIME: O(log n)
// SPACE: O(1)
public class ClosestInSortedArray {
    public int closest(int[] array, int target) {
        // base case: when array is null or empty
        if (array == null || array.length == 0) {
            return -1;
        }

        // base case: when only one element
        if (array.length == 1) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;

        // I want to skip the look when left and right
        // pointers are next to each other
        // this will give me two elements left in the array
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                // result is on the right side
                left = mid; // cannot use mid + 1;
            } else {
                right = mid;
            }
        }

        // post-processing
        int leftDiff = Math.abs(array[left] - target);
        int rightDiff = Math.abs(array[right] - target);

        if (leftDiff <= rightDiff) {
            return left;
        } else {
            return right;
        }
    }

}
