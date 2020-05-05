package com.codingquestions.app.DynamicProgramming;

import java.util.HashMap;

/**
 * Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th
 * Fibonacci number is 0 and the 1st Fibonacci number is 1).
 * 
 * Examples
 * 
 * 0th fibonacci number is 0 1st fibonacci number is 1 2nd fibonacci number is 1
 * 3rd fibonacci number is 2 6th fibonacci number is 8 Corner Cases
 * 
 * What if K < 0? in this case, we should always return 0. Is it possible the
 * result fibonacci number is overflowed? We can assume it will not be
 * overflowed when we solve this problem on this online judge, but we should
 * also know that it is possible to get an overflowed number, and sometimes we
 * will need to use something like BigInteger.
 */

public class FibonacciNumber {

    // method 1: recursion + memoization
    // time: O(n)
    // space: O(n)
    HashMap<Integer, Long> memorizedFibo = new HashMap<>();

    public long fibonacciI(int k) {
        if (k <= 0) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        if (memorizedFibo.containsKey(k)) {
            return memorizedFibo.get(k);
        }

        long result = fibonacciI(k - 1) + fibonacciI(k - 2);
        memorizedFibo.put(k, result);
        return result;
    }

    // method 2: DP with O(n) space
    public long fibonacciII(int k) {
        if (k <= 0) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        long[] array = new long[k + 1];
        array[1] = 1;

        for (int i = 2; i <= k; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[k];

    }

    // method 3: DP with O(1) space
    public long fibonacciIII(int k) {
        if (k <= 0) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        long prev = 1;
        long prevprev = 0;

        while (k >= 2) {
            long tmp = prev;
            prev = prev + prevprev;
            prevprev = tmp;
            k--;
        }

        return prev;
    }

    // method 4: O(longn) solution using matrix multiplciation
    // M={{1, 1}, {1, 0}}={{f(2), f(1)}, {f(1), f(0)}}
    public static final long[][] SEED = { { 1L, 1L }, { 1L, 0L } };

    public long fibonacciIIII(int k) {
        if (k <= 0) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        long[][] matrix = { { 1L, 1L }, { 1L, 0L } };
        pow(matrix, k - 1);
        return matrix[0][0];
    }

    private void pow(long[][] matrix, int pow) {
        if (pow == 1) {
            return;
        }

        pow(matrix, pow / 2);
        multiply(matrix, matrix);
        if (pow % 2 != 0) {
            multiply(matrix, SEED);
        }
    }

    private void multiply(long[][] matrix, long[][] multiplier) {
        long topLeft = matrix[0][0] * multiplier[0][0] + matrix[0][1] * multiplier[1][0];

        long topRight = matrix[0][0] * multiplier[0][1] + matrix[0][1] * multiplier[1][1];

        long bottomLeft = matrix[1][0] * multiplier[0][0] + matrix[1][1] * multiplier[1][0];

        long bottomRight = matrix[1][0] * multiplier[0][1] + matrix[1][1] * multiplier[1][1];

        matrix[0][0] = topLeft;
        matrix[0][1] = topRight;
        matrix[1][0] = bottomLeft;
        matrix[1][1] = bottomRight;
    }

}