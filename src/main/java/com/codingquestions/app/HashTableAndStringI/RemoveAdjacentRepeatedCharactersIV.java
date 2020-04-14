package com.codingquestions.app.HashTableAndStringI;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Repeatedly remove all adjacent, repeated characters in a given string from
 * left to right.
 * 
 * No adjacent characters should be identified in the final string.
 * 
 * Examples
 * 
 * "abbbaaccz" → "aaaccz" → "ccz" → "z" "aabccdc" → "bccdc" → "bdc"
 */

// TIME:
// SPACE:
public class RemoveAdjacentRepeatedCharactersIV {

    // TIME: O(n)
    // SPACE: O(n)
    public String deDup1(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;

        while (i < array.length) {
            // case 1: array[i] is the top ele on stack,
            // keep moving the pointer till the they are not the
            // same, pop from stack afterward
            // top element off the stack
            // case 2: array[i] is not the top ele on stack
            // we push the ele to stack
            Character topEle = stack.peekFirst();
            if (topEle == null || topEle != array[i]) {
                stack.offerFirst(array[i]);
                i++;
            } else {
                while (i < array.length && topEle == array[i]) {
                    i++;
                }
                stack.pollFirst();
            }
        }

        char[] result = new char[stack.size()];
        for (int j = result.length - 1; j >= 0; j--) {
            result[j] = stack.pollFirst();
        }
        return new String(result);
    }

    // a better way to not using a physical stack
    // TIME: O(n)
    // SPACE: O(1)
    public String deDup2(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();

        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (i != 0 && array[j] == array[i - 1]) {
                while (j < array.length && array[j] == array[i - 1]) {
                    j++;
                }
                i--;
                continue;
            }
            array[i++] = array[j++];
        }

        return new String(array, 0, i);

    }

}