package com.codingquestions.app.BinarySearch;

// Problem:
// Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The first element of next row is larger than (or equal to) the last element of previous row.

// Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.

// Assumptions:

// The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
// Examples:

// matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }

// target = 7, return {1, 2}

// target = 6, return {-1, -1} to represent the target number does not exist in the matrix.

// Solution:
// TIME: O(log M x N)
// SPACE:  O(1)
public class SearchInSortedMatrixI {
    public int[] search(int[][] matrix, int target) {
        int[] result = { -1, -1 };

        // base case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int[] left = { 0, 0 };
        int[] right = { rows - 1, columns - 1 };

        while (left[0] <= right[0] && left[1] <= right[1]) {
            int leftIndex = left[0] * columns + left[1];
            int rightIndex = right[0] * columns + right[1];
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            int[] mid = { midIndex / columns, midIndex % columns };
            int midValue = matrix[mid[0]][mid[1]];

            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                // take the right part
                // left = mid
                int[] next = { (midIndex + 1) / columns, (midIndex + 1) % columns };
                left[0] = next[0];
                left[1] = next[1];
            } else {
                // take the left part
                int[] next = { (midIndex - 1) / columns, (midIndex - 1) % columns };
                right[0] = next[0];
                right[1] = next[1];
            }
        }
        return result;
    }

}
