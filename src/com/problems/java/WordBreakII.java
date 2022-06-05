package com.problems.java;

import java.util.ArrayList;
import java.util.List;
/*
Given a string s and a dictionary of strings wordDict,
add spaces in s to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences in any order.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]

Example 2:
Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 */
public class WordBreakII {

    public static void main(String[] args) {
        List<String> dict = List.of(new String[]{"cat", "cats", "and", "sand", "dog"});
        String s = "catsanddog";

        List<String> result = wordBreak(s, dict);
        System.out.println(result);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        String ans = "";
        findSentence(s, result, ans, wordDict);

        return result;
    }

    private static void findSentence(String s, List<String> result, String ans, List<String> dict) {
        if(s.length()==0){
            result.add(ans.trim());
        }
        for(int i=0;i<s.length();i++){
            String left = s.substring(0, i+1);
            if(dict.contains(left)){
                String right = s.substring(i+1);
                findSentence(right, result, ans + left + " ", dict);
            }
        }
    }
}
