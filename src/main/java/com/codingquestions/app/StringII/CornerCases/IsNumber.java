package com.codingquestions.app.StringII.CornerCases;

/** determine if a string can be converted to number */

public class IsNumber {
    public boolean isNumber(String s) {
        String str = s.trim();
        boolean seenPoint = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') {
                if (seenPoint) {
                    return false;
                }
                seenPoint = true;
            } else if (c < '0' && c > '0') {
                return false;
            }
        }
        return true;
    }
}