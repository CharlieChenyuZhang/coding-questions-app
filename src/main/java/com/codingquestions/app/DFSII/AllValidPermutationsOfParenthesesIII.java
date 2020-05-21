package com.codingquestions.app.DFSII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {},
 * subject to the priority restriction: {} higher than <> higher than ().
 * 
 * 
 * 
 * Assumptions
 * 
 * l, m, n >= 0
 * 
 * l + m + n >= 0
 * 
 * 
 * 
 * Examples
 * 
 * l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "<()>", "<>()"].
 * 
 * l = 2, m = 0, n = 1, all the valid permutations are [“()(){}”, “(){()}”,
 * “(){}()”, “{()()}”, “{()}()”, “{}()()”].
 */

public class AllValidPermutationsOfParenthesesIII {

    private static char[] brackets = { '(', ')', '<', '>', '{', '}' };

    public List<String> validParenthesesIII(int l, int m, int n) {
        List<String> result = new ArrayList<>();
        int totalLevel = 2 * (l + m + n);
        StringBuilder sb = new StringBuilder();
        int[] remaining = { l, l, m, m, n, n };
        Deque<Character> stack = new ArrayDeque<>();
        helper(result, totalLevel, 0, sb, remaining, stack);
        return result;
    }

    private void helper(List<String> result, int totalLevel, int index, StringBuilder sb, int[] remaining,
            Deque<Character> stack) {
        // base base
        if (sb.length() == totalLevel) {
            result.add(sb.toString());
            return;
        }

        // recursive rule
        for (int i = 0; i < brackets.length; i++) {
            if (i % 2 == 0) {// left bracket
                if (remaining[i] > 0 && (stack.isEmpty() || hasHigherPriority(stack.peekFirst(), brackets[i]))) {
                    Character bracket = brackets[i];
                    sb.append(bracket);
                    stack.offerFirst(bracket);
                    remaining[i]--;
                    helper(result, totalLevel, index + 1, sb, remaining, stack);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    remaining[i]++;
                }
            } else { // right bracket
                if (!stack.isEmpty() && stack.peekFirst() == brackets[i - 1]) {
                    Character bracket = brackets[i];
                    sb.append(bracket);
                    stack.pollFirst();
                    remaining[i]--;
                    helper(result, totalLevel, index + 1, sb, remaining, stack);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(brackets[i - 1]);
                    remaining[i]++;
                }
            }
        }
    }

    private boolean hasHigherPriority(Character one, Character two) {
        int indexOne = getBracktIndex(one);
        int indexTwo = getBracktIndex(two);
        return indexOne > indexTwo;
    }

    private int getBracktIndex(char bracket) {
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == bracket) {
                return i;
            }
        }
        return -1;
    }

}