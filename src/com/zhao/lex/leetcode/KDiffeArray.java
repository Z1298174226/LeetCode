package com.zhao.lex.leetcode;

import java.util.Arrays;

/**
 * Created by qtfs on 2017/11/20.
 */
public class KDiffeArray {
    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0; int right = 1;
        int result = 0;
        while(left < nums.length) {
            right = left + 1;
            while(right < nums.length && nums[right] - nums[left] < k)
                right++;
            if(right < nums.length && nums[right] - nums[left] == k && left < right)
                if (left == 0 || nums[left] != nums[left - 1])
                    result++;
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3, 4, 5};
        System.out.println(KDiffeArray.findPairs(nums, 2));
    }
}
