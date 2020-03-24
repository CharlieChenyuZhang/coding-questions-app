package com.codingquestions.app.RecursionIandSortingAlgorithms;

// Problem:
/**
 * Given an array of integers, sort the elements in the array in ascending
 * order. The quick sort algorithm should be used to solve this problem.
 * 
 * Examples
 * 
 * {1} is sorted to {1} {1, 2, 3} is sorted to {1, 2, 3} {3, 2, 1} is sorted to
 * {1, 2, 3} {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6} Corner Cases
 * 
 * What if the given array is null? In this case, we do not need to do anything.
 * What if the given array is of length zero? In this case, we do not need to do
 * anything.
 * 
 */

// Solution:
// TIME: average O(n logn), worst case O(n^2)
// SPACE: O(logn), worst case O(n)
public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private int getPivot(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void quickSort(int[] array, int left, int right) {
        // !!! Remember to add this base case in
        if (left >= right) {
            return;
        }
        // pick a pivot
        int pivotIndex = getPivot(left, right);
        int pivotValue = array[pivotIndex];
        // swap the position of pivot and the last element
        // loop through each element, do the swapipign if necessary
        swap(array, pivotIndex, right);
        int leftPointer = left;
        int rightPointer = right - 1;

        // [left, leftPointer) <= pivot
        // [leftPointer, rightPointer] unknown
        // (rightPointer, right] > pivot
        while (leftPointer <= rightPointer) {
            // leftPointer <= pivot, leftPointer++
            // leftPointer > pivot
            // rightPointer <= pivot, swap(), rightPointer--
            // rightPointer > pivot, rightPointer--
            if (array[leftPointer] <= pivotValue) {
                leftPointer++;
            } else {
                if (array[rightPointer] <= pivotValue) {
                    swap(array, leftPointer, rightPointer);
                }
                rightPointer--;
            }
        }
        // !!! I can only swap with leftPointer here. You can figure it out by having an
        // example.
        // another reasonsing is that we are mainly using leftPointer as the primarary
        // pointer
        swap(array, right, leftPointer);
        quickSort(array, left, leftPointer - 1);
        quickSort(array, leftPointer + 1, right);
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

}
