package com.codingquestions.app.RecursionII;

import java.util.List;
import java.util.ArrayList;

/**
 * Traverse an M * N 2D array in spiral order clock-wise starting from the top
 * left corner. Return the list of traversal sequence.
 * 
 * Assumptions
 * 
 * The 2D array is not null and has size of M * N where M, N >= 0 Examples
 * 
 * { {1, 2, 3, 4},
 * 
 * {5, 6, 7, 8},
 * 
 * {9, 10, 11, 12} }
 * 
 * the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 */

// TIME: O(mn)
// SPACE: O(mn)

/**
 * we follow this order to print iteratively aaaaaaaa z??????b d??????b cccccccc
 * 
 * // to solve this question systematically, we consider 4 cases // case 1: rows
 * and columns are both even numbers // case 2: rows and columns are both odd
 * numbers // case 3: rows is even and columns is odd // case 4: rows is odd and
 * columns is even
 * 
 */
public class SpiralOrderTraverseII {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int rows = matrix.length;
        if (rows == 0) {
            return list;// otherwise matrix[0].length is NPE
        }

        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int up = 0;
        int down = rows - 1;

        while (left < right && up < down) {
            // row
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }

            // column
            for (int i = up + 1; i <= down - 1; i++) {
                list.add(matrix[i][right]);
            }

            // reverse row
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }

            // reverse column
            for (int i = down - 1; i >= up + 1; i--) {
                list.add(matrix[i][left]);
            }

            left++;
            right--;
            up++;
            down--;
        }

        // after the while loop left >= right || up >= down
        // if nothing left
        if (left > right || up > down) {
            return list;
        }

        // if we have one column left
        if (left == right) {
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][left]);
            }
        } else {
            // one row left
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
        }
        return list;
    }

}