package com.lavalliere.daniel.aps;
import java.util.*;

public class PatternMatch {

//---------------------------------------------------------
// Variation on (Difficulty: Very Difficult)
// LeetCode: 32. Longest Valid Parentheses
//-----------------------------------------------------------

/*
2. Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions )
so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.


Example 1:

Input: "())"    --> to be balanced need (())
Output: 1
Example 2:

Input: "((("    --> to be balanced need ((()))
Output: 3
Example 3:

Input: "()"
Output: 0
Example 4:

Input: "()))(("    --> to be balanced need ((()))(())
Output: 4
*/

public int getMissingParenCount(String pattern) {
    // Failed test from PaymntLabs Canada ... O n
    char lastParen = '\0';
    int totalMissing = 0;
    int rparencnt = 0;
    int lparencnt = 0;
    System.out.printf("Current pattern: %s\n", pattern);
    for(int i = 0; i < pattern.length(); i++) {
        if (pattern.charAt(i) == '(') {
            lparencnt++;
        } else if (pattern.charAt(i) == ')') {
            rparencnt++;
        }
        lastParen = pattern.charAt(i);

    }
    return totalMissing;
}



}
