package com.codingquestions.app.DFSII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of n integers, divide the set in two subsets of n/2 sizes each
 * such that the difference of the sum of two subsets is as minimum as possible.
 * 
 * Return the minimum difference(absolute value).
 * 
 * Assumptions:
 * 
 * The given integer array is not null and it has length of >= 2. Examples:
 * 
 * {1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
 * 
 */

public class TwoSubsetsWithMinDifference {
    // whether we add it to the leftSet or not
    // each node is the base case, we udpate globalMin with
    // totalSum - sumInSubset if necessary
    // DFS recursion tree is an n levels binary tree

    public int minDifference(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] min = { Integer.MAX_VALUE };
        int sum = getSum(array);
        List<Integer> cur = new ArrayList<>();
        helper(min, array, 0, cur, sum);
        return min[0];
    }

    private void helper(int[] min, int[] array, int index, List<Integer> cur, int sum) {
        // base case
        // each node is a potential solution
        if (index == array.length) {
            if (cur.size() == array.length / 2) {
                int diff = getDiff(cur, sum);
                min[0] = Math.min(min[0], diff);
            }
            return;
        }

        // recursive rule
        // fist case, we don't include indexth element in the left set
        helper(min, array, index + 1, cur, sum);

        // second case, I include it in left
        cur.add(array[index]);
        helper(min, array, index + 1, cur, sum);
        cur.remove(cur.size() - 1);
    }

    private int getDiff(List<Integer> list, int sum) {
        // when list is empty, sum is MAX_VALUE
        int leftSum = getSum(list);
        return Math.abs(sum - 2 * leftSum);
    }

    private int getSum(int[] array) {
        // when array is empty, return 0
        if (array == null || array.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int each : array) {
            sum += each;
        }
        return sum;
    }

    private int getSum(List<Integer> list) {
        // when array is empty, return 0
        if (list == null || list.size() == 0) {
            return 0;
        }

        int sum = 0;
        for (int each : list) {
            sum += each;
        }
        return sum;
    }

}