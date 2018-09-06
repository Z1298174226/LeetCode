package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qtfs on 2017/10/24.
 */
public class WordBreak {
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        if(s == null) return false;
//        if(wordDict.size() == 0) return false;
//        int len = s.length();
//      //  boolean[][] dp = new boolean[len + 1][len + 1];
//        boolean[] dp = new boolean[len + 1];
//      //  dp[0][0] = true;
//        dp[0] = true;
//        for(int i = 1; i <= len; i++) {
//            for(int j = 0; j <= i; j++) {
////                dp[j][i] = wordDict.contains(s.substring(j, i));
////                if(dp[0][j] && dp[j][i])
////                    dp[0][i] = true;
//                if(dp[j] && wordDict.contains(s.substring(j, i)))
//                    dp[i] = true;
//            }
//        }
//       // return dp[0][len];
//        return dp[len];
//    }
//public static List<String> wordBreak(String s, List<String> wordDict) {
//    List<String> list = new ArrayList<String>();
//    if(s == null) return list;
//    if(wordDict.size() == 0) return list;
//    int len = s.length();
//    boolean[][] dp = new boolean[len +1][len + 1];
//    dp[0][0] = true;
//    for(int i = 1; i <= len; i++) {
//        for(int j = 0; j <= i; j++) {
//            dp[j][i] = wordDict.contains(s.substring(j, i));
//            if(dp[0][j] && dp[j][i])
//                dp[0][i] = true;
//
//        }
//    }
//    dp[len][len] = true;
//    String part = new String();
//    help(s, dp, list, wordDict, 0, part);
//    return list;
//}
//
//    private static void help(String s, boolean[][] dp, List<String> list, List<String> wordDict,int start, String part) {
//        if(start == s.length()) {
//            list.add(part);
//            return;
//        }
//        for(int i = start + 1; i <= s.length(); i++) {
//            if(dp[start][i] && dp[i][s.length()]) {
//                if(wordDict.contains(s.substring(start, i))) {
//                    if(start == 0) {
//                        String newPart = new String();
//                        newPart += s.substring(start, i);
//                        newPart += i == s.length() ? "" : " ";
//                        help(s, dp, list, wordDict, i, newPart);
//                     }
//                    else {
//                        part += s.substring(start, i);
//                        part += i == s.length() ? "" : " ";
//                        help(s, dp, list, wordDict, i, part);
//                    }
//                }
//            }
//        }
//    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> list = dfs(s, wordDict, map);
        return list;
    }
    private static List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<String>();
        if(s.length() == 0) {
            res.add("");
            return res;
        }
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), wordDict, map);
                for(String sub : subList)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("cat"); list.add("cats"); list.add("and"); list.add("sand");list.add("dog");list.add("t");
        System.out.println(WordBreak.wordBreak("anddogs", list));
    }
}
