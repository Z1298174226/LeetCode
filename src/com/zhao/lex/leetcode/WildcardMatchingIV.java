package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/6.
 */
public class WildcardMatchingIV {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*' && i % 2 == 0 && i > 1 && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
//        for(int i = 1; i <= s.length(); i++) {
//            for(int j = 1; j <= p.length(); j++) {
//                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
//                    dp[i][j] = dp[i - 1][j - 1];
//                else if(p.charAt(j - 1) == '*' && dp[i][j - 1]) {
//                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];
//                }
//                else if(p.charAt(j - 1) == '*' && !dp[i][j - 1]) {
//                    dp[i][j] = dp[i][j - 2];
//                }
//            }
//        }
        for (int i = 1 ; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = (dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean match(char[] str, char[] pattern)
    {
        int length1 = str.length;
        int length2 = pattern.length;
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true; dp[0][1] = false;
        for(int i = 1; i <= length1; i++)
            dp[i][0] = false;
        for(int i = 2; i < length2; i++) {
            if(i % 2 == 0 && pattern[i] == '*')
                dp[0][i] = dp[0][i - 2];
        }
        for(int i = 1; i <= length1; i++) {
            for(int j = 1; j <= length2; j++) {
                if(str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if(pattern[j - 1] == '*') {
                    if(pattern[j - 2] != '.' && pattern[j - 2] != str[i - 1])
                        dp[i][j] = dp[i][j - 2];
                    else
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                }

            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String s = "aaa";
        String p = "ab*ac*a";
        System.out.println(WildcardMatchingIV.isMatch(s, p));
    }
}
