package com.zhao.lex.leetcode;

/**
 * Created by qtfs on 2017/11/25.
 */
public class FindtheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++)
            nums[i]--;
        int slow = n - 1;
        int fast = n - 1;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        slow = n-1;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 1, 2, 3, 3};
        System.out.println(findDuplicate(nums));
    }
}
