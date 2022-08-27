package com.interviewbit.amazone.strings;

public class LongestPalindromicSubstring {
    /*
    Runtime: 23 ms, faster than 90.85% of Java online submissions for Longest Palindromic Substring.
    Memory Usage: 42.8 MB, less than 79.40% of Java online submissions for Longest Palindromic Substring.
     */
    int start;
    int resultLength;

    public String longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 2) return s;
        for (int i = 0; i < strLength - 1; i++) {
            expandFromMiddle(s, i, i);
            expandFromMiddle(s, i, i + 1);
        }
        return s.substring(start, start + resultLength);
    }

    private void expandFromMiddle(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            start = begin + 1;
            resultLength = end - begin - 1;
        }
    }


    // Using local Variables
    /*
    Runtime: 20 ms, faster than 93.78% of Java online submissions for Longest Palindromic Substring.
    Memory Usage: 42 MB, less than 96.87% of Java online submissions for Longest Palindromic Substring.
     */
    public static String longestPalindromeWithLocalVariable(String s) {
        int[] startAndLength = new int[2];
        int strLength = s.length();
        if (strLength < 2) return s;
        for (int i = 0; i < strLength - 1; i++) {
            isPalindrome(s, i, i, startAndLength);
            isPalindrome(s, i, i + 1, startAndLength);
        }
        return s.substring(startAndLength[0], startAndLength[0] + startAndLength[1]);
    }

    private static void isPalindrome(String s, int begin, int end, int[] startAndLength) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        if (startAndLength[1] < end - begin - 1) {
            startAndLength[0] = begin + 1;
            startAndLength[1] = end - begin - 1;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd")); // bb
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad")); // bab

        System.out.println(longestPalindromeWithLocalVariable("cbbd")); // bb
        System.out.println(longestPalindromeWithLocalVariable("babad")); // bab
    }
}
