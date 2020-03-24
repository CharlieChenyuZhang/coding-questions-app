package com.codingquestions.app.RecursionIandSortingAlgorithms;

// Problem:
/** */

// Solution:
// TIME: O(n^2)
// SPACE: O(1)
public class SelectionSort {
    public int[] sort(int[] array) {
        // baes case
        if (array == null || array.length == 0) {
            return array;
        }

        for (int i = 0; i <= array.length - 1; i++) {
            // index i points to the index of the first unsorted ele
            int minIndex = i;
            for (int j = i; j <= array.length - 1; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
        return array;
    }

    private void swap(int[] array, int i, int minIndex) {
        int tmpValue = array[i];
        array[i] = array[minIndex];
        array[minIndex] = tmpValue;
    }

}
