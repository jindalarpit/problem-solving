package com.problems.java;

import java.util.*;

/*
A transformation sequence from word beginWord to word endWord
using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList,
return the number of words in the shortest transformation sequence from beginWord to endWord,
or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size()==0 || !wordList.contains(endWord))
            return 0;
        LinkedList<String> wordQueue = new LinkedList<>();
        LinkedList<Integer> distanceQueue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        wordQueue.add(beginWord);
        distanceQueue.add(1);
        int result = Integer.MAX_VALUE;
        while(!wordQueue.isEmpty()){
            String currentWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();
            if (currentWord.equals(endWord))
                result = Math.min(result, currDistance);
            for(int i=0; i<currentWord.length(); i++){
                char[] currCharArray = currentWord.toCharArray();
                for (char c='a'; c<='z'; c++){
                    currCharArray[i] = c;
                    String replacedString = new String(currCharArray);
                    if(dict.contains(replacedString)){
                        wordQueue.add(replacedString);
                        distanceQueue.add(currDistance+1);
                        dict.remove(replacedString);
                    }
                }
            }
        }
        if(result < Integer.MAX_VALUE)
            return result;
        else
            return 0;
    }
}
