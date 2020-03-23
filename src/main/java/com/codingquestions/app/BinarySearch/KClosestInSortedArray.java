package com.codingquestions.app.BinarySearch;

// Problem:
/**
 * Given a target integer T, a non-negative integer K and an integer array A
 * sorted in ascending order, find the K closest numbers to T in A.
 * 
 * Assumptions
 * 
 * A is not null K is guranteed to be >= 0 and K is guranteed to be <= A.length
 * Return
 * 
 * A size K integer array containing the K closest numbers(not indices) in A,
 * sorted in ascending order by the difference between the number and T.
 * Examples
 * 
 * A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1} A = {1, 4, 6, 8},
 * T = 3, K = 3, return {4, 1, 6}
 * 
 */

// Solution:
public class KClosestInSortedArray {

    // TIME: O(log n + k) // when k >> n, it lose the benefit of binary serach
    // SPACE: O(k)
    public int[] kClosestSolutionOne(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return array;
        }

        if (k == 0) {
            return new int[1];
        }

        int[] result = new int[k];
        int left = 0;
        int right = array.length - 1;

        // since I want to have two elements behind
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        for (int i = 0; i < k; i++) {
            if (left < 0) {
                result[i] = array[right];
                right++;
            } else if (right > array.length - 1) {
                result[i] = array[left];
                left--;
            } else {
                if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                    result[i] = array[left];
                    left--;
                } else {
                    result[i] = array[right];
                    right++;
                }
            }

        }
        return result;
    }
}
