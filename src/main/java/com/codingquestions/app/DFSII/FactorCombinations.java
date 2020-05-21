package com.codingquestions.app.DFSII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer number, return all possible combinations of the factors that
 * can multiply to the target number.
 * 
 * Example
 * 
 * Give A = 24
 * 
 * since 24 = 2 x 2 x 2 x 3
 * 
 * = 2 x 2 x 6
 * 
 * = 2 x 3 x 4
 * 
 * = 2 x 12
 * 
 * = 3 x 8
 * 
 * = 4 x 6
 * 
 * your solution should return
 * 
 * { { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }
 * 
 * note: duplicate combination is not allowed.
 */

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 1) {
            return result;
        }

        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = getFactors(target);
        helper(target, result, cur, factors, 0);
        return result;
    }

    private void helper(int target, List<List<Integer>> result, List<Integer> cur, List<Integer> factors, int index) {
        // base case
        if (index == factors.size()) {
            if (target == 1) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }

        // when adding no factors to it
        helper(target, result, cur, factors, index + 1);

        int size = cur.size();
        int factor = factors.get(index);
        while (target % factor == 0) {
            target /= factor;
            // NOTE: I can keep eating because I am considering the
            // case with one factor, two factors ...
            cur.add(factor);
            helper(target, result, cur, factors, index + 1);
        }
        // spit
        cur.subList(size, cur.size()).clear();
    }

    private List<Integer> getFactors(int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = target / 2; i > 1; i--) {
            if (target % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

}