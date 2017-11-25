package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/10/27.
 */
public class ConcatenatedWords {
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<String>();
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        for(String word : words) {
            if(dfs(word, words, map).size() > 1)
                list.add(word);
        }
        return list;
    }
    private static Set<String> dfs(String s, String[] wordList, Map<String, Set<String>> map) {
        if(map.containsValue(s)) {
            return map.get(s);
        }
        Set<String> list = new HashSet<String>();
        if(s.length() == 0)
            return list;
        for(String word : wordList) {
            if(word != s) {
                if (s.startsWith(word)) {
                    list.addAll(dfs(s.substring(word.length()), wordList, map));
                    list.add(word);
                }
            }
        }
        map.put(s, list);
        return list;
    }
    public static void main(String[] args) {
        String[] words = new String[]{"cat","cats","catsdogcats","dog","catcatdagcat","dagdogdogcat","catdogcatdogcatdogcatdogcatdog","dogcatsdog","hippopotamuses","rat","ratcatdogcat", "s"};
        List<String> list = ConcatenatedWords.findAllConcatenatedWordsInADict(words);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
