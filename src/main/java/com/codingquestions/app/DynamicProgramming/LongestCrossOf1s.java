package com.codingquestions.app.DynamicProgramming;

/**
 * Given a matrix that contains only 1s and 0s, find the largest cross which
 * contains only 1s, with the same arm lengths and the four arms joining at the
 * central point.
 * 
 * Return the arm length of the largest cross.
 * 
 * Assumptions
 * 
 * The given matrix is not null, has size of N * M, N >= 0 and M >= 0. Examples
 * 
 * { {0, 0, 0, 0},
 * 
 * {1, 1, 1, 1},
 * 
 * {0, 1, 1, 1},
 * 
 * {1, 0, 1, 1} }
 * 
 * the largest cross of 1s has arm length 2.
 * 
 * 
 */

public class LongestCrossOf1s {
    // TIME: O(4 * n^2 + n^2) = O(n^2)
    // SPACE: O(4 * n^2) = O(n^2)
    /**
     * M1: left->right M2: right->left M3: top->bottom M4: bottom->top
     * 
     * scan the row from right to left M1[i][j] represents the number of consecutive
     * 1s that starts with matrix[i][j] including matrix[i][j] M1[i][j] = 0 if
     * matrix[i][j] == 0 = M1[i][j+1] + 1
     * 
     * int longestArmLength;
     * 
     * @param matrix
     * @return
     */
    public int largest(int[][] matrix) {
        // assumptions: matrix is not null, has size of N * M
        // where N >= 0 and M >= 0
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] M1 = buildLeftToRight(matrix, rows, columns);
        int[][] M2 = buildRightToLeft(matrix, rows, columns);
        int[][] M3 = buildTopToBottom(matrix, rows, columns);
        int[][] M4 = buildBottomToTop(matrix, rows, columns);

        return merge(M1, M2, M3, M4, rows, columns);
    }

    private int[][] buildLeftToRight(int[][] matrix, int rows, int columns) {
        int[][] M = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            int prev = 0;
            for (int column = columns - 1; column >= 0; column--) {
                if (matrix[row][column] == 0) {
                    M[row][column] = 0;
                } else {
                    M[row][column] = prev + 1;
                }
                prev = M[row][column];
            }
        }
        return M;
    }

    private int[][] buildRightToLeft(int[][] matrix, int rows, int columns) {
        int[][] M = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            int prev = 0;
            for (int column = 0; column < columns; column++) {
                if (matrix[row][column] == 0) {
                    M[row][column] = 0;
                } else {
                    M[row][column] = prev + 1;
                }
                prev = M[row][column];
            }
        }
        return M;
    }

    private int[][] buildTopToBottom(int[][] matrix, int rows, int columns) {
        int[][] M = new int[rows][columns];
        for (int column = 0; column < columns; column++) {
            int prev = 0;
            for (int row = rows - 1; row >= 0; row--) {
                if (matrix[row][column] == 0) {
                    M[row][column] = 0;
                } else {
                    M[row][column] = prev + 1;
                }
                prev = M[row][column];
            }
        }
        return M;
    }

    private int[][] buildBottomToTop(int[][] matrix, int rows, int columns) {
        int[][] M = new int[rows][columns];
        for (int column = 0; column < columns; column++) {
            int prev = 0;
            for (int row = 0; row < rows; row++) {
                if (matrix[row][column] == 0) {
                    M[row][column] = 0;
                } else {
                    M[row][column] = prev + 1;
                }
                prev = M[row][column];
            }
        }
        return M;
    }

    private int merge(int[][] M1, int[][] M2, int[][] M3, int[][] M4, int rows, int columns) {
        int maxArmLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int armLength = Math.min(M1[row][column], M2[row][column]);
                armLength = Math.min(armLength, M3[row][column]);
                armLength = Math.min(armLength, M4[row][column]);
                maxArmLength = Math.max(armLength, maxArmLength);
            }
        }
        return maxArmLength;
    }

    // ANOTHER WAY TO IMPLEMENT
    // improvement on implementation:
    // instead of four functions to calculate M1,2,3,4 we can use 2
    public int largest2(int[][] matrix) {
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }

        int M = matrix[0].length;
        if (M == 0) {
            return 0;
        }

        int[][] leftUp = leftUp(matrix, N, M);
        // records the longest possible length for the right and down arms
        int[][] rightDown = rightDown(matrix, N, M);
        return merge2(leftUp, rightDown, N, M);
    }

private int merge2(int[][] leftUp, int[][] rightDown, int N, int M) {
	int result = 0;
	for (int i = 0; i < N; i++) {
	for (int j = 0; j < M, j++) {
	leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
	result = Math.max(result, leftUp[i][k]);
}
}
return result;
}

    private int[][] leftUp(int[][] matrix, int N, int M) {
        int[][] left = new int[N][M];
        int[][] up = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        up[i][j] = 1;
                        left[i][j] = 1;
                    } else if (i == 0) {
                        up[i][j] = 1;
                        left[i][j] = left[i][j - 1] + 1;
                    } else if (j == 0) {
                        up[i][j] = up[i - 1][j] + 1;
                        left[i][j] = 1;
                    } else {
                        up[i][j] = up[i - 1][j] + 1;
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }
        merge2(left, up, N, M);
        return left;
    }

    private int[][] rightDown(int[][] matrix, int N, int M) {
        int[][] right = new int[N][M];
        int[][] down = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == N - 1 && j == M - 1) {
                        down[i][j] = 1;
                        right[i][j] = 1;
                    } else if (i == N - 1) {
                        down[i][j] = 1;
                        right[i][j] = right[i][j + 1] + 1;
                    } else if (j == M - 1) {
                        down[i][j] = down[i + 1][j] + 1;
                        right[i][j] = 1;
                    } else {
                        down[i][j] = down[i + 1][j] + 1;
                        right[i][j] = right[i][j + 1] + 1;
                    }
                }
            }
        }
        merge2(right, down, N, M);
        return right; // this is the side effect in the merge method
    }

}