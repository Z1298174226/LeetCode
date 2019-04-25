package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2019/2/26.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1; int end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == target)
                    return target;
                else {
                    if(Math.abs(sum - target) < Math.abs(result - target))
                        result = sum;
                    if(sum < target) start++;
                    else end--;
                }
            }
        }
        return result;
    }
}
