package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/3.
 */
public class WildcardMatchingII {
    /*
    public static boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    */
    public static boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        int result = 0;
        result = help(s, p, dp, s.length(), p.length());
        if(result == s.length()) return true;
        else return false;
    }

    private static int help(String s, String p, int[][] dp, int len1, int len2) {
        if(dp[len1][len2] != 0) return dp[len1][len2];
        if(len1 == 0 && len2 == 0) return 0;
        else if(len1 == 0) {
            if(len2 == 1) return -1;
            for(int i = 0; i < len2 - 1; i ++) {
                if(p.charAt(i) != '*')
                    if(i + 1 < len2 && p.charAt(i + 1) != '*') return -1;
                    else continue;
                else continue;
            }
            if(p.charAt(len2 - 1) != '*') return -1;
            return 0;
        }
        else if(len2 == 0) return -1;
        if(s.charAt(len1 - 1) == p.charAt(len2 - 1) || p.charAt(len2 - 1) == '.') {
            int temp = help(s, p, dp, len1 - 1, len2 - 1);
            if(temp != -1)  dp[len1][len2] = temp + 1;
            else return -1;
        }else if(p.charAt(len2 - 1) == '*' && ( p.charAt(len2 - 2) == s.charAt(len1 - 1) || p.charAt(len2 - 2) == '.')) {
            int temp_1 = help(s, p, dp, len1 - 1, len2 - 1);
            if(temp_1 != -1) dp[len1][len2] = temp_1 + 1;
            else {
                int temp_2 = help(s, p, dp, len1 - 1, len2);
                if(temp_2 != -1) dp[len1][len2] = temp_2 + 1;
                else {
                    int temp_3 = help(s, p, dp, len1, len2 - 2);
                    dp[len1][len2] = temp_3;
                }
            }
        }else if(p.charAt(len2 - 1) == '*' && p.charAt(len2 - 2) != s.charAt(len1 - 1)) {
            int temp = help(s, p, dp, len1, len2 - 2);
            dp[len1][len2] = temp;
        }
        else {
            return -1;
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String p = "aaa*aaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(WildcardMatchingII.isMatch(s, p));
    }
}
