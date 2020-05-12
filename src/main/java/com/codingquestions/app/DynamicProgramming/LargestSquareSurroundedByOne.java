package com.codingquestions.app.DynamicProgramming;

/**
 * Determine the largest square surrounded by 1s in a binary matrix (a binary
 * matrix only contains 0 and 1), return the length of the largest square.
 * 
 * 
 * 
 * Assumptions
 * 
 * The given matrix is guaranteed to be of size M * N, where M, N >= 0
 * 
 * 
 * 
 * Examples
 * 
 * {{1, 0, 1, 1, 1},
 * 
 * {1, 1, 1, 1, 1},
 * 
 * {1, 1, 0, 1, 0},
 * 
 * {1, 1, 1, 1, 1},
 * 
 * {1, 1, 1, 0, 0}}
 * 
 * 
 * 
 * The largest square surrounded by 1s has length of 3.
 */
public class LargestSquareSurroundedByOne {
    // step 1: preprocess the matrix to get M1[i][j] and M2[i][j]
    // M1[i][j] represents the longest contiguous 1s from left to right
    // starting at pos <i, j>
    // M2[i] represents the longest contiguous 1s from top to bottom
    // starting at pos <i, j>

    // possible length = min(M1[i][j], M2[i][j])
    // for each k in [0, length] →
    // find "top right corner" → check if M2[i][j + k] >= k
    // find the "bottom left corner" → check if M1[i + k][j] >= k

    // update the global var longest if applicable

    // TIME: O(m * n)
    // SPACE: O(m * n)
    public int largestSquareSurroundedByOne(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows == 0 || columns == 0) {
            return 0;
        }

        int[][] M1 = leftRight(matrix, rows, columns);
        int[][] M2 = topDown(matrix, rows, columns);

        return findLargest(M1, M2, rows, columns);

    }

    private int[][] leftRight(int[][] matrix, int rows, int columns) {
        int[][] M = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = columns - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (j == columns - 1) {
                        M[i][j] = 1;
                    } else {
                        M[i][j] = M[i][j + 1] + 1;
                    }
                }
            }
        }
        return M;
    }

    private int[][] topDown(int[][] matrix, int rows, int columns) {
        int[][] M = new int[rows][columns];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    if (i == rows - 1) {
                        M[i][j] = 1;
                    } else {
                        M[i][j] = M[i + 1][j] + 1;
                    }
                }
            }
        }
        return M;
    }

    private int findLargest(int[][] M1, int[][] M2, int rows, int columns) {
        int largest = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int armLength = Math.min(M1[i][j], M2[i][j]);
                for (int k = armLength; k >= 1; k--) {
                    // top right corner <i, j + k>
                    // bottom left corner <i + k, j>
                    if (M2[i][j + k - 1] >= k && M1[i + k - 1][j] >= k) {
                        largest = Math.max(largest, k);
                        break;
                    }
                }
            }
        }
        return largest;
    }

    // another implementation
    public int largestSquareSurroundedByOne2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int result = 0;
        int M = matrix.length;
        int N = matrix[0].length;

        // We here apply a trick for each of later processing:
        // left[i][j] is actually mapped to matrix[i-1][j-1]
        // this will reduce the corner cases

        int[][] left = new int[M + 1][N + 1];
        int[][] up = new int[M + 1][N + 1];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    left[i + 1][j + 1] = left[i + 1][j] + 1;
                    up[i + 1][j + 1] = up[i][j + 1] + 1;
                }
                for (int maxLength = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); maxLength >= 1; maxLength--) {
                    if (left[i + 2 - maxLength][j + 1] >= maxLength && up[i + 1][j + 2 - maxLength] >= maxLength) {
                        result = Math.max(result, maxLength);
                        break;
                    }
                }
            }
        }
        return result;
    }

}