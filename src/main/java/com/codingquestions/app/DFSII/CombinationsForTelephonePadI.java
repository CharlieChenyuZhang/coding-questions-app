package com.codingquestions.app.DFSII;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a telephone keypad, and an int number, print all words which are
 * possible by pressing these numbers, the output strings should be sorted.
 * 
 * {0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 :
 * "pqrs", 8 : "tuv", 9 : "wxyz"}
 * 
 * Assumptions:
 * 
 * The given number >= 0 Examples:
 * 
 * if input number is 231, possible words which can be formed are:
 * 
 * [ad, ae, af, bd, be, bf, cd, ce, cf]
 */

public class CombinationsForTelephonePadI {
    public String[] combinations(int number) {
        List<String> result = new ArrayList<String>();
        String[] numToChar = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        char[] numberArray = Integer.toString(number).toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(numToChar, numberArray, result, sb, 0);
        return result.toArray(new String[0]);
    }

    private void helper(String[] numToChar, char[] numberArray, List<String> result, StringBuilder sb, int level) {
        // base case
        if (level == numberArray.length) {
            result.add(sb.toString());
            return;
        }

        // recursive rule
        char[] chars = numToChar[numberArray[level] - '0'].toCharArray();

        // NOTE: I have to separate two cases because when the first
        // digit is 0 or 1, i.e. chars is empty, I won't be able to go
        // to the next level

        if (chars.length == 0) {
            helper(numToChar, numberArray, result, sb, level + 1);
        } else {
            for (char each : chars) {
                sb.append(each);
                helper(numToChar, numberArray, result, sb, level + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}