package com.codingquestions.app.RecursionIandSortingAlgorithms;

// Problem:
/**
 * Given an array of integers, sort the elements in the array in ascending
 * order. The merge sort algorithm should be used to solve this problem.
 * 
 * Examples
 * 
 * {1} is sorted to {1} {1, 2, 3} is sorted to {1, 2, 3} {3, 2, 1} is sorted to
 * {1, 2, 3} {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6} Corner Cases
 * 
 * What if the given array is null? In this case, we do not need to do anything.
 * What if the given array is of length zero? In this case, we do not need to do
 * anything.
 */

// Solution:
// TIME: O(n logn)
// SPACE: O(n)

// see the question MergeSortLinkedList to sort using a LinkedList
public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        // allocate helper array to help merge step,
        // so that we guarantee no more than O(n) space is used. The space complexity is
        // O(n)
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    public void mergeSort(int[] array, int[] helper, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int mid = leftIndex + (rightIndex - leftIndex) / 2;
        mergeSort(array, helper, leftIndex, mid);
        mergeSort(array, helper, mid + 1, rightIndex);
        merge(array, helper, leftIndex, mid, rightIndex); // merging [left, mid], [mid + 1, right]
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        // copy the content to the helper array and we will merge from the helper array
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int indexLeft = left;
        int indexRight = mid + 1;
        int currentIndex = left;
        while (indexLeft <= mid || indexRight <= right) {
            // compare the value
            if (indexLeft > mid) {
                array[currentIndex] = helper[indexRight++];
            } else if (indexRight > right) {
                array[currentIndex] = helper[indexLeft++];
            } else {
                array[currentIndex] = helper[indexRight] >= helper[indexLeft] ? helper[indexLeft++]
                        : helper[indexRight++];
            }
            currentIndex++;
        }
    }

}
