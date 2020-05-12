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
    // NOTE: method 1: O(n^4)
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

    // NOTE: method 2: [Recommended]
    // TIME: O(n^3)
    // SPACE: O(n^2) --> can be improved if we calculate M along the way see method
    // 3
    public int largest2(int[][] matrix) {
        int[][] M = getColumnWisePrefixSum(matrix);
        return getLargest(matrix, M);
    }

    private int[][] getColumnWisePrefixSum(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] M = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                M[i][j] = i == 0 ? matrix[i][j] : M[i - 1][j] + matrix[i][j];
            }
        }
        return M;
    }

    private int getLargest(int[][] matrix, int[][] M) {
        int rows = matrix.length;
        int largest = Integer.MIN_VALUE;

        // the range is [top, bottom] all inclusive
        for (int top = 0; top < rows; top++) {
            for (int bottom = top; bottom < rows; bottom++) {
                int[] array = flatten(matrix, M, top, bottom);
                largest = Math.max(largest, largestSubarraySum(array));
            }
        }
        return largest;
    }

    private int[] flatten(int[][] matrix, int[][] M, int top, int bottom) {
        int columns = M[0].length;
        int[] result = new int[columns];

        for (int column = 0; column < columns; column++) {
            result[column] = top == 0 ? M[bottom][column] : M[bottom][column] - M[top - 1][column];
        }
        return result;
    }

    private int largestSubarraySum(int[] array) {
        int largest = array[0];
        int prev = array[0];
        for (int i = 1; i < array.length; i++) {
            if (prev < 0) {
                prev = array[i];
            } else {
                prev += array[i];
            }

            largest = Math.max(largest, prev);
        }
        return largest;
    }

    // a better implementation (not required) so we can combine the
    // preprocessing with the result finding
    // TIME: O(n^3)
    // SPACE: O(n)

    public int largest3(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int[] cur = new int[M];
            for (int j = i; j < N; j++) {
                add(cur, matrix[j]);
                result = Math.max(result, largestSubarraySum(cur));
            }
        }
        return result;
    }

    private void add(int[] cur, int[] add) {
        for (int i = 0; i < cur.length; i++) {
            cur[i] += add[i];
        }
    }

}