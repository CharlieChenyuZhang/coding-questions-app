package com.codingquestions.app.RecursionIandSortingAlgorithms;

// Problem:
/**
 * 
 * Given an array of balls, where the color of the balls can only be Red, Green
 * or Blue, sort the balls such that all the Red balls are grouped on the left
 * side, all the Green balls are grouped in the middle and all the Blue balls
 * are grouped on the right side. (Red is denoted by -1, Green is denoted by 0,
 * and Blue is denoted by 1).
 * 
 * Examples
 * 
 * {0} is sorted to {0} {1, 0} is sorted to {0, 1} {1, 0, 1, -1, 0} is sorted to
 * {-1, 0, 0, 1, 1} Assumptions
 * 
 * The input array is not null. Corner Cases
 * 
 * What if the input array is of length zero? In this case, we should not do
 * anything as well.
 */

// Solution:
// TIME: O(n)
// SPACE: O(1)
public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int i = 0;
        int j = 0;
        int k = array.length - 1;
        // [0, i), red -- -1
        // [i, j), green -- 0
        // [j, k], unknown
        // (k, end], blue -- 1
        while (j <= k) {
            if (array[j] == 0) {
                j++;
            } else if (array[j] == 1) {
                swap(array, j, k--);
            } else {
                swap(array, i++, j++);
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
