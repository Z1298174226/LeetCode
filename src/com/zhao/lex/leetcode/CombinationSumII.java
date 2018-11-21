package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/11/7.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(result, list, candidates, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] candidates, int index, int target) {
        if(target < 0) return;
        else if(target == 0) {
            List<Integer> newList = new ArrayList<Integer>(list);
            if(!result.contains(newList))
                result.add(newList);
        }
        else {
            for(int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                dfs(result, list, candidates, i + 1, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{17};
        List<List<Integer>> lists = new CombinationSumII().combinationSum2(nums, 170);
        for(List<Integer> list : lists) {
            for(int i : list)
                System.out.print(String.format("%3d", i));
            System.out.println();
        }
    }
}
