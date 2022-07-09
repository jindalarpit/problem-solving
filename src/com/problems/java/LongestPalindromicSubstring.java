package com.problems.java;
/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "cbbd";
        String longestPalindrome = longestPalindromeSubstring(s);
        System.out.println(longestPalindrome);
    }

    private static String longestPalindromeSubstring(String s) {
        if(s==null || s.isEmpty()){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        String longestPalindrome = s.substring(0,1);
        for(int i=0; i< s.length();i++){
            String tmp = findPalindrome(s, i, i);
            if(tmp.length()>longestPalindrome.length()){
                longestPalindrome = tmp;
            }

            tmp = findPalindrome(s, i, i+1);
            if(tmp.length()>longestPalindrome.length()){
                longestPalindrome = tmp;
            }
        }
        return longestPalindrome;
    }

    private static String findPalindrome(String s, int left, int right) {
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
