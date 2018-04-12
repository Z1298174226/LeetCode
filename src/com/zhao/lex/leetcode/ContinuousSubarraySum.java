package com.zhao.lex.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qtfs on 2017/11/16.
 */
public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int resultSum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            resultSum += nums[i];
            if(k != 0) resultSum %= k;
            Integer pre = map.get(resultSum);
            if(pre != null) {
                if (i - pre > 1) return true;
            }
            else map.put(resultSum, i);
        }
        return false;
    }
    /*
    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 1) return false;
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
          //  if(dp[i][i] == k || (k != 0 && dp[i][i] % k == 0)) return true;
            for(int j = i - 1; j >= 0; j--) {
                dp[j][i] = dp[j][i - 1] + nums[i];
                if(dp[j][i] == k || (k != 0 && dp[j][i] % k == 0)) return true;
            }
        }
        return false;
    }
    */

    public static void main(String[] args) {
        int[] nums = new int[]{4,10,7,1,5,5,2,5,1,3,5,7,5,8,1,0,3,5,5,9,0,8,4,3,8,9,6,1,5,3,0,9,0,8,6,5,2,3,3,1,3};
        int result = 0;
        System.out.println(ContinuousSubarraySum.checkSubarraySum(nums, 23));
    }
}

