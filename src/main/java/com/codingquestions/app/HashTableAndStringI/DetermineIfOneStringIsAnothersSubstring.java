package com.codingquestions.app.HashTableAndStringI;

/**
 * Determine if a small string is a substring of another large string.
 * 
 * Return the index of the first occurrence of the small string in the large
 * string.
 * 
 * Return -1 if the small string is not a substring of the large string.
 * 
 * Assumptions
 * 
 * Both large and small are not null If small is empty string, return 0 Examples
 * 
 * “ab” is a substring of “bcabc”, return 2 “bcd” is not a substring of “bcabc”,
 * return -1 "" is substring of "abc", return 0
 */

public class DetermineIfOneStringIsAnothersSubstring {
    // method 1: sliding window
    // TIME: O(n^2)
    // SPACE: O(1)
    public int strstr(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }

        if (small.length() == 0) {
            return 0;
        }

        // NOTEL the ending index
        for (int i = 0; i <= large.length() - small.length(); i++) {
            int tmp = i;
            for (int j = 0; j < small.length(); j++) {
                if (large.charAt(tmp) != small.charAt(j)) {
                    break;
                }
                tmp++;
            }
            if (tmp - i == small.length()) {
                return i;
            }
        }
        return -1;
    }

    // TIME: O(n)
    // SPACE: O(1)
    // assuming the known charSize is the 26 lower case characters
    public int strstr2(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }

        if (small.length() == 0) {
            return 0;
        }

        int charSize = 26;

        int targetHash = 0;

        for (int i = small.length() - 1; i >= 0; i--) {
            targetHash += (small.charAt(i) - 'a') * exponential(charSize, small.length() - i - 1);
        }

        int hash = 0;
        for (int i = 0; i <= small.length() - 1; i++) {
            hash += (large.charAt(i) - 'a') * exponential(charSize, small.length() - 1 - i);
        }

        // make sure the same hash won’t caused by collision
        if (hash == targetHash && equals(large, small, 0)) {
            return 0;
        }

        for (int i = 1; i <= large.length() - small.length(); i++) {
            int prev = (large.charAt(i - 1) - 'a') * exponential(charSize, small.length() - 1);
            int next = (large.charAt(i + small.length() - 1) - 'a');
            hash = (hash - prev) * charSize + next;

            if (hash == targetHash && equals(large, small, i)) {
                return i;
            }
        }
        return -1;
    }

    // start → start index in large
    private boolean equals(String large, String small, int start) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(start + i) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int exponential(int base, int exponent) {
        int result = 1;
        while (exponent > 0) {
            result *= base;
            exponent--;
        }
        return result;
    }

    public int strstr3(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }

        if (small.length() == 0) {
            return 0;
        }

        // handle overflow case
        int largePrime = 101;
        int prime = 31;

        int seed = 1;
        int targetHash = small.charAt(0) % largePrime;
        // result of seed after the following for loop
        // seed == prime^(small.length() - 1) % largePrime
        // hash=(s0*smallPrime^k + ... + sk*smallPrime^0) % largePrime
        for (int i = 1; i < small.length(); i++) {
            seed = moduleHash(seed, 0, prime, largePrime);
            targetHash = moduleHash(targetHash, small.charAt(i), prime, largePrime);
        }

        int hash = 0;
        for (int i = 0; i < small.length(); i++) {
            hash = moduleHash(hash, large.charAt(i), prime, largePrime);
        }

        if (hash == targetHash && equals(large, 0, small)) {
            return 0;
        }

        for (int i = 1; i <= large.length() - small.length(); i++) {
            hash = nonNegative(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
            hash = moduleHash(hash, large.charAt(i + small.length() - 1), prime, largePrime);

            if (hash == targetHash && equals(large, i, small)) {
                return i;
            }
        }
        return -1;
    }

    // addition is the int Decimal number representation of the character
    // hash=(s0*smallPrime^k + ... + sk*smallPrime^0) % largePrime
    private int moduleHash(int hash, int addition, int prime, int largePrime) {
        return (hash * prime % largePrime + addition) % largePrime;
    }

    private boolean equals(String large, int start, String small) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(i + start) != small.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private int nonNegative(int hash, int largePrime) {
        if (hash < 0) {
            hash += largePrime;
        }

        return hash;
    }
}