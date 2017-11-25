package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2017/11/18.
 */
public class SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int result = 0;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= nums.length; i++) {
            for(int j = 0; j < nums.length; j++)
                dfs(lists, list, i, j, nums);
        }
        System.out.println(lists.size());
        for(List<Integer> li : lists) {
            int pro = 1;
            for(int num : li)
                pro *= num;
            if(pro < k && pro > -100000000) result++;
        }
        return result;
    }

    private static void dfs(List<List<Integer>> lists, List<Integer> list, int k, int index, int[] nums) {
        if(k == 0) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        if(index >= nums.length) return;
            list.add(nums[index]);
            dfs(lists, list, k - 1, index + 1, nums);
            list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3, 5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                10,9,10,4,3,8,3,3,6,2,10,10,9,3, 5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                10,9,10,4,3,8,3,3,6,2,10,10,9,3, 5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(SubarrayProductLessThanK.numSubarrayProductLessThanK(nums, 19));
    }

}
