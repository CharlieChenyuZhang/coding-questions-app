package com.codingquestions.app.HeapandGraphSearchBFS;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

/**
 * Find the K smallest numbers in an unsorted integer array A. The returned
 * numbers should be in ascending order.
 * 
 * Assumptions
 * 
 * A is not null K is >= 0 and smaller than or equal to size of A Return
 * 
 * an array with size K containing the K smallest numbers in ascending order
 * Examples
 * 
 * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 */

public class KSmallestInUnsortedArray {
    // method1: using minHeap
    // assume: 1) array is not null 2) k >= 0 3) k <= arrya.length

    // TIME: O(nlogn + klogn) = O((n+k)logn)
    // SPACE: O(n)
    public int[] kSmallest1(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(array[i]);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    // method 2: maxHeap recommended
    // TIME: O(nlog(k) + klog(k)) = O((n + k)log(k))
    // SPACE: O(k)
    public int[] kSmallest2(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }

                return o1 > o2 ? -1 : 1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            } else {
                if (array[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);

                }
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    // method 3:
    // quick select
    // TIME: worst case O(n^2), average case O(n + n/2 + n/4 + ...) = O(1)
    public int[] kSmallest(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }

        // after this function call
        // I know the first k elements are the smallest k elements
        quickSelect(array, 0, array.length - 1, k - 1);

        int[] result = Arrays.copyOf(array, k);
        Arrays.sort(result);
        return result;
    }

    // target is the index of the kth smallest element in [left, right]
    private void quickSelect(int[] array, int left, int right, int target) {
        // return the index of the pivot
        // elements that are before the pivot are smaller than it
        int pivotIndex = partition(array, left, right);
        if (pivotIndex == target) {
            return;
        } else if (target < pivotIndex) {
            quickSelect(array, left, pivotIndex - 1, target);
        } else {
            quickSelect(array, pivotIndex + 1, right, target);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = getPivotIndex(left, right);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);

        int start = left;
        int end = right - 1;

        while (start <= end) {
            if (array[start] < pivot) {
                start++;
            } else if (array[end] > pivot) {
                end--;
                ;
            } else {
                swap(array, start++, end--);
            }
        }
        swap(array, start, right);
        return start;
    }

    private int getPivotIndex(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

}