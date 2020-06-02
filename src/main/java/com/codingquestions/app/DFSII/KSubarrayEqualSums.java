package com.codingquestions.app.DFSII;

import java.util.ArrayList;
import java.util.List;

// NOTE: this is a google onsite question!

/**
 * Given an input array with integers, how to split the asrray into k subarrays,
 * such that each subarray shares the same sum
 * 
 * You only need to a boolean indicating whether such splitting exists or not
 * 
 * e.g. input[N] = {3, -1, 4, 6, -8, 1, 1} and k == 3 output = {3, -1}, {4, 6,
 * -8}, {1, 1} which all have the a sume that is equal to two
 */

// clarification: each set will have at elast one element in it
public class KSubarrayEqualSums {
    public boolean divide(int[] array, int k) {
        // storing end indeices of all subarrays
        List<Integer> res = new ArrayList<>();
        int totalSum = getTotalSum(array);
        return helper(array, res, k, 0, 0, totalSum / k);
    }

    private int getTotalSum(int[] array) {
        int sum = 0;
        for (int each : array) {
            sum += each;
        }
        return sum;
    }

    private boolean helper(int[] array, List<Integer> res, int k, int level, int startIndex, int subSum) {
        if (level == k || startIndex == array.length) {
            return (res.size() == k && startIndex == array.length);
        }

        // try each possible end index, pruning unqualified end indexes
        int sumCurrentArray = 0;
        for (int i = startIndex; i < array.length; i++) {
            sumCurrentArray += array[i];
            if (sumCurrentArray == subSum) {
                res.add(i);
                if (helper(array, res, k, level + 1, i + 1, subSum)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        KSubarrayEqualSums instance = new KSubarrayEqualSums();
        System.out.println(instance.divide(new int[] { 3, -1, 4, 6, -8, 1, 1 }, 3));
    }
}