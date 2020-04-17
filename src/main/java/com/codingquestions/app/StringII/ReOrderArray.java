package com.codingquestions.app.StringII;

/**
 * Given an array of elements, reorder it as follow:
 * 
 * { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
 * 
 * { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1
 * }
 * 
 * Try to do it in place.
 * 
 * Assumptions
 * 
 * The given array is not null Examples
 * 
 * { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
 * 
 * { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
 * 
 * { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
 */

// TIME: O(n logn)
// SPACE: O(logn)
public class ReOrderArray {
    public int[] reorder(int[] array) {
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else {
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right) {
        int size = right - left + 1;
        // base case:
        if (size <= 2) {
            return;
        }

        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = mid + size / 4;

        reverse(array, leftMid, mid - 1);
        reverse(array, mid, rightMid - 1);
        reverse(array, leftMid, rightMid - 1);
        reorder(array, left, left + (leftMid - left) * 2 - 1);
        reorder(array, left + (leftMid - left) * 2, right);
    }

    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] array, int one, int two) {
        int tmp = array[one];
        array[one] = array[two];
        array[two] = tmp;
    }

}