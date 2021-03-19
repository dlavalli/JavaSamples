package com.lavalliere.daniel.aps;

public class PasswordValidator {
    static boolean isValid(String msg) {
        if ((msg.length() < 8) || (msg.length() > 71)) {
            return false;
        }

        boolean upCaseFlag = false;
        boolean lowCaseFlag = false;
        boolean numberFlag = false;
        boolean spaceFlag = false;
        boolean otherFlag = false;
        char[] chars = msg.toCharArray();
        for(char ch : chars) {
            if (Character.isUpperCase(ch)) {
                upCaseFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowCaseFlag = true;
            } else if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isWhitespace(ch)) {
                spaceFlag = true;
            } else {
                otherFlag = true;
            }
        }

        return (upCaseFlag && lowCaseFlag && numberFlag && otherFlag && !spaceFlag);
    }
}
