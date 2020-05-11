package com.codingquestions.app.DynamicProgramming;

/**
 * Given a matrix that contains only 1s and 0s, find the largest X shape which
 * contains only 1s, with the same arm lengths and the four arms joining at the
 * central point.
 * 
 * Return the arm length of the largest X shape.
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
 * the largest X of 1s has arm length 2
 */

public class LargestXOf1s {
    public int largest(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }

        int columns = matrix[0].length;
        if (columns == 0) {
            return 0;
        }

        int[][] leftUp = leftUp(matrix, rows, columns);
        int[][] rightUp = rightUp(matrix, rows, columns);
        int[][] leftBottom = leftBottom(matrix, rows, columns);
        int[][] rightBottom = rightBottom(matrix, rows, columns);
        return merge(leftUp, rightUp, leftBottom, rightBottom, rows, columns);
    }

    private int merge(int[][] leftUp, int[][] rightUp, int[][] leftBottom, int[][] rightBottom, int rows, int columns) {
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int min = Math.min(leftUp[i][j], rightUp[i][j]);
                min = Math.min(min, leftBottom[i][j]);
                min = Math.min(min, rightBottom[i][j]);
                result = Math.max(result, min);
            }
        }
        return result;
    }

    private int[][] leftUp(int[][] matrix, int rows, int columns) {
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = result[i - 1][j - 1] + 1;
                    }
                } // otherwise, use default val 0
            }
        }
        return result;
    }

    private int[][] rightUp(int[][] matrix, int rows, int columns) {
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = columns - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == columns - 1) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = result[i - 1][j + 1] + 1;
                    }
                } // otherwise, use default val 0
            }
        }
        return result;
    }

    private int[][] leftBottom(int[][] matrix, int rows, int columns) {
        int[][] result = new int[rows][columns];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    if (i == rows - 1 || j == 0) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = result[i + 1][j - 1] + 1;
                    }
                } // otherwise, use default val 0
            }
        }
        return result;
    }

    private int[][] rightBottom(int[][] matrix, int rows, int columns) {
        int[][] result = new int[rows][columns];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == rows - 1 || j == columns - 1) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = result[i + 1][j + 1] + 1;
                    }
                } // otherwise, use default val 0
            }
        }
        return result;
    }

    public int largest2(int[][] matrix) {
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }

        int M = matrix[0].length;
        if (M == 0) {
            return 0;
        }

        int[][] leftUp = topLeftTopRight(matrix, N, M);
        int[][] rightDown = bottomLeftBottomRight(matrix, N, M);
        return merge(leftUp, rightDown, N, M);
    }

    private int merge(int[][] leftUp, int[][] rightDown, int N, int M) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                result = Math.max(result, leftUp[i][j]);
            }
        }
        return result;
    }

    // left represents the arm pointing to the top left
    // up represents the arm pointing to the top right
    private int[][] topLeftTopRight(int[][] matrix, int N, int M) {
        int[][] left = new int[N][M];
        int[][] up = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = getNumber(left, i - 1, j - 1, N, M) + 1;
                    up[i][j] = getNumber(up, i - 1, j + 1, N, M) + 1;
                }
            }
        }
        merge(left, up, N, M);
        return left;
    }

    // right represents the arm pointing to the bottom right
    // down represents the amr pointing to the bottom left
    private int[][] bottomLeftBottomRight(int[][] matrix, int N, int M) {
        int[][] right = new int[N][M];
        int[][] down = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = getNumber(right, i + 1, j + 1, N, M) + 1;
                    down[i][j] = getNumber(down, i + 1, j - 1, N, M) + 1;
                }
            }
        }
        merge(right, down, N, M);
        return right;
    }

    private int getNumber(int[][] number, int x, int y, int N, int M) {
        // if its out of bound, we return 0
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return 0;
        }
        return number[x][y];
    }

}