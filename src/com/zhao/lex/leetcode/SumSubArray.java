package com.zhao.lex.leetcode;

import java.util.ArrayList;

/**
 * Created by qtfs on 2018/11/21.
 */
public class SumSubArray {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(sum == 0) return result;
        for(int i = 1; i <= sum / 2; i++)
            dfs(result, list, sum, i);
        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int sum, int index) {
        if(sum < 0) return;
        if(sum == 0) {
            ArrayList<Integer> newList = new ArrayList<Integer>(list);
            result.add(newList);
            return;
        }
        list.add(index);
        dfs(result, list, sum - index, index + 1);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new SumSubArray().FindContinuousSequence(100));
    }
}
