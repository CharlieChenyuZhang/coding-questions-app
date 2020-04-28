package com.codingquestions.app.RecursionII;

/**
 * Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an
 * abbreviation, return if the string matches the abbreviation.
 * 
 * Assumptions:
 * 
 * The original string only contains alphabetic characters. Both input and
 * pattern are not null. Pattern would not contain invalid information like
 * "a0a","0". Examples:
 * 
 * pattern “s11d” matches input “sophisticated” since “11” matches eleven chars
 * “ophisticate”.
 */

// TIME:
// SPACE:
public class StringAbbreviationMatching {

    // recursive way
    public boolean match(String input, String pattern) {
        return matchHelper(input, pattern, 0, 0);
    }

    private boolean matchHelper(String input, String pattern, int inputIndex, int patternIndex) {
        // base case
        // when we run out of inputIndex and patternIndex together
        // return true
        // if ond of them has run out, return false
        if (inputIndex == input.length() && patternIndex == pattern.length()) {
            return true;
        }

        if (inputIndex >= input.length() || patternIndex >= pattern.length()) {
            return false;
        }

        // recursive rule
        // case 1: pattern.charAt(patternIndex) is not a char
        if (pattern.charAt(patternIndex) < '0' && pattern.charAt(patternIndex) > '9') {
            if (pattern.charAt(patternIndex) == input.charAt(inputIndex)) {
                return matchHelper(input, pattern, inputIndex + 1, patternIndex + 1);
            }
            return false;
        }

        // case 1: pattern.charAt(patternIndex) is a digit
        int num = 0;
        while (patternIndex < pattern.length() && pattern.charAt(patternIndex) >= '0'
                && pattern.charAt(patternIndex) <= '9') {
            num = num * 10 + pattern.charAt(patternIndex) - '0';
            patternIndex++;
        }
        return matchHelper(input, pattern, inputIndex + num, patternIndex);
    }
}