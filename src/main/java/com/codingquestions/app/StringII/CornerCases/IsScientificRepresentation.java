package com.codingquestions.app.StringII.CornerCases;

/**
 * determine if a string is a valid scientific representation
 */

public class IsScientificRepresentation {
    public boolean isValidScientificRepresentation(String s) {
        String str = s.trim();

        boolean seenNumber = false;
        boolean seenSignBeforeE = false;
        boolean seenE = false;
        boolean seenPoint = false;
        boolean seenNumberAfterE = false;
        boolean seenSignAfterE = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') {
                if (((seenPoint || seenNumber) && !seenE) || seenNumberAfterE) {
                    return false;
                }
                if (seenSignAfterE || (!seenE && seenSignBeforeE)) {
                    return false;
                }
                if (seenE) {
                    seenSignAfterE = true;
                } else {
                    seenSignBeforeE = true;
                }
            } else if (c >= '0' && c <= '9') {
                seenNumber = true;
                if (seenE)
                    seenNumberAfterE = true;
            } else if (c == 'e' || c == 'E') {
                if (seenE)
                    return false;
                if (!seenNumber)
                    return false;
                seenE = true;
            } else if (c == '.') {
                if (seenE || seenPoint)
                    return false;
                seenPoint = true;
            } else {
                return false;
            }
        }

        if (seenE && !seenNumberAfterE) {
            return false;
        }
        return seenNumber;
    }
}