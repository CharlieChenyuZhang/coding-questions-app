package com.codingquestions.app.BitRepresentationAndOperation;

/**
 * Determine the number of bits that are different for two given integers.
 * 
 * Examples
 * 
 * 5(“0101”) and 8(“1000”) has 3 different bits
 */

public class NumberOfDifferentBits {

    // TIME: O(number of bits)
    // SPACE: O(1)
    public int diffBits(int a, int b) {
        int offset = 0;
        int count = 0;
        while (offset < 32) {
            if ((a >> offset & 1) != (b >> offset & 1)) {
                count++;
            }
            offset++;
        }
        return count;
    }

    public int diffBitsSolution2(int a, int b) {
        int count = 0;
        a ^= b;
        while (a != 0) {
            count += a & 1;
            a >>>= 1;
        }
        return count;
    }

}