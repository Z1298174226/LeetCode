package com.zhao.lex.second;

/**
 * Created by qtfs on 2018/8/28.
 */
public class WildcardMatchingII {
    public static boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        int result = help(dp, s, p, s.length(), p.length());
        System.out.println(result);
        return result == s.length();
    }

    public static int help(int[][] dp, String s, String p, int s_index, int p_index) {
        if(dp[s_index][p_index] != 0) return dp[s_index][p_index];
        if(s_index == 0 && p_index == 0) return 0;
        else if(s_index == 0) {
            for(int i = 0; i < p_index; i++) {
                if(p.charAt(i) != '*') return -1;
            }
            return 0;
        }
        else if(p_index == 0) return -1;
        else {
            if(s.charAt(s_index - 1) == p.charAt(p_index - 1) || p.charAt(p_index - 1) == '?') {
                int temp = help(dp, s, p, s_index - 1, p_index - 1);
                dp[s_index][p_index] = temp == -1 ? -1 : temp + 1;
            }
            else if(p.charAt(p_index - 1) == '*') {
                int temp = help(dp, s, p, s_index - 1, p_index - 1);
                if(temp != -1)
                    dp[s_index][p_index] = temp + 1;
                else {
                    temp = help(dp, s, p, s_index - 1, p_index);
                    if(temp != -1)
                        dp[s_index][p_index] = temp + 1;
                    else {
                        dp[s_index][p_index] = help(dp, s, p, s_index, p_index - 1);
                    }
                }
            }
        }
        return dp[s_index][p_index];
    }

    public static void main(String[] args) {
        String s = "adfdgdf";
        String p = "*a*f";
        System.out.println(WildcardMatchingII.isMatch(s, p));
    }
}
