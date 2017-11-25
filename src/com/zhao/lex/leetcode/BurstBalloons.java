package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/3.
 */
public class BurstBalloons {
    public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;
        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    public static int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8,};
        System.out.println(BurstBalloons.maxCoins(nums));
    }

}
