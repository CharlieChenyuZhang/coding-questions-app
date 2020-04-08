package com.codingquestions.app.BinarySearch;

import com.codingquestions.app.utils.MyDict;

// Problem:
/**
 * Given a integer dictionary A of unknown size, where the numbers in the
 * dictionary are sorted in ascending order, determine if a given target integer
 * T is in the dictionary. Return the index of T in A, return -1 if T is not in
 * A.
 * 
 * Assumptions
 * 
 * dictionary A is not null dictionary.get(i) will return
 * null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds Examples A =
 * {1, 2, 5, 9, ......}, T = 5, return 2 A = {1, 2, 5, 9, 12, ......}, T = 7,
 * return -1
 * 
 */

// Solution:
// TIME:
// SPACE:

public class SearchInUnknownSizedSortedArray {

    public int search(MyDict dict, int target) {
        // grow the search space exponentially
        int searchSize = 1;

        // improves the performance
        while (dict.get(searchSize - 1) != null && dict.get(searchSize - 1) < target) {
            searchSize = getSearchSize(searchSize);
        }

        return binarySearch(dict, target, searchSize);
    }

    private int getSearchSize(int currentSize) {
        return 10 * currentSize;
    }

    private int binarySearch(MyDict dict, int target, int searchSize) {
        int left = 0;
        int right = searchSize - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null) {
                right = mid - 1; // note: this step will increase the run-time in coding platform
            } else {
                if (dict.get(mid) == target) {
                    return mid;
                } else if (dict.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
