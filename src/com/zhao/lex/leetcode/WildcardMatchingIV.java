package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/6.
 */
public class WildcardMatchingIV {
    public static int num = 0;
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                num++;
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if(p.charAt(j - 1) == '*' && dp[i][j - 1]) {
                    dp[i][j] = (dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1]);
                }
                else if(p.charAt(j - 1) == '*' && !dp[i][j - 1]) {
                    dp[i][j] = dp[i][j - 2];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";
        System.out.println(WildcardMatchingIV.isMatch(s, p));
        System.out.println(WildcardMatchingIV.num);
    }
}
