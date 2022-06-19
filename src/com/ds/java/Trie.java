package com.ds.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    Map<Character, Trie> charMap = new HashMap<>();
    List<Integer> wordIndex = new ArrayList<>();
}
