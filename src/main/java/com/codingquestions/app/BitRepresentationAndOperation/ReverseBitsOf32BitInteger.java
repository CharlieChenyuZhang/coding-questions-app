package com.codingquestions.app.BitRepresentationAndOperation;

/**
 * Reverse bits of a 32-bit integer.
 * 
 * Note: In different programming languages, integers might be implemented
 * differently in terms of number of bits, signed, unsigned, etc. However it
 * should not affect your implementation on this problem. In java, the type of
 * input is long, but you just need to work on the last 32-bit and consider it
 * as an unsigned 32-bit integer.
 * 
 * Example 1:
 * 
 * Input: 1234 (0b'00000000000000000000010011010010)
 * 
 * Output: 1260388352 (0b'01001011001000000000000000000000)
 */

public class ReverseBitsOf32BitInteger {
    public long reverseBits(long num) {
        for (int offset = 0; offset < 16; offset++) {
            long right = (num >> offset) & 1L;
            long left = (num >> (31 - offset)) & 1L;
            if (left != right) {
                num ^= (1L << offset);
                num ^= (1L << (31 - offset));
            }
        }
        return num;
    }
}