package com.codingquestions.app.BitRepresentationAndOperation;

/**
 * Generate the hexadecimal representation for a given non-negative integer
 * number as a string. The hex representation should start with "0x".
 * 
 * There should not be extra zeros on the left side.
 * 
 * Examples
 * 
 * 0's hex representation is "0x0" 255's hex representation is "0xFF"
 */

public class HexadecimalRepresentation {
    public String hex(int number) {
        String prefix = "0x";
        if (number == 0) {
            return prefix + '0';
        }

        boolean trailing = true;
        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 28; i >= 0; i -= 4) {
            int num = (number >> i & 0xf);
            if (num < 10) {
                if (num != 0) {
                    sb.append((char) ('0' + num));
                    trailing = false;
                } else if (!trailing) {
                    sb.append((char) ('0' + num));
                }
            } else {
                sb.append((char) ('A' + num - 10));
                trailing = false;
            }
        }
        return sb.toString();
    }
}