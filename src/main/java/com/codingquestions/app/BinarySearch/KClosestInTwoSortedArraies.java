package com.codingquestions.app.BinarySearch;

// Problem:
/**
 * Given two sorted arrays of integers, find the Kth smallest number.
 * 
 * Assumptions
 * 
 * The two given arrays are not null and at least one of them is not empty
 * 
 * K >= 1, K <= total lengths of the two sorted arrays
 * 
 * Examples
 * 
 * A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
 * 
 * A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
 */

// Solution:
public class KClosestInTwoSortedArraies {

    // two pointers, from left to right, move the smaller one
    // TIME: O(k)
    // SPACE: O(1)
    public Integer kthMethodOne(int[] a, int[] b, int k) {
        int pointerA = 0;
        int pointerB = 0;

        for (int i = 0; i < k - 1; i++) {
            // if both pointers are out of bound, we can't find the answer
            if (pointerA > a.length - 1 && pointerB > b.length - 1) {
                return -1;
            }

            if (pointerA > a.length - 1) {
                pointerB++;
            } else if (pointerB > b.length - 1) {
                pointerA++;
            } else {
                if (a[pointerA] >= b[pointerB]) {
                    pointerB++;
                } else {
                    pointerA++;
                }
            }
        }

        if (pointerA > a.length - 1) {
            return b[pointerB];
        } else if (pointerB > b.length - 1) {
            return a[pointerA];
        } else {
            return b[pointerB] > a[pointerA] ? a[pointerA] : b[pointerB];
        }
    }

    // TIME: O(log k) reason: k -> k/2 -> k/4 -> ... -> 1 (we are doing this log k
    // times)
    // SPACE: O(1)
    public Integer kthMethodTwo(int[] a, int[] b, int k) {
        return kthMethodTwoHelper(a, b, k, 0, 0);
    }

    // for aleft and bleft, we haven’t explored them yet
    private Integer kthMethodTwoHelper(int[] a, int[] b, int k, int aleft, int bleft) {
        // 3 base cases
        // when aleft is out of bound
        if (aleft > a.length - 1) {
            return b[bleft + k - 1];
        }
        // when bleft is out of bound
        if (bleft > b.length - 1) {
            return a[aleft + k - 1];
        }

        // this is a base case because when we calculate mid, if k == 1
        // amid = aleft - 1;
        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }

        int amid = aleft + k / 2 - 1;
        int bmid = bleft + k / 2 - 1;
        int aval = amid > a.length - 1 ? Integer.MAX_VALUE : a[amid];
        int bval = bmid > b.length - 1 ? Integer.MAX_VALUE : b[bmid];

        if (aval <= bval) {
            return kthMethodTwoHelper(a, b, k - k / 2, amid + 1, bleft); // note: this is `k - k / 2` and not `k / 2`
        } else {
            return kthMethodTwoHelper(a, b, k - k / 2, aleft, bmid + 1);
        }

    }

}
