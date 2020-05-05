package com.codingquestions.app.DynamicProgramming;

/**
 * Given a rope with positive integer-length n, how to cut the rope into m
 * integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the
 * maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be
 * greater than 0 (at least one cut must be made). Return the max product you
 * can have.
 * 
 * Assumptions
 * 
 * n >= 2 Examples
 * 
 * n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with
 * length of each is 3).
 */

public class MaxProductOfCuttingRope {
    // M[i] represents the largest product that can be made by cutting i meter long
    // rope (with at least 1 cut)

    // method 1: left big + right big
    public int maxProduct(int length) {
        int[] M = new int[length + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 1; i <= length; i++) { // the length of the rope
            int curMax = 0;
            for (int j = 1; j <= i / 2; j++) { // length of left
                curMax = Math.max(curMax, Math.max(j, M[j]) * Math.max(i - j, M[i - j]));
            }
            M[i] = curMax;
        }
        return M[length];
    }

    // method 2: left big + right small (generic, more recommended)
    public int maxProductII(int length) {
        int[] M = new int[length + 1];
        M[0] = 0;
        M[1] = 0;
        for (int i = 1; i <= length; i++) { // the length of the rope
            int curMax = 0;
            for (int j = 1; j < i; j++) { // length of left
                curMax = Math.max(curMax, Math.max(j, M[j]) * (i - j));
            }
            M[i] = curMax;
        }
        return M[length];
    }

}