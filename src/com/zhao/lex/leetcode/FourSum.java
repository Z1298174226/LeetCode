package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qtfs on 2018/11/13.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ret;
        }
        Arrays.sort(nums);
        dfs(nums, 0, target, 4, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void dfs(int[] nums, int start, int target, int k, List<Integer> cur, List<List<Integer>> ret) {
        if (k == 2) {
            twoSum(nums, start, nums.length - 1, target, cur, ret);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] * k > target || nums[nums.length - 1] * k < target)
                break;
            if (i > start && nums[i] == nums[i - 1])
                continue;
            cur.add(nums[i]);
            dfs(nums, i + 1, target - nums[i], k - 1, cur, ret);
            cur.remove(cur.size() - 1);
        }
    }

    private void twoSum(int[] nums, int start, int end, int target, List<Integer> cur, List<List<Integer>> ret) {
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                List<Integer> tmp = new ArrayList<>(cur);
                tmp.add(nums[start]);
                tmp.add(nums[end]);
                ret.add(tmp);
                while (start < end && nums[start] == nums[start + 1]) {
                    start ++;
                }
                while (start < end && nums[end] == nums[end - 1]) {
                    end --;
                }
                start ++;
                end --;
            } else if (sum < target) {
                start ++;
            } else {
                end --;
            }
        }
    }
}
