package com.codingquestions.app.DynamicProgramming;

/**
 * Given a matrix that contains integers, find the submatrix with the largest
 * sum.
 * 
 * Return the sum of the submatrix.
 * 
 * Assumptions
 * 
 * The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
 * Examples
 * 
 * { {1, -2, -1, 4},
 * 
 * {1, -1, 1, 1},
 * 
 * {0, -1, -1, 1},
 * 
 * {0, 0, 1, 1} }
 * 
 * the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
 * 
 * 
 */

public class LargestSubMatrixSum {
    // NOTE: method 1:
    // step 1: preprocess to get M[i][j].
    // M[i][j] represents the sum of matrix from <0,0> to <i, j>
    // step 2: for-for-for-for loop to find the <i, j> and <m, n>
    // where <i,j> is the top left corner
    // <m, n> is the bottom right corner
    // use the M[i][j] to get the sum in O(1)

    public int largest(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] M = getPrefixSum(matrix, rows, columns);
        return findLargest(matrix, M, rows, columns);
    }

    private int[][] getPrefixSum(int[][] matrix, int rows, int columns) {
        int[][] M = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0) {
                    M[i][j] = j == 0 ? matrix[i][j] : matrix[i][j] + M[i][j - 1];
                } else if (j == 0) {
                    M[i][j] = i == 0 ? matrix[i][j] : matrix[i][j] + M[i - 1][j];
                } else {
                    M[i][j] = matrix[i][j] + M[i - 1][j] + M[i][j - 1] - M[i - 1][j - 1];
                }
            }
        }
        return M;
    }

    private int findLargest(int[][] matrix, int[][] M, int rows, int columns) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int m = i; m < rows; m++) {
                    for (int n = j; n < columns; n++) {
                        largest = Math.max(largest, getSum(matrix, M, i, j, m, n));
                    }
                }
            }
        }
        return largest;
    }

    // <i, j> is the top left corner
    // <m, n> is the bottom right corner
    private int getSum(int[][] matrix, int[][] M, int i, int j, int m, int n) {
        if (i == 0 && j == 0) {
            return M[m][n];
        } else if (i == 0) {
            return M[m][n] - M[m][j - 1];
        } else if (j == 0) {
            return M[m][n] - M[i - 1][n];
        }

        return M[m][n] - M[i - 1][n] - M[m][j - 1] + M[i - 1][j - 1];
    }
}