package com.codingquestions.app.RecursionIandSortingAlgorithms;

// Problem:
/**
 * Given an array of integers, move all the 0s to the right end of the array.
 * 
 * The relative order of the elements in the original array does not need to be
 * maintained.
 * 
 * Assumptions:
 * 
 * The given array is not null. Examples:
 * 
 * {1} --> {1} {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1,
 * 1, 0, 0}
 */

// Solution:
// TIME:
// SPACE:
public class Move0sToTheEndI {
    public int[] moveZero(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            // if (array[left] != 0) {
            // if (array[right] != 0) {
            // left++;
            // } else {
            // right--;
            // left++;
            // }
            // } else {
            // if (array[right] == 0) {
            // right--;
            // } else {
            // swap(array, left, right);
            // right--;
            // left++;
            // }
            // }

            // a better way to write the condition
            if (array[left] != 0) {
                left++;
            } else if (array[right] == 0) {
                right--;
            } else {
                swap(array, left++, right--);
            }
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

}
