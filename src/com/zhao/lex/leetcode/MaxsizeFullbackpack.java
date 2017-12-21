package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2017/12/11.
 */
public class MaxsizeFullbackpack {

    public static int maxsizeFullbackpack(int[] items, int cap) {
        int[] dp = new int[cap + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for(int i = 0; i < items.length; i++) {
            for(int j = cap; j >= items[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - items[i]] + 1);
            }
        }
        for(int k = cap; k >= 0; k--) {
            if( dp[k] < 1000000) {
                return k;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] items = new int[]{2, 3, 5, 7};
        System.out.println(maxsizeFullbackpack(items, 4));
    }
}
