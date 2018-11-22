package com.zhao.lex.second;

/**
 * Created by qtfs on 2018/8/28.
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 1])
                dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        System.out.println(WildcardMatching.isMatch(s, p));
    }
}
