package com.codingquestions.app.GraphSearchIIDFS;

import java.util.List;
import java.util.ArrayList;

/**
 * Given N pairs of parentheses “()”, return a list with all the valid
 * permutations.
 * 
 * Assumptions
 * 
 * N > 0 Examples
 * 
 * N = 1, all valid permutations are ["()"] N = 3, all valid permutations are
 * ["((()))", "(()())", "(())()", "()(())", "()()()"]
 */

// TIME: O(2^n)
// SPACE: O(2n + n) where 2n is the depth of the tree and n is the sb ==> O(n)
public class AllValidPermutationsOfParenthesesI {
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        validParentheses(result, n, 0, 0, sb);
        return result;
    }

    // n → number of pairs
    // left → a number of opening parenthesis so far
    // right → a number of closing parenthesis so far
    // sb → storing the string that we are currently building

    private void validParentheses(List<String> result, int n, int left, int right, StringBuilder sb) {
        // base case: when I have used all n pairs, I add it to result
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        // recursive rule
        if (left < n) {
            sb.append('(');
            validParentheses(result, n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < n && left > right) {
            sb.append(')');
            validParentheses(result, n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}