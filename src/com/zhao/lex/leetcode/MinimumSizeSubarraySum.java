package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/18.
 */
public class MinimumSizeSubarraySum {
    /*
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
        mapIndex.put(0, -1);
        int sumResult = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sumResult += nums[i];
            Integer pre = mapIndex.get(sumResult - s);
            if(pre != null) {
                min = Math.min(min, i - pre);
            }
            mapIndex.put(sumResult, i);
        }
        return min;
    }
    */
    public static int minSubArrayLen(int s, int[] nums) {
        int[] sumArray = new int[nums.length + 1];
        sumArray[0] = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArray[i + 1] = sum;
        }
        int min = Integer.MAX_VALUE;
        int left = 0; int right = 0;
        while(left < sumArray.length) {
            while(right < sumArray.length && sumArray[right] - sumArray[left] < s)
                right++;
            if(right < sumArray.length && sumArray[right] - sumArray[left] >= s && min > right - left)
                min = right - left;
            left++;
        }
        return min > 10000000 ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3,7};
        System.out.println(MinimumSizeSubarraySum.minSubArrayLen(7, nums));
    }

}
