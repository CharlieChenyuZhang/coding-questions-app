package com.codingquestions.app.StringII;

/**
 * Given an original string input, and two strings S and T, replace all
 * occurrences of S in input with T.
 * 
 * Assumptions
 * 
 * input, S and T are not null, S is not empty string Examples
 * 
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 * input = "laicode", S = "code", T = "offer", input becomes "laioffer"
 */

public class StringReplaceaBasic {
    public String replace(String input, String source, String target) {
        // when the result is getting longer
        if (source.length() <= target.length()) {
            return replaceLonger(input, source, target);
        }
        return replaceShorter(input, source, target);
    }

    private String replaceShorter(String input, String source, String target) {
        char[] array = input.toCharArray();

        int i = 0;
        int j = 0;
        while (j <= array.length - 1) {
            if (!equalSubstring(array, j, source)) {
                array[i] = array[j];
                i++;
                j++;
            } else {
                for (int p = 0; p < target.length(); p++) {
                    array[i] = target.charAt(p);
                    i++;
                }
                j += source.length();
            }
        }
        return new String(array, 0, i);
    }

    // we are matching the string s in the array from fromIndex
    private boolean equalSubstring(char[] array, int fromIndex, String s) {
        if (fromIndex + s.length() > array.length) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (array[fromIndex] != s.charAt(i)) {
                return false;
            }
            fromIndex++;
        }
        return true;
    }

    private String replaceLonger(String input, String source, String target) {
        char[] array = input.toCharArray();
        char[] result = new char[input.length() + (target.length() - source.length()) * numOfMatches(array, source)];

        int i = 0; // pointer in the result
        int j = 0; // pointer in the original array

        while (j <= input.length() - 1) {
            if (equalSubstring(array, j, source)) {
                for (int charIndex = 0; charIndex < target.length(); charIndex++) {
                    result[i] = target.charAt(charIndex);
                    i++;
                }
                j += source.length();
            } else {
                result[i] = array[j];
                i++;
                j++;
            }
        }
        return new String(result);
    }

    private int numOfMatches(char[] array, String s) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (equalSubstring(array, i, s)) {
                count++;
            }
        }
        return count;
    }

    public String replace2(String input, String source, String target) {
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < array.length) {
            if (equalSubstring(array, i, source)) {
                // increment the pointer i
                // add the target to the result
                sb.append(target);
                i += (source.length());
            } else {
                sb.append(array[i]);
                i++;
            }
        }
        return sb.toString();
    }

}