package com.codingquestions.app.BitRepresentationAndOperation;

/**
 * Determine if a given integer is power of 2.
 * 
 * Examples
 * 
 * 16 is power of 2 (2 ^ 4) 3 is not 0 is not -1 is not
 * 
 */

// TIME: O(number of bits)
// SPACE: O(1)
public class PowerOfTwo {
    public boolean isPowerOfTwo(int number) {
        if (number < 0) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((number >> i & 1) == 1) {
                if (count == 0) {
                    count++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // trick
    public boolean isPowerOfTwoMethod2(int number) {
        return number > 0 && (number & (number - 1)) == 0;
    }

}