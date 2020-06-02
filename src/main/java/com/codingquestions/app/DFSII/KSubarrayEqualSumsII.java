package com.codingquestions.app.DFSII;

import java.util.ArrayList;
import java.util.List;

// NOTE: this is a google onsite question!

/**
 * Given an input array with integers, how to split the asrray into k subarrays,
 * such that each subarray shares the same sum. (Subarray may not be adjacent to
 * each other)
 * 
 * You only need to a boolean indicating whether such splitting exists or not
 * 
 * e.g. input[N] = {3, -1, 1,1,1,2,2,2, 4, 6, -8, 1, 1} and k == 3 output = {3,
 * -1}, {4, 6, -8}, {1, 1} which all have the a sume that is equal to two
 */

// clarification: each set will have at elast one element in it
public class KSubarrayEqualSumsII {
    class Tuple {
        int start;
        int end;

        public Tuple(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean divide(int[] array, int k) {
        // storing end indeices of all subarrays
        List<Tuple> res = new ArrayList<>();
        return helper(array, res, k, 0, 0, 0);
    }

    private boolean helper(int[] array, List<Tuple> res, int k, int level, int startIndex, int subSum) {
        if (level == k || startIndex == array.length) {
            return (res.size() == k && startIndex == array.length);
        }

        // try each possible end index, pruning unqualified end indexes
        for (int start = startIndex; start < array.length; start++) {
            int sumCurrentArray = 0;
            for (int end = start; end < array.length; end++) {
                sumCurrentArray += array[end];
                // NOTE: first level will determine the sum of the rest of the levels
                if (level == 0 || sumCurrentArray == subSum) {
                    res.add(new Tuple(start, end));
                    if (helper(array, res, k, level + 1, end + 1, sumCurrentArray)) {
                        return true;
                    }
                    res.remove(res.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        KSubarrayEqualSumsII instance = new KSubarrayEqualSumsII();
        System.out.println(instance.divide(new int[] { 1, 100, 1, 1 }, 3));
    }
}