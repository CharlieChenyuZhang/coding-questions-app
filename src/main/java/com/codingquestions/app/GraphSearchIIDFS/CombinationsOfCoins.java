package com.codingquestions.app.GraphSearchIIDFS;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10
 * cents, 25 cents), get all the possible ways to pay a target number of cents.
 * 
 * Arguments
 * 
 * coins - an array of positive integers representing the different
 * denominations of coins, there are no duplicate numbers and the numbers are
 * sorted by descending order, eg. {25, 10, 5, 2, 1} target - a non-negative
 * integer representing the target number of cents, eg. 99 Assumptions
 * 
 * coins is not null and is not empty, all the numbers in coins are positive
 * target >= 0 You have infinite number of coins for each of the denominations,
 * you can pick any number of the coins. Return
 * 
 * a list of ways of combinations of coins to sum up to be target. each way of
 * combinations is represented by list of integer, the number at each index
 * means the number of coins used for the denomination at corresponding index.
 * Examples
 * 
 * coins = {2, 1}, target = 4, the return should be
 * 
 * [
 * 
 * [0, 4], (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
 * 
 * [1, 2], (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
 * 
 * [2, 0] (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
 * 
 * ]
 */

// TIME:
// SPACE:
public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // An container we use to track the current result so far
        List<Integer> cur = new ArrayList<Integer>();
        helper(target, coins, result, cur, 0);
        return result;
    }

    // target → remaining amount
    // coins → all choises
    // cur → result we are building so far
    // index → coins[index] represents the current coin value
    private void helper(int target, int[] coins, List<List<Integer>> result, List<Integer> cur, int index) {
        // base case
        // when we reach the last element in coins, we stop
        if (index == coins.length - 1) {
            // handle the last coin
            if (target % coins[index] == 0) {
                cur.add(target / coins[index]); // NOTE: any time whever you add, you need to spit
                result.add(new ArrayList<Integer>(cur)); // NOTE: this is easy to get wrong
                cur.remove(cur.size() - 1);
            }
            return;
        }

        // recursion rule
        // for each coin, we can select the amount between 0…
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i); // eat
            helper(target - coins[index] * i, coins, result, cur, index + 1);
            cur.remove(cur.size() - 1); // spit
        }
    }

}