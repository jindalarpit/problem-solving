package com.ds.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testTrie {
    public static void main(String[] args) {
        List<String> stringList = Arrays.stream(new String[]{"test", "tent" , "rest", "reck"}).toList();
        Trie trie = new Trie();
        for(int i = 0; i<stringList.size(); i++){
            String currString = stringList.get(i);
            Trie root = trie;
            for(char c: currString.toCharArray()){
                if(!root.charMap.containsKey(c)){
                    root.charMap.put(c, new Trie());
                }
                root = root.charMap.get(c);
                root.wordIndex.add(i);
            }
        }
        printTrie(trie);
    }

    private static void printTrie(Trie trie) {
        if(trie.charMap.isEmpty())
            return;
        else{
            System.out.println("KeySet: " + trie.charMap.keySet());
            System.out.println("wordIndex: " + trie.wordIndex);
            for(char c: trie.charMap.keySet())
                printTrie(trie.charMap.get(c));
        }
    }
}
