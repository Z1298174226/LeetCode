package com.zhao.lex.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by qtfs on 2017/11/20.
 */
public class LongestWordinDictionarythroughDeleting {
    public static String findLongestWord(String s, List<String> d) {
        Queue<String> queue = new PriorityQueue<String>();
        int result = Integer.MIN_VALUE;
        for(String word : d) {
           int[][] dp = new int[s.length() + 1][word.length() + 1];
            if(dfs(s, word, s.length(), word.length(),dp) == word.length()) {
                if (result <= word.length()) {
                    result = word.length();
                    queue.add(word);
                }
            }
        }
        while (true) {
            String re = queue.poll();
            if (re == null || re.length() == result)
                return re;
        }

    }

    private static int dfs(String s, String p, int index1, int index2, int[][] dp) {
        if(dp[index1][index2] != 0) return dp[index1][index2];
        if(index1 == 0 && index2 == 0) return 0;
        else if(index2 == 0) return 0;
        else if(index1 == 0) return -1;
        if(s.charAt(index1 - 1) == p.charAt(index2 - 1)) {
            int temp = dfs(s, p, index1 - 1, index2 - 1, dp);
            dp[index1][index2] = temp + 1;
        }
        else {
            dp[index1][index2] = dfs(s, p, index1 - 1, index2, dp);
        }
        return dp[index1][index2];
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple","apply","monkey");
        String s = "abpcpleay";
        System.out.println(LongestWordinDictionarythroughDeleting.findLongestWord(s, list));
    }
}
