package com.codingquestions.app.HashTableAndStringI;

import java.util.Set;
import java.util.HashSet;

/**
 * Remove given characters in input string, the relative order of other
 * characters should be remained. Return the new string after deletion.
 * 
 * Assumptions
 * 
 * The given input string is not null. The characters to be removed is given by
 * another string, it is guaranteed to be not null. Examples
 * 
 * input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is
 * "cd".
 */

public class RemoveCertainCharacters {
    // assume the length of input is n and size of t is m
    // TIME: O(n)
    // SPACE: O(m)
    public String remove(String input, String t) {
        char[] array = input.toCharArray();
        Set<Character> set = buildHashSet(t);

        int slow = 0;
        for (int fast = 0; fast <= input.length() - 1; fast++) {
            // case 1: when array[fast] is not in the set
            if (!set.contains(array[fast])) {
                swap(array, slow, fast);
                slow++;
            }
        }
        return new String(array, 0, slow);
    }

    private Set<Character> buildHashSet(String t) {
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            result.add(t.charAt(i));
        }
        return result;
    }

    private void swap(char[] array, int one, int two) {
        char tmp = array[one];
        array[one] = array[two];
        array[two] = tmp;
    }

}