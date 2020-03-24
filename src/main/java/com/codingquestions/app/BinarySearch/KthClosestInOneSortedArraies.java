package com.codingquestions.app.BinarySearch;

import java.util.Arrays;
import com.codingquestions.app.BinarySearch.KthClosestInTwoSortedArraies;

public class KthClosestInOneSortedArraies {
    // after we divide the the array into two, we use the solution in
    // KthClosestInTwoSortedArraies

    // TIME: O(log n + log k)
    // SPACE: O(1) because we can do everything in place. The below implementation
    // didn't
    // use extra space for ease of implementation
    public int kClosestSolutionTwo(int[] array, int target, int k) {

        if (array == null || array.length == 0) {
            return -1;
        }

        // run binary search to find the index of the cloest element to target
        int closestIndex = closest(array, target);
        if (closestIndex == -1) {
            return -1;
        }

        // divide the array to two halfs FIXME: I can do this in place
        int[] left = Arrays.copyOfRange(array, 0, closestIndex);
        int[] right = Arrays.copyOfRange(array, closestIndex, array.length); // [from, to)

        // calculate the offset to target, revert the first offset array so we have two
        // sorted offset arrays in ascending order
        computeOffsetArray(left, target);
        reverseOrder(left);
        computeOffsetArray(right, target);

        // then, use the same algorithems in the question KClosestInTwoSortedArraies and
        // remember to dump the unwanted elements to the result array
        KthClosestInTwoSortedArraies myClass = new KthClosestInTwoSortedArraies();
        return myClass.kthMethodTwo(left, right, k);
    }

    private int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        // I can't have left <= right - 1 because of infinit loop. Try the example with
        // two elements
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid; // can I do mid + 1? no, because we want to find the closest element.
            } else {
                right = mid; // can I do mid - 1? no.
            }
        }

        // one element case? it's fine because left and right just pointing to the same
        // element

        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
            return left;
        } else {
            return right;
        }

    }

    private void computeOffsetArray(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            array[i] = target - array[i];
        }
    }

    private void reverseOrder(int[] array) {
        int[] copy = array.clone();
        for (int i = 0; i < array.length; i++) {
            array[i] = copy[array.length - i - 1];
        }
    }
}