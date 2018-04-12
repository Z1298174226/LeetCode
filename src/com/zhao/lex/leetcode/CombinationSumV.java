package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2018/3/25.
 */
public class CombinationSumV {
    public static List<List<Integer>> combinationSum3(int target, int[] combinations) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(lists, list, 0, target, combinations);
        System.out.println();
        return lists;
    }

    public static void dfs(List<List<Integer>> lists, List<Integer> list, int index, int target, int[] combinations) {
        if(target < 0) return;
        else if(target == 0) {
            lists.add(new ArrayList<Integer>(list));
        }
        else {
            for(int i = index; i < combinations.length; i++) {
                int value = combinations[i];
                list.add(combinations[i]);
                dfs(lists, list, i + 1, target - value, combinations);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] combination = new int[]{2, 3, 6, 7};
        combinationSum3(9, combination);
        System.out.println();
    }

}
