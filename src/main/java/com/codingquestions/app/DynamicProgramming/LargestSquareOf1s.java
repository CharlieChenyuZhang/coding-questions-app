package com.codingquestions.app.DynamicProgramming;

/**
 * Determine the largest square of 1s in a binary matrix (a binary matrix only
 * contains 0 and 1), return the length of the largest square.
 * 
 * Assumptions
 * 
 * The given matrix is not null and guaranteed to be of size N * N, N >= 0
 * Examples
 * 
 * { {0, 0, 0, 0},
 * 
 * {1, 1, 1, 1},
 * 
 * {0, 1, 1, 1},
 * 
 * {1, 0, 1, 1}}
 * 
 * the largest square of 1s has length of 2
 */

public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        int numOfRows = matrix.length;
        int numOfColumns = matrix[0].length;
        int[][] M = new int[numOfRows][numOfColumns];
        int max = 0;
        for (int i = 0; i < numOfRows; i++) { // rowIndex
            for (int j = 0; j < numOfColumns; j++) { // colIndex
                if (i == 0 || j == 0) {
                    M[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    M[i][j] = Math.min(M[i - 1][j - 1], M[i - 1][j]);
                    M[i][j] = 1 + Math.min(M[i][j], M[i][j - 1]);
                }
                max = Math.max(max, M[i][j]);
            }
        }
        return max;
    }

}