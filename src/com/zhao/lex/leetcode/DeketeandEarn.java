package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2017/12/9.
 */
public class DeketeandEarn {
    public static int deleteAndEarn(int[] nums) {
        int length = nums.length;
        int newLength = length + 2;
        int[] newNums = new int[length + 2];
        int result = 0;
        Arrays.sort(nums);
        newNums[0] = 0; newNums[length + 1] = 0;
        for(int i = 1; i <= length; i++)
            newNums[i] = nums[i - 1];
        int[][] dp = new int[newLength][newLength];
        for(int k = 2; k < newLength; k++) {
            for(int left = 0; left < newLength - k; left++) {
                int pre = -10000;
                int right = left + k;
                for(int i = left + 1; i < right; i++) {
                    if(newNums[i] != pre && newNums[i] != pre + 2) {
                        dp[left][right] = Math.max(dp[left][right], newNums[i] + dp[left][i] + dp[i][right]);
                        pre = newNums[i] - 1;
                    }
                    else {
                        dp[left][right] = Math.max(dp[left][right], dp[left][i] + dp[i][right]);
                    }
                    result = Math.max(result, dp[left][right]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3 , 3, 3, 3, 3,3, 4};
        System.out.println(DeketeandEarn.deleteAndEarn(nums));
    }
}

