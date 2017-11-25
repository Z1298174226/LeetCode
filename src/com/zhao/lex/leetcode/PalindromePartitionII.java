package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/13.
 */
public class PalindromePartitionII {
    public static List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1]);
            }
        }
        List<List<String>> lists = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        dfs(dp, 0,s, lists, list);
        return lists;
    }

    private static void dfs(boolean[][] dp, int start, String s, List<List<String>> lists, List<String> list) {
        if(start > s.length()) return;
        if(start == s.length()) {
            lists.add(new ArrayList<String>(list));
            return;
        }
        for(int i = start; i < s.length(); i++) {
            if(dp[start][i]) {
                list.add(s.substring(start, i + 1));
                dfs(dp, i + 1, s, lists, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aabcccccccc";
        for(List<String> list : PalindromePartitionII.partition(s)) {
            for(String str : list) {
                System.out.print(String.format("%9s", str));
            }
            System.out.println();
        }
    }
}
