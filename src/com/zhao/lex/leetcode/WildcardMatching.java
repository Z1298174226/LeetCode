package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/2.
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        int result = 0;
        result = help(s, p, dp, s.length(), p.length());
        if(result == s.length()) return true; //(s.length() > p.length() ? s.length(): p.length())) return true;
        else return false;
    }
    private static int help(String s, String p, int[][] dp, int len1, int len2) {
        if(dp[len1][len2] != 0) return dp[len1][len2];
        if(len1 == 0 && len2 == 0) return 0;
        else if(len1 == 0) {
            for(int i = 0; i < len2; i++) {
                if(p.charAt(i) != '*') return -1;
            }
            return 0;
        }
        else if(len2 == 0) return -1;
        if(s.charAt(len1 - 1) == p.charAt(len2 - 1) || p.charAt(len2 - 1) == '?') {
            int temp = help(s, p, dp, len1 - 1, len2 - 1);
            if(temp != -1)  dp[len1][len2] = temp + 1;
            else return -1;
        }else if(p.charAt(len2 - 1) == '*') {
            int temp_1 = help(s, p, dp, len1 - 1, len2 - 1);
            if(temp_1 != -1) dp[len1][len2] = temp_1 + 1;
            else {
                int temp_2 = help(s, p, dp, len1 - 1, len2);
                if(temp_2 != -1) dp[len1][len2] = temp_2 + 1;
                else {
                    int temp_3 = help(s, p, dp, len1, len2 - 1);
                    dp[len1][len2] = temp_3;
                }
            }
        }else {
            return -1;
        }
        return dp[len1][len2];
    }
    public static void main(String[] args) {
      // String s = "abefcdgiescdfi";   //"abefcdgiescdfimde"
      // String p = "ab*cd?i";
        String s = "aaaaaaaaaaaaaaa";
        String p = "?????????????????????**a";
        System.out.println(WildcardMatching.isMatch(s, p));
    }
}
