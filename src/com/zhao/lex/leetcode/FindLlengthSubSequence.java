package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2018/11/23.
 */
public class FindLlengthSubSequence {
    public int findLlengthSubsequence(String s, int l) {
        if(s.length() < l) return 0;
        int result = 0;
        int length = s.length();
        int[] dp = new int[length];
        for(int i = l - 1; i < length; i++)
            dp[i] = 1;
//        Arrays.fill(dp, 1);
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < i - l + 1; j++) {
                if(s.charAt(i) != s.charAt(j)) {
                    dp[i] += dp[j];
                }
            }
            result += dp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindLlengthSubSequence().findLlengthSubsequence("aabaa", 3));
    }
}
