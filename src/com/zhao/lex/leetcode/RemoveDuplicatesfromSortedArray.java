package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/25.
 */
public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int result = nums.length;
        int left = 0;
        while(left < nums.length) {
            int right = left + 1;
            if(right < nums.length && nums[right] - nums[left] == 0)
                result--;
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
}
