package com.codingquestions.app.StringII.CornerCases;

/**
 * convert a string to an int
 * 
 * This question tests your are detail oriented and considers all corner cases
 */

public class AToI {
    public int AToI(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int n = str.length();
        int i = 0;
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }

        boolean positive = true;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            positive = (str.charAt(i) == '+');
            i++;
        }

        long sum = 0;
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            sum = sum * 10 + (str.charAt(i) - '0');
            if (sum > (long) Integer.MAX_VALUE + 1) { // + 1 because we are calculating absolute value and | MIN_VALUE |
                                                      // = MAX_VALUE + 1
                break;
            }
            i++;
        }

        sum = positive ? sum : -sum;
        if (sum > (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (sum < (long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) sum;
    }
}