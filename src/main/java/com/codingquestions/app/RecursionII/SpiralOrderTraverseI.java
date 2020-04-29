package com.codingquestions.app.RecursionII;

import java.util.List;
import java.util.ArrayList;

/**
 * Traverse an N * N 2D array in spiral order clock-wise starting from the top
 * left corner. Return the list of traversal sequence.
 * 
 * Assumptions
 * 
 * The 2D array is not null and has size of N * N where N >= 0 Examples
 * 
 * { {1, 2, 3},
 * 
 * {4, 5, 6},
 * 
 * {7, 8, 9} }
 * 
 * the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */

// TIME: O(n^2)
// SPACE: O(n^2) to store the result
public class SpiralOrderTraverseI {
    // Recursive traversal
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        helper(matrix, 0, matrix.length, result);
        return result;
    }

    private void helper(int[][] matrix, int offset, int size, List<Integer> result) {
        // base case
        if (size == 0) {
            return;
        }

        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }

        // recursive rule
        // row
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset][offset + i]);
        }

        // column
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset + i][offset + size - 1]);
        }

        // reverse row
        for (int i = size - 1; i >= 1; i--) {
            result.add(matrix[offset + size - 1][offset + i]);
        }

        // reverse column
        for (int i = size - 1; i >= 1; i--) {
            result.add(matrix[offset + i][offset]);
        }

        helper(matrix, offset + 1, size - 2, result);
    }

    // Iterative traversal
    public List<Integer> spiralII(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int size = matrix.length;
        int offset = 0;
        while (size >= 0) {

            if (size == 0) {
                return result;
            }

            if (size == 1) {
                result.add(matrix[offset][offset]);
                return result;
            }
            for (int i = 0; i < size - 1; i++) {
                result.add(matrix[offset][offset + i]);
            }

            // column
            for (int i = 0; i < size - 1; i++) {
                result.add(matrix[offset + i][offset + size - 1]);
            }

            // reverse row
            for (int i = size - 1; i >= 1; i--) {
                result.add(matrix[offset + size - 1][offset + i]);
            }

            // reverse column
            for (int i = size - 1; i >= 1; i--) {
                result.add(matrix[offset + i][offset]);
            }

            offset++;
            size -= 2;
        }
        return result;
    }

}