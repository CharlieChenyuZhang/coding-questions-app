package com.codingquestions.app.DFSII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.
 * 
 * Assumptions
 * 
 * l, m, n >= 0 l + m + n > 0 Examples
 * 
 * l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>",
 * "<>()"]
 * 
 */

public class AllValidPermutationsOfParenthesesII {

    private static final char[] PS = new char[] { '(', ')', '<', '>', '{', '}' };

    public List<String> validParentheses(int l, int m, int n) {
        List<String> result = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int totalLength = 2 * (l + m + n);
        int[] remain = { l, l, m, m, n, n };
        helper(result, stack, sb, totalLength, remain);
        return result;
    }

    private void helper(List<String> result, Deque<Character> stack, StringBuilder sb, int totalLength, int[] remain) {
        // base case i.e. when do I get a result?
        if (sb.length() == totalLength) {
            result.add(sb.toString());
        }

        // recursive rule
        for (int i = 0; i < PS.length; i++) {
            if (i % 2 == 0) { // left bracket
                if (remain[i] > 0) {
                    sb.append(PS[i]);
                    stack.offerFirst(PS[i]);
                    remain[i]--;
                    helper(result, stack, sb, totalLength, remain);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            } else { // right bracket
                if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
                    sb.append(PS[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(result, stack, sb, totalLength, remain);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(PS[i - 1]);
                    remain[i]++;
                }
            }
        }
    }

}