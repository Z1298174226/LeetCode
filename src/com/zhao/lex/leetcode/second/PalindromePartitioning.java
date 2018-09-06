package com.zhao.lex.leetcode.second;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2018/8/28.
 */
public class PalindromePartitioning {
    public static int minCut(String s) {
        if(s == null || s.length() == 0 || s.length() ==1) return 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        List<String> result = new ArrayList<String>();
        int[] cuts = new int[length];
        for(int i = 0; i < length; i++) {
            dp[i][i] = true;
            int min  = i;
            for(int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1]);
                if(dp[j][i]) {
                    min = (j == 0) ? 0 : Math.min(min, cuts[j - 1] + 1);
                }
            }
            cuts[i] = min;
        }
        return cuts[length - 1];
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaabbbbbbbbbbbbbbbc";
        System.out.println(PalindromePartitioning.minCut(s));
    }
}
