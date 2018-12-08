package com.zhao.lex.leetcode;

import java.util.Arrays;
/**
 * Created by qtfs on 2018/11/27.
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int len = nums.length;
        int first = Integer.MAX_VALUE; int last = Integer.MIN_VALUE;
        int start = 0; int end = len - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                first = Math.min(first, mid);
                end = mid - 1;
            }
            else if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        start = 0; end = len - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                last = Math.max(last, mid);
                start = mid + 1;
            }
            else if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        if(first != Integer.MAX_VALUE && last != Integer.MIN_VALUE)
            return new int[]{first, last};
        else
            return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        Arrays.stream(new FindFirstandLastPositionofElementinSortedArray().searchRange(nums, 2)).forEach(x -> System.out.println(x));
    }
}
