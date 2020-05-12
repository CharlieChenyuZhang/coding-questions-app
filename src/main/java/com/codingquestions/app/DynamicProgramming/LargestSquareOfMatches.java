package com.codingquestions.app.DynamicProgramming;

/**
 * Determine the largest square surrounded by a bunch of matches (each match is
 * either horizontal or vertical), return the length of the largest square.
 * 
 * The input is a matrix of points. Each point has one of the following values:
 * 
 * 0 - there is no match to its right or bottom.
 * 
 * 1 - there is a match to its right.
 * 
 * 2 - there is a match to its bottom.
 * 
 * 3 - there is a match to its right, and a match to its bottom.
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
 * {{3, 1, 1, 3, 0, 1, 1, 0},
 * 
 * {2, 0, 0, 2, 0, 0, 0, 0},
 * 
 * {3, 1, 3, 0, 0, 0, 0, 0},
 * 
 * {2, 0, 2, 0, 0, 0, 0, 0},
 * 
 * {1, 1, 0, 0, 0, 0, 0, 0}}
 * 
 * 
 * 
 * This matrix represents the following bunch of matches:
 * 
 * 
 * 
 * The largest square has length of 2.
 */

public class LargestSquareOfMatches {
    // M1[i][j] represents the longest contiguous 1s from left to right
    // that starts with matrix[i][j]

    // M2[i][j] represents the longest contiguous 1s from top to bottom
    // that starts with matrix[i][j]

    public int largestSquareOfMatches(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows == 0 || columns == 0) {
            return 0;
        }

        int[][] M1 = leftToRight(matrix, rows, columns);
        int[][] M2 = topToBottom(matrix, rows, columns);
        return merge(matrix, M1, M2, rows, columns);
    }

    private int[][] leftToRight(int[][] matrix, int rows, int columns) {
        int[][] M = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = columns - 1; j >= 0; j--) {
                if (matrix[i][j] == 1 || matrix[i][j] == 3) {
                    if (j != columns - 1) {
                        M[i][j] = M[i][j + 1] + 1;
                    }
                }
            }
        }
        return M;
    }

    private int[][] topToBottom(int[][] matrix, int rows, int columns) {
        int[][] M = new int[rows][columns];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 2 || matrix[i][j] == 3) {
                    if (i != rows - 1) {
                        M[i][j] = M[i + 1][j] + 1;
                    }
                }
            }
        }
        return M;
    }

    private int merge(int[][] matrix, int[][] M1, int[][] M2, int rows, int columns) {
        int longest = 0;

        // <i, j> is the top left corner
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 3) {
                    int sideLength = Math.min(M1[i][j], M2[i][j]);
                    for (int k = sideLength; k >= 1; k--) {
                        // top right <i, j + k - 1>
                        // bottom left <i + k - 1, j>
                        if (M2[i][j + k] >= k && M1[i + k][j] >= k) {
                            longest = Math.max(longest, k);
                            break;
                        }
                    }
                }
            }
        }
        return longest;
    }

    // A more compact implementation
    public int largestSquareOfMatches2(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        if (M == 0 || N == 0) {
            return 0;
        }

        int result = 0;
        // the longest right/down arm length ending at each pos in the
        // matrix
        int[][] right = new int[M + 1][N + 1];
        int[][] down = new int[M + 1][N + 1];

        // <i, j> is the top left corner of the square
        // we start building from the bottom right of matrix
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (hasRight(matrix[i][j])) {
                    right[i][j] = right[i][j + 1] + 1;
                }
                if (hasDown(matrix[i][j])) {
                    down[i][j] = down[i + 1][j] + 1;
                }
                if (hasBoth(matrix[i][j])) {
                    for (int maxLength = Math.min(right[i][j], down[i][j]); maxLength >= 1; maxLength--) {
                        if (right[i + maxLength][j] >= maxLength && down[i][j + maxLength] >= maxLength) {
                            result = Math.max(result, maxLength);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean hasRight(int value) {
        // value == 1 || value == 3
        return (value & 0b1) != 0;
    }

    private boolean hasDown(int value) {
        // value == 2 || value == 3
        return (value & 0b10) != 0;
    }

    private boolean hasBoth(int value) {
        // value == 3
        return value == 0b11;
    }

}