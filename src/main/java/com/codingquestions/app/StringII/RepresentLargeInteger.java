package com.codingquestions.app.StringII;

/**
 * if you want to represent an integer larger than 2^64, one way of doing this
 * is
 * to represent the number as a string. Given the string representation of a
 * non-negative
 * integer, incrase the number by one (You are not allowed to use the BigInteger
 * class)
 * exampe:
 * input: "123"
 * output: "124"
 * 
 * input: "99"
 * output: "100"
 */

public class RepresentLargeInteger {
    public String addOne(String input) {
        // corner case
        if (input == null || input.isEmpty()) {
            return input;
        }
        // if we keep meeting nine, we change it to 0 from back to beginning
        char[] array = input.toCharArray();
        int end = 0;
        while (end >= 0 && array[end] == '9') {
            array[end--] = '0';
        }
        // case 1: end < 0, need to append one in the beginning
        // case 2: end >= 0
        if (end < 0) {
            return "1" + new String(array);
        } else {
            return new String(array);
        }
    }
}
