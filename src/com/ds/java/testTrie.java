package com.ds.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testTrie {
    public static void main(String[] args) {
        List<String> stringList = Arrays.stream(new String[]{"test", "tent" , "rest", "reck"}).toList();
        Trie trie = new Trie();
        for (String currString : stringList) {
            Trie root = trie;
            for (char c : currString.toCharArray()) {
                if (!root.charMap.containsKey(c)) {
                    root.charMap.put(c, new Trie());
                }
                if (!root.wordList.contains(currString))
                    root.wordList.add(currString);
                root = root.charMap.get(c);
                root.wordList.add(currString);
            }
        }
        printTrie(trie);
    }

    private static void printTrie(Trie trie) {
        if(!trie.charMap.isEmpty()) {
            System.out.println("KeySet: " + trie.charMap.keySet());
            System.out.println("wordList: " + trie.wordList);
            for(char c: trie.charMap.keySet())
                printTrie(trie.charMap.get(c));
        }
    }
}
