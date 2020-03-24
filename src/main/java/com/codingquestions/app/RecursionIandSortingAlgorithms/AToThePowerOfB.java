package com.codingquestions.app.RecursionIandSortingAlgorithms;

// Problem:
/**
 * Evaluate a to the power of b, assuming both a and b are integers and b is
 * non-negative.
 * 
 * Examples
 * 
 * power(2, 0) = 1 power(2, 3) = 8 power(0, 10) = 0 power(-2, 5) = -32 Corner
 * Cases
 * 
 * In this question, we assume 0^0 = 1. What if the result is overflowed? We can
 * assume the result will not be overflowed when we solve this problem on this
 * online judge.
 */

// Solution:

public class AToThePowerOfB {

    // TIME: O(b)
    // SPACE: O(b)
    public long methodOne(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return methodOne(a, b - 1) * a;
    }

    // TIME: O(log b)
    // SPACE: O(log b)
    public long methodTwo(int a, int b) {
        if (b == 0) {
            return 1;
        }

        long mid = methodTwo(a, b / 2);

        if (b % 2 == 0) {
            return mid * mid;
        } else {
            return mid * mid * a;
        }
    }

}
