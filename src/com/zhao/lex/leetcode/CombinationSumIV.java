package com.zhao.lex.leetcode;

import java.util.*;

/**
 * Created by qtfs on 2017/11/7.
 */
public class CombinationSumIV {
    public static List<List<Integer>> combinationSum4(int[] candidates, int target) {
        Arrays.sort(candidates);
        Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        return dfs(candidates, 0,target, map);
    }

    private static List<List<Integer>> dfs(int[] candidates, int index, int target, Map<Integer, List<List<Integer>>> map) {
        if(map.containsKey(target)) return map.get(target);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int j = index; j < candidates.length; j++) {
            int i = candidates[j];
            if (i == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                lists.add(list);
            } else if (i < target) {
                List<List<Integer>> subLists = dfs(candidates, index + 1, target - i, map);
                for (List<Integer> list : subLists) {
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(0, i);
                    lists.add(newList);

                }
            }
        }
        map.put(target, lists);
        return lists;
    }

    public static int combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i < nums[j]) break;
                else if(i == nums[j]) comb[i] += 1;
                else comb[i] += comb[i-nums[j]];
            }
        }
        return comb[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> lists = CombinationSumIV.combinationSum4(nums, 4);
        for(List<Integer> list : lists) {
            for(int i : list)
                System.out.print(String.format("%3d", i));
            System.out.println();
        }
    }
}
