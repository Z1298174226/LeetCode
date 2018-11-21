package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

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
        slow = n - 1;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 50000};
        for (int num : nums)
            num--;
        Arrays.stream(nums).forEach(s -> System.out.print(s + " "));
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
//        for(int i : list) {
//            if(i == 2)
//                list.remove((Integer) i);
//        }
    }
}
