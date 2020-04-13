package com.codingquestions.app.HashTableAndStringI;

import java.util.HashSet;

/**
 * Given an integer array of size N - 1, containing all the numbers from 1 to N
 * except one, find the missing number.
 * 
 * Assumptions
 * 
 * The given array is not null, and N >= 1 Examples
 * 
 * A = {2, 1, 4}, the missing number is 3 A = {1, 2, 3}, the missing number is 4
 * A = {}, the missing number is 1
 */

public class MissingNumberI {
    // method1: use a HashSet
    // TIME: O(n) in average and O(n^2) in worst case
    // SPACE: O(n)
    public int missing1(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        int n = array.length + 1;
        for (int num : array) {
            set.add(num);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    // method2: substraction
    // TIME: O(n)
    // SPACE: O(1)
    public int missing2(int[] array) {
        int n = array.length + 1;
        long total = (1 + n) * (n + 0L) / 2;
        long sum = 0L;
        for (int each : array) {
            sum += each;
        }
        return (int) (total - sum);
    }

    // method3: XOR
    // TIME: O(n)
    // SPACE: O(1)
    public int missing3(int[] array) {
        int XOR = 0;
        for (int num : array) {
            XOR ^= num;
        }
        for (int i = 1; i <= array.length + 1; i++) {
            XOR ^= i;
        }
        return XOR;
    }

}