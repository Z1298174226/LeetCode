package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/8.
 */
public class WordDictionary {
    /** Initialize your data structure here. */
    private List<String> list;
    public WordDictionary() {
        list = new ArrayList<String>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        list.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        for(String item : list) {
            if(word.length() != item.length()) continue;
            if(dfs(item, word, 0, 0))
                return true;
        }
        return false;
    }

    private boolean dfs(String content, String word, int index, int start) {
        if(start >= word.length()) return true;
        if(index < 0 || index >= content.length()) return false;
        if(content.charAt(index) == word.charAt(start) || word.charAt(start) == '.') {
            return dfs(content, word, index + 1, start + 1);
        }else return false;
    }

    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("at");
        dic.addWord("and");
        dic.addWord("an");
        dic.addWord("add");
        System.out.println(dic.search("a"));
        System.out.println(dic.search(".at"));
        dic.addWord("bat");
        System.out.println(dic.search(".at"));
        System.out.println(dic.search("an."));
        System.out.println(dic.search("a.d."));
        System.out.println(dic.search("b."));
        System.out.println(dic.search("a.d"));
        System.out.println(dic.search("."));

    }
}
