package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qtfs on 2018/11/2.
 */
public class WordBreakII {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> result = new HashMap<String, Boolean>();
       dfs(result, s, wordDict);
       return result.get(s);
    }

    private Boolean dfs(Map<String, Boolean> result, String substring, List<String> wordDict) {
        if(result.containsKey(substring))
            return result.get(substring);
        boolean flag = false;
        if(substring.length() == 0)
            return true;
        for(String word : wordDict) {
            if(substring.startsWith(word)) {
               flag = flag || dfs(result, substring.substring(word.length()), wordDict);
            }
        }
        result.put(substring, flag);
        return flag;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("apple");
        wordDict.add("pen");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
        System.out.println(new WordBreakII().wordBreak("applepenapple", wordDict));
    }
}
