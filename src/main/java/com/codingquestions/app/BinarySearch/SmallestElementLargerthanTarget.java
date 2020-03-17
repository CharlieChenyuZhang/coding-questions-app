package com.codingquestions.app.BinarySearch;

// Problem:
/**
 * Given a target integer T and an integer array A sorted in ascending order,
 * find the index of the smallest element in A that is larger than T or return
 * -1 if there is no such index.
 *
 * Assumptions
 * 
 * There can be duplicate elements in the array.
 * 
 * 
 * 
 * Examples
 * 
 * A = {1, 2, 3}, T = 1, return 1
 * 
 * A = {1, 2, 3}, T = 3, return -1
 * 
 * A = {1, 2, 2, 2, 3}, T = 1, return 1
 * 
 * 
 * Corner Cases
 * 
 * What if A is null or A of zero length? We should return -1 in this case.
 * 
 */

// Solution:
// TIME: O(log n)
// SPACE: O(1)
public class SmallestElementLargerthanTarget {
    public int smallestElementLargerThanTarget(int[] array, int target) {
        // base case
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                left = mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (array[left] > target) {
            return left;
        } else if (array[right] > target) {
            return right;
        }

        return -1;
    }

}
